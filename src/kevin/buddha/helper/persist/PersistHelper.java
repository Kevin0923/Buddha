package kevin.buddha.helper.persist;

import java.util.Set;

import kevin.buddha.constant.DBConstant;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class PersistHelper extends Activity {
    private static PersistHelper instance = null;
    private static SharedPreferences share = null;
    private static Activity activity;
    private PersistHelper() {
    }

    public static PersistHelper getInstance(Activity act) {
        System.out.println("instance : " + instance);
        System.out.println("activity : " + activity);
        if (null == instance) {
            instance = new PersistHelper();
            activity = act;
            share = activity.getSharedPreferences(DBConstant.SHARED_PATH, MODE_PRIVATE);
        }
        return instance;
    }

    public Editor getEditor() {
        if (null == instance) {
            PersistHelper.getInstance(this);
        }
        return share.edit();
    }

    public boolean getBoolean(String key) {
        return share.getBoolean(key, false);
    }

    public float getFloat(String key) {
        return share.getFloat(key, 0);
    }

    public int getInt(String key) {
        return share.getInt(key, 0);
    }

    public long getLong(String key) {
        return share.getLong(key, 0);
    }

    public String getString(String key) {
        return share.getString(key, null);
    }

    public Set<String> getStringSet(String key) {
        return share.getStringSet(key, null);
    }

    public void putBoolean(String key, boolean value) {
        Editor e = share.edit();
        e.putBoolean(key, value);
        e.commit();
    }

    public void putFloat(String key, float value) {
        Editor e = share.edit();
        e.putFloat(key, value);
        e.commit();
    }

    public void putInt(String key, int value) {
        Editor e = share.edit();
        e.putInt(key, value);
        e.commit();
    }

    public void putLong(String key, Long value) {
        Editor e = share.edit();
        e.putLong(key, value);
        e.commit();
    }

    public void putString(String key, String value) {
        Editor e = share.edit();
        e.putString(key, value);
        e.commit();
    }

    public void putStringSet(String key, Set<String> value) {
        Editor e = share.edit();
        e.putStringSet(key, value);
        e.commit();
    }
}
