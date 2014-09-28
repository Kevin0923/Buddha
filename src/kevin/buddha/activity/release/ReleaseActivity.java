package kevin.buddha.activity.release;

import kevin.buddha.constant.DBConstant;
import kevin.buddha.util.Global;
import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;

public class ReleaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences share = getSharedPreferences(DBConstant.SHARED_PATH, 0);
        String word = share.getString("hello", "empty in ReleaseActivity");
        System.out.println("word : " + word);

        if (!Global.isSelectedBuddha) {
            share.edit().putBoolean("isSelectedBuddha", true);
            share.edit().commit();
        }
    }

}
