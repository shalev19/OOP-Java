/**
Shalev Yohanan
May 15, 2021
*/
package Json;

public abstract class JsonValue {
    public abstract JsonValue get(int i) throws JsonQueryException;

    public abstract JsonValue get(String s) throws JsonQueryException;

}
