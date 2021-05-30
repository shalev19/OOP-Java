/**
Shalev Yohanan
May 14, 2021
 */
package Json;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;

public class JsonBuilder extends JsonValue{
	private final CharScanner sc; 
	private final JsonValue v; 

	public JsonBuilder(File file) throws FileNotFoundException, JsonSyntaxException {
		sc = new CharScanner(file);
		v = parseValue();
	}

	public JsonValue parseValue() throws JsonSyntaxException{ //check the type of object
		if (sc.hasNext()) {
			char c = sc.peek();
			if (c == '{') {
				return parseObject(); 
			}
			if (c == '"') {
				return parseString(); 
			}
			if (Character.isDigit(c) || c == '-') {
				return parseNumber();
			}
			if (c == '[') {
				return parseArray();
			}
		}
		throw new JsonSyntaxException("The first Character is illegal");
	}
	
	public JsonString parseString() throws JsonSyntaxException {
        String str = "";
        char c;
        
        
        sc.next(); //ignore the '"' character
        while ((c = sc.next()) != '"') {
            if(c == '\\'){
                c = sc.next();
            }
            str += c;
        }
        return new JsonString(str);
    }
	
	public JsonArray parseArray() throws JsonSyntaxException {
        JsonArray jsonArr = new JsonArray();
        sc.next(); // ignore the character '['
        
        
        while (sc.peek() != ']') {
            jsonArr.add(parseValue()); //send to check whats inside the array
            if (sc.peek() == ',') {
                sc.next(); // ignore the ',' character
            }
        }
        sc.next(); // ignore the ']' character
        return jsonArr;
    }
	
	public JsonNumber parseNumber() throws JsonSyntaxException {
        String s = "";
        char c;


        while (sc.hasNext() && (Character.isDigit(c = sc.peek()) || Character.isAlphabetic(c) || c == '.' || c == '-' || c=='+' || c == 'e' || c == 'E')) {
            c = sc.next();
            s += c;
        }
        
        try {
            return new JsonNumber(s); //send the string number to parse test
        }
        catch (NumberFormatException | ParseException e){
            throw new JsonSyntaxException("Parse number failed");
        }
    }

	public JsonObject parseObject() throws JsonSyntaxException {
		JsonObject obj = new JsonObject(); // create new Jsonobject
		char c;
		sc.next();
		String key = "";


		while ((c = sc.peek()) != '}') {
			if (c == ' ' || c == '"') { //ignore this characters
				sc.next();
			} 
			
			else if (sc.peek() != ':') {
				key += sc.next();
			} 
			
			else{
				sc.next(); //ignore the ':' character
				obj.put(key, parseValue());
				key = ""; // initial the key string
			}
			if ((sc.peek()) == ',') {
				sc.next(); 
			}
		}

		sc.next(); //ignore the ']' character
		return obj;
	}
	
	@Override
    public JsonValue get(int i) throws JsonQueryException {
        return v.get(i);
    }

	@Override
    public JsonValue get(String s) throws JsonQueryException {
        try {
            return v.get(s);
        }
        catch (NullPointerException e){
            throw new JsonQueryException("Key wasnt found");
        }
    }
	
	@Override
    public String toString() {
        return  v.toString();
    }

}
