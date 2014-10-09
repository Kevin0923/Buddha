package kevin.buddha.helper.json;

import org.json.JSONException;
import org.json.JSONObject;

public class JSONUtil {

    public static JSONObject toJSON(String jsonStr) {
        try {
            JSONObject object = new JSONObject(jsonStr);
            return object;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

}
