/**
Shalev Yohanan
May 15, 2021
 */
package Json;

import java.util.HashMap;
import java.util.Map;

public  class JsonObject extends JsonValue {
	private Map<String, JsonValue> map;

	public JsonObject() {
		map = new HashMap<String, JsonValue>(); 
	}

	public Object put(String str, JsonValue val) {
		return map.put(str, val); 
	}

	@Override
	public JsonValue get(int i) throws JsonQueryException {
		throw new JsonQueryException("JsonObject doesn't have the method: get(int i)");

	}

	@Override
	public JsonValue get(String s) throws JsonQueryException {
		if (!map.containsKey(s))  //key doesn't exist
			throw new JsonQueryException("Json Key error");
		else
			return map.get(s);
	}

	@Override
	public String toString() {
		String str = new String();
		int i = 0;
		str += "{";
		for (String key : map.keySet()) {
			str +=key + ":" + map.get(key);
			if(i != map.size()-1) {
				str += "\n";
			}
			i++;

		}
		str += "}";
		return str;
	}
}


