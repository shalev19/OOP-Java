/**
Shalev Yohanan
May 19, 2021
 */
package Json;

import java.text.NumberFormat;
import java.text.ParseException;

public class JsonNumber extends JsonValue {
	Number num;

	
	public JsonNumber(String num) throws ParseException, NumberFormatException {
        try{           
            string_check(num);            
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
            System.exit(1);
        }
        
        
        Double d;
        String numCheck = num;
        boolean negative = false;
        boolean e = false;
        
        
        if (num.startsWith("-")) { 
            negative = true;
            numCheck = num.substring(1);
        }
        
        if (numCheck.contains("-") || numCheck.contains("+")) { 
        	e = true;
        }
        
        if (e) {
            d = Double.valueOf(numCheck);
            this.num = d;
        } else 
        	this.num = NumberFormat.getInstance().parse(numCheck);  

        String value = this.num.getClass().getSimpleName();   
        
        if (negative) {
            if (value.equals("Long")) {
                this.num = this.num.longValue() * (-1);
            }
            if (value.equals("Double")) {
                this.num = this.num.doubleValue() * (-1);
            }
        }
    }

	private void string_check(String str) throws JsonSyntaxException {  //check if the number is legal.
		int eCnt = 0;
		int signCnt = 0;
		int indexOfE = 0;


		if(str.equals("0") || str.equals("-0"))
			return;

		if ((str.charAt(0) != '-') && (!Character.isDigit(str.charAt(0)))) { 
			throw new JsonSyntaxException("Number need to start with digit or '-'");
		}
		if (str.charAt(0) == '0' && (str.charAt(1) != '.')) {  
			throw new JsonSyntaxException("After '0' needs to be '.'");
		}
		if ((str.charAt(0) == '-') && (str.charAt(1)=='0') && (str.charAt(2)!='.'))
			throw new JsonSyntaxException("zero in the beggining of whole part");

		for (int i = 1; i < str.length(); i++) {
			char c = str.charAt(i); 

			if (Character.isAlphabetic(c) && c!='E' && c!='e'){
				throw new JsonSyntaxException("Only the letter 'e' and 'E' allowed");
			}

			if ((c == 'e') || c == 'E') { //count the 'e' and 'E' shows
				indexOfE = i;                     
				eCnt++;
			}

			if (eCnt > 1) {
				throw new JsonSyntaxException("Only one show of 'E' or 'e' allowed");
			}

			if ((c == '-') || (c == '+')) {
				signCnt++;
			}
			
			if (signCnt > 1) {
				throw new JsonSyntaxException("Too much sign characters in the number");
			}
		}//for loop
		if (signCnt == 1) { //check if the sign comes after the 'e' or 'E' character
			char sign = str.charAt(indexOfE+1);
			
			if(((sign != '-') && (sign != '+'))){
				throw new JsonSyntaxException("The sign Character can be at the start and the end of number only");
			}
		}
	}

	@Override
	public JsonValue get(int i) throws JsonQueryException {
		throw new JsonQueryException("JsonNumber dont have the method: get(int i)");
	}

	@Override
	public JsonValue get(String s) throws JsonQueryException {
		throw new JsonQueryException("JsonNumber dont have the method: get(String s)");
	}

	public String toString() {
		return num.toString();
	}
}
