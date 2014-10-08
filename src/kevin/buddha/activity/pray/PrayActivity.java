package kevin.buddha.activity.pray;

import kevin.buddha.activity.R;
import kevin.buddha.constant.DBConstant;
import kevin.buddha.constant.KeyConstants;
import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;

public class PrayActivity extends Activity {

    int[] menuIds = { R.id.pray_menu_00, R.id.pray_menu_01, R.id.pray_menu_03, R.id.pray_menu_04 };
    int[] menuDrawFocusIds = { R.drawable.pray_menu_00_focus, R.drawable.pray_menu_01_focus,
            R.drawable.pray_menu_03_focus, R.drawable.pray_menu_04_focus };
    int[] menuDrawBlurIds = { R.drawable.pray_menu_00_blur, R.drawable.pray_menu_01_blur,
            R.drawable.pray_menu_03_blur, R.drawable.pray_menu_04_blur };

    int[] foBigDrawIds = { R.drawable.fo_001_big_rl, R.drawable.fo_002_big_emtf, R.drawable.fo_003_big_ys,
            R.drawable.fo_004_big_gy, R.drawable.fo_005_big_ws, R.drawable.fo_006_big_ml,
            R.drawable.fo_007_big_szgy, R.drawable.fo_008_big_gey, R.drawable.fo_009_big_yuelao,
            R.drawable.fo_010_big_mazu, R.drawable.fo_011_big_wencs, R.drawable.fo_012_big_wqxj };
    int[] foNameDrawIds = { R.drawable.fo_001_name_rl, R.drawable.fo_002_name_emtf,
            R.drawable.fo_003_name_ys, R.drawable.fo_004_name_gy, R.drawable.fo_005_name_ws,
            R.drawable.fo_006_name_ml, R.drawable.fo_007_name_szgy, R.drawable.fo_008_name_gey,
            R.drawable.fo_009_name_yuelao, R.drawable.fo_010_name_mazu, R.drawable.fo_011_name_wencs,
            R.drawable.fo_012_name_wqxj };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pray);
        showElements();
        addClickEvents();
    }

    private void showElements() {
        SharedPreferences share = getSharedPreferences(DBConstant.SHARED_PATH, 0);
        int buddhaIndex = share.getInt(KeyConstants.SELECTED_BUDDHA_INDEX, 0);
        // 在初始页面 进入此界面的index都是从1-12开始算
        // 因为初始页面index=0的页面是佛字页
        buddhaIndex--;

        // 名称
        ImageView nameBoard = (ImageView) this.findViewById(R.id.pray_buddha_name_img);
        nameBoard.setImageDrawable(getResources().getDrawable(foNameDrawIds[buddhaIndex]));

        // 佛像
        ImageView buddhaImg = (ImageView) this.findViewById(R.id.pray_buddha_big_img);
        buddhaImg.setImageDrawable(getResources().getDrawable(foBigDrawIds[buddhaIndex]));
    }

    private void addClickEvents() {
        footMenu();
        fingger();
    }

    private void fingger() {
        ImageView fingger = (ImageView) this.findViewById(R.id.pray_buddha_fingger);
        fingger.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View arg0, MotionEvent arg1) {
                // TODO 佛手事件
                return false;
            }
        });
    }

    private void footMenu() {
        // 菜单栏
        for (int i = 0; i < menuIds.length; i++) {
            ImageView btn = (ImageView) this.findViewById(menuIds[i]);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View arg0) {
                }
            });
            btn.setOnTouchListener(new MenuTouchListener(i));
        }
    }

    class MenuTouchListener implements View.OnTouchListener {
        int index = 0;

        public MenuTouchListener(int index) {
            this.index = index;
        }

        public boolean onTouch(View v, MotionEvent event) {
            System.out.println("event.getAction : " + event);
            // 重新设置按下时的背景图片
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                ((ImageView) v).setImageDrawable(getResources().getDrawable(menuDrawFocusIds[index]));
            } else if (event.getAction() == MotionEvent.ACTION_UP) { //
                // 再修改为抬起时的正常图片
                ((ImageView) v).setImageDrawable(getResources().getDrawable(menuDrawBlurIds[index]));
            }
            return false;
        }
    }
}
