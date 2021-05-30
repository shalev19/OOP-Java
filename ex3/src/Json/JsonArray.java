/**
Shalev Yohanan
May 15, 2021
*/
package Json;

import java.util.ArrayList;

public class JsonArray extends JsonValue {
    private ArrayList<JsonValue> arr;

    public JsonArray() {
    	arr = new ArrayList<>(); 
    }

    public void add(JsonValue val) {
    	arr.add(val);
    }

    @Override
    public JsonValue get(int i) throws JsonQueryException {
        if((i >= 0) && (i < this.arr.size())){  //check if index i is legal
            return arr.get(i);
        }
        else{
            throw new JsonQueryException("index out of bounds");  
        }

    }

    @Override
    public JsonValue get(String s) throws JsonQueryException { //arrayList dont have this method
        throw new JsonQueryException("JsonArray dont have the method: get(String s)");

    }

    @Override
    public String toString() { //make new string of the array like wanted format
        String str = "[";
        for (int i=0; i<arr.size(); i++) {
            if (i!=0)
            	str += ',';
            str +=  arr.get(i);
        }
        str += "]";
        return str;
    }
}
