package kevin.buddha.activity.splash;

import java.util.ArrayList;

import kevin.buddha.activity.R;
import kevin.buddha.constant.DBConstant;
import kevin.buddha.constant.KeyConstants;
import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Splash2Activity extends Activity implements OnPageChangeListener {
    ViewPager viewPager;
    ArrayList<View> list;
    ViewGroup main, group;
    ImageView imageView;
    ImageView[] imageViews;
    int maxSize = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        initial();

        // 第一次，查询，是否有选择了佛，如果有，是第几个。
        // 否则，点击【佛】字，弹出到列表
        SharedPreferences share = getSharedPreferences(DBConstant.SHARED_PATH, 0);
        if (share.getBoolean(KeyConstants.IS_SELECTED_BUDDHA, false)) {
            hasSelected();
        } else {
            notSelected();
        }
    }

    private void initial() {
        LayoutInflater inflater = getLayoutInflater();
        list = new ArrayList<View>();
        list.add(inflater.inflate(R.layout.splash_00, null));
        list.add(inflater.inflate(R.layout.splash_01, null));
        list.add(inflater.inflate(R.layout.splash_02, null));
        list.add(inflater.inflate(R.layout.splash_03, null));
        list.add(inflater.inflate(R.layout.splash_04, null));
        list.add(inflater.inflate(R.layout.splash_05, null));
        list.add(inflater.inflate(R.layout.splash_06, null));
        list.add(inflater.inflate(R.layout.splash_07, null));
        list.add(inflater.inflate(R.layout.splash_08, null));
        list.add(inflater.inflate(R.layout.splash_09, null));
        list.add(inflater.inflate(R.layout.splash_10, null));
        list.add(inflater.inflate(R.layout.splash_11, null));
        list.add(inflater.inflate(R.layout.splash_12, null));
        maxSize = list.size();

        imageViews = new ImageView[maxSize];
        ViewGroup main = (ViewGroup) inflater.inflate(R.layout.splash_main, null);
        viewPager = (ViewPager) main.findViewById(R.id.splash_viewPager);

        setContentView(main);
        viewPager.setAdapter(new MyAdapter());
        viewPager.setOnPageChangeListener(new MyListener());
        viewPager.setCurrentItem(0);
    }

    private void hasSelected() {

    }

    private void notSelected() {
        // 显示提示
        Toast toast = Toast.makeText(getApplicationContext(), "点击屏幕中的【佛】或 左右滑动 选择佛像",
                Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER | Gravity.TOP, 0, this.getWindowManager()
                .getDefaultDisplay().getHeight() / 2 - 50);
        toast.show();

        // // 设置事件
        // ImageView stoImage = (ImageView)
        // this.findViewById(R.id.splash_text_fo);
        // stoImage.setOnClickListener(new OnClickListener() {
        // @Override
        // public void onClick(View arg0) {
        // Intent intent = new Intent();
        // intent.setClass(Splash2Activity.this, BuddhaNameListDialog.class);
        // startActivity(intent);
        // }
        // });
    }

    class MyAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return maxSize;
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }

        @Override
        public int getItemPosition(Object object) {
            return super.getItemPosition(object);
        }

        @Override
        public void destroyItem(View arg0, int arg1, Object arg2) {
            ((ViewPager) arg0).removeView(list.get(arg1 % maxSize));
        }

        @Override
        public Object instantiateItem(View arg0, int arg1) {
            int pos = arg1 % maxSize;
            try {
                ((ViewPager) arg0).addView(list.get(pos), 0);
            } catch (Exception e) {
                // ignore
            }
            return list.get(pos);
        }

        @Override
        public void restoreState(Parcelable arg0, ClassLoader arg1) {
            // TODO Auto-generated method stub

        }

        @Override
        public Parcelable saveState() {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public void startUpdate(View arg0) {
            // TODO Auto-generated method stub

        }

        @Override
        public void finishUpdate(View arg0) {
            // TODO Auto-generated method stub

        }
    }

    class MyListener implements OnPageChangeListener {

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
            System.out.println("page selected, arg0 : " + arg0);

            addListener(arg0);
        }

        private void addListener(int index) {
            View view = list.get(index);
            int id = -1;
            if (index == 0) {
                view.findViewById(R.id.splash_text_fo).setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View arg0) {
                        System.out.println("点击佛字");
                    }
                });
            } else {
                view.findViewById(R.id.splash_btn).setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View arg0) {
                        System.out.println("OK, " + viewPager.getCurrentItem());
                    }
                });
            }
        }

    }

    @Override
    public void onPageScrollStateChanged(int arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onPageScrolled(int arg0, float arg1, int arg2) {

    }

    @Override
    public void onPageSelected(int arg0) {

    }
}
