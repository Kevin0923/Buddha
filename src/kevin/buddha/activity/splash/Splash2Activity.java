package kevin.buddha.activity.splash;

import java.util.ArrayList;

import kevin.buddha.activity.R;
import android.app.Activity;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;

public class Splash2Activity extends Activity implements OnPageChangeListener {
    ViewPager viewPager;
    ArrayList<View> list;
    ViewGroup main, group;
    ImageView imageView;
    ImageView[] imageViews;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
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

        imageViews = new ImageView[list.size()];
        ViewGroup main = (ViewGroup) inflater.inflate(R.layout.splash_main, null);
        viewPager = (ViewPager) main.findViewById(R.id.splash_viewPager);
        setContentView(main);

        viewPager.setAdapter(new MyAdapter());
        viewPager.setOnPageChangeListener(new MyListener());
    }

    class MyAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }

        @Override
        public int getItemPosition(Object object) {
            // TODO Auto-generated method stub
            return super.getItemPosition(object);
        }

        @Override
        public void destroyItem(View arg0, int arg1, Object arg2) {
            // TODO Auto-generated method stub
            ((ViewPager) arg0).removeView(list.get(arg1));
        }

        @Override
        public Object instantiateItem(View arg0, int arg1) {
            // TODO Auto-generated method stub
            ((ViewPager) arg0).addView(list.get(arg1));
            return list.get(arg1);
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
        }

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
        // TODO Auto-generated method stub

    }
}
