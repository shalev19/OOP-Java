/**
Shalev Yohanan
May 19, 2021
*/
package Json;

public class JsonString extends JsonValue {
    private String str;

    public JsonString(String str) {
        this.str = str;
    }

    @Override
    public JsonValue get(int i) throws JsonQueryException {
        throw new JsonQueryException("JsonString dont have the method: get(int i)");

    }

    @Override
    public JsonValue get(String str) throws JsonQueryException {
        throw new JsonQueryException("JsonString dont have the method: get(String s)");

    }

    @Override
    public String toString() {
        return str;
    }
}