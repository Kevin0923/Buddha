package kevin.buddha.activity.splash;

import kevin.buddha.activity.R;
import kevin.buddha.constant.DBConstant;
import kevin.buddha.constant.KeyConstants;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.Toast;

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        // 第一次，查询，是否有选择了佛，如果有，是第几个。
        // 否则，点击【佛】字，弹出到列表
        SharedPreferences share = getSharedPreferences(DBConstant.SHARED_PATH, 0);
        if (share.getBoolean(KeyConstants.IS_SELECTED_BUDDHA, false)) {
            alreadySelected();
        } else {
            notYetSelected();
        }

    }

    private void alreadySelected() {

    }

    /**
     * 未请佛
     */
    private void notYetSelected() {
        // 显示提示
        showTips();
        // 设置事件
        ImageView stoImage = (ImageView) this.findViewById(R.id.splash_text_fo);
        stoImage.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent();
                intent.setClass(SplashActivity.this, BuddhaNameList.class);
                startActivity(intent);
            }
        });
    }

    private void showTips() {
        Toast toast = Toast.makeText(getApplicationContext(), "尚未请佛，点击屏幕中的【佛】字", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER | Gravity.TOP, 0, this.getWindowManager()
                .getDefaultDisplay().getHeight() / 2);
        toast.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.start, menu);
        return true;
    }
}
