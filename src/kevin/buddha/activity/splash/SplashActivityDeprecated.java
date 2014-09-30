package kevin.buddha.activity.splash;

import kevin.buddha.activity.R;
import kevin.buddha.constant.DBConstant;
import kevin.buddha.constant.KeyConstants;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.Toast;

public class SplashActivityDeprecated extends Activity implements OnPageChangeListener {

    private ViewPager viewPager;
    private ImageView[] mImageViews;
    private int[] imgIdArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        // 第一次，查询，是否有选择了佛，如果有，是第几个。
        // 否则，点击【佛】字，弹出到列表
        SharedPreferences share = getSharedPreferences(DBConstant.SHARED_PATH, 0);
        if (share.getInt(KeyConstants.SELECTED_BUDDHA_INDEX, 0) == 0) {
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
                intent.setClass(SplashActivityDeprecated.this, BuddhaNameListDialog.class);
                startActivity(intent);
            }
        });

        // 将图片装载到数组中
        mImageViews = new ImageView[imgIdArray.length];
        for (int i = 0; i < mImageViews.length; i++) {
            ImageView imageView = new ImageView(this);
            mImageViews[i] = imageView;
            imageView.setBackgroundResource(imgIdArray[i]);
        }

        // 设置Adapter
        viewPager.setAdapter(new MyAdapter());
        // 设置监听，主要是设置点点的背景
        viewPager.setOnPageChangeListener(this);
        // 设置ViewPager的默认项, 设置为长度的20倍，这样子开始就能往左滑动
        viewPager.setCurrentItem((mImageViews.length) * 20);
    }

    private void showTips() {
        Toast toast = Toast.makeText(getApplicationContext(), "点击屏幕中的【佛】或 左右滑动 选择佛像", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER | Gravity.TOP, 0, this.getWindowManager().getDefaultDisplay()
                .getHeight() / 2 - 50);
        toast.show();
    }

    public class MyAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return Integer.MAX_VALUE;
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }

        @Override
        public void destroyItem(View container, int position, Object object) {
            ((ViewPager) container).removeView(mImageViews[position % mImageViews.length]);
        }

        /**
         * 载入图片进去，用当前的position 除以 图片数组长度取余数是关键
         */
        @Override
        public Object instantiateItem(View container, int position) {
            ((ViewPager) container).addView(mImageViews[position % mImageViews.length], 0);
            return mImageViews[position % mImageViews.length];
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.start, menu);
        return true;
    }

    @Override
    public void onPageScrollStateChanged(int arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onPageScrolled(int arg0, float arg1, int arg2) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onPageSelected(int arg0) {
        System.out.println("page is selected : " + arg0);
    }
}
