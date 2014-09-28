package kevin.buddha.activity.splash;

import kevin.buddha.activity.R;
import kevin.buddha.activity.release.ReleaseActivity;
import kevin.buddha.constant.DBConstant;
import kevin.buddha.helper.persist.PersistHelper;
import kevin.buddha.util.Global;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.Menu;

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        // 第一次，查询，是否有选择了佛，如果有，是第几个。
        // 否则，点击【佛】字，弹出到列表
        SharedPreferences share = getSharedPreferences(DBConstant.SHARED_PATH, 0);
        if (share.getBoolean("isSelectedBuddha", false)) {
            
        } else {
            
        }
    }

    private void first() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.start, menu);
        return true;
    }
}
