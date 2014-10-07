package kevin.buddha.activity.pray;

import kevin.buddha.activity.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class PrayActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pray);
        addClickEvents();
    }

    int index = 0;

    private void addClickEvents() {
        // ImageView btn00 = (ImageView) this.findViewById(R.id.pray_menu_00);
        // btn00.setOnClickListener(new View.OnClickListener() {
        // @Override
        // public void onClick(View arg0) {
        // }
        // });
        // btn00.setOnTouchListener(new View.OnTouchListener() {
        // public boolean onTouch(View v, MotionEvent event) {
        // System.out.println("event.getAction : " + event);
        // // 重新设置按下时的背景图片
        // if (event.getAction() == MotionEvent.ACTION_DOWN) {
        // ((ImageView) v).setImageDrawable(getResources()
        // .getDrawable(R.drawable.pray_menu_00_focus));
        // } else if (event.getAction() == MotionEvent.ACTION_UP) { //
        // 再修改为抬起时的正常图片
        // ((ImageView) v)
        // .setImageDrawable(getResources().getDrawable(R.drawable.pray_menu_00_blur));
        // }
        // return false;
        // }
        // });
        // ImageView btn01 = (ImageView) this.findViewById(R.id.pray_menu_01);
        // btn01.setOnTouchListener(new View.OnTouchListener() {
        // public boolean onTouch(View v, MotionEvent event) {
        // // 重新设置按下时的背景图片
        // if (event.getAction() == MotionEvent.ACTION_DOWN) {
        // ((ImageView) v).setImageDrawable(getResources()
        // .getDrawable(R.drawable.pray_menu_01_focus));
        // } else if (event.getAction() == MotionEvent.ACTION_UP) { //
        // 再修改为抬起时的正常图片
        // ((ImageView) v)
        // .setImageDrawable(getResources().getDrawable(R.drawable.pray_menu_01_blur));
        // }
        // return false;
        // }
        // });
        // ImageView btn02 = (ImageView) this.findViewById(R.id.pray_menu_02);
        // btn02.setOnTouchListener(new View.OnTouchListener() {
        // public boolean onTouch(View v, MotionEvent event) {
        // // 重新设置按下时的背景图片
        // if (event.getAction() == MotionEvent.ACTION_DOWN) {
        // ((ImageView) v).setImageDrawable(getResources()
        // .getDrawable(R.drawable.pray_menu_02_focus));
        // } else if (event.getAction() == MotionEvent.ACTION_UP) { //
        // 再修改为抬起时的正常图片
        // ((ImageView) v)
        // .setImageDrawable(getResources().getDrawable(R.drawable.pray_menu_02_blur));
        // }
        // return false;
        // }
        // });
        // ImageView btn03 = (ImageView) this.findViewById(R.id.pray_menu_03);
        // btn03.setOnTouchListener(new View.OnTouchListener() {
        // public boolean onTouch(View v, MotionEvent event) {
        // // 重新设置按下时的背景图片
        // if (event.getAction() == MotionEvent.ACTION_DOWN) {
        // ((ImageView) v).setImageDrawable(getResources()
        // .getDrawable(R.drawable.pray_menu_03_focus));
        // } else if (event.getAction() == MotionEvent.ACTION_UP) { //
        // 再修改为抬起时的正常图片
        // ((ImageView) v)
        // .setImageDrawable(getResources().getDrawable(R.drawable.pray_menu_03_blur));
        // }
        // return false;
        // }
        // });
        // ImageView btn04 = (ImageView) this.findViewById(R.id.pray_menu_04);
        // btn04.setOnTouchListener(new View.OnTouchListener() {
        // public boolean onTouch(View v, MotionEvent event) {
        // // 重新设置按下时的背景图片
        // if (event.getAction() == MotionEvent.ACTION_DOWN) {
        // ((ImageView) v).setImageDrawable(getResources()
        // .getDrawable(R.drawable.pray_menu_04_focus));
        // } else if (event.getAction() == MotionEvent.ACTION_UP) { //
        // 再修改为抬起时的正常图片
        // ((ImageView) v)
        // .setImageDrawable(getResources().getDrawable(R.drawable.pray_menu_04_blur));
        // }
        // return false;
        // }
        // });
    }
}
