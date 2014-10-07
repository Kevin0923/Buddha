package kevin.buddha.activity.splash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import kevin.buddha.activity.R;
import kevin.buddha.activity.pray.PrayActivity;
import kevin.buddha.constant.Constants;
import kevin.buddha.constant.DBConstant;
import kevin.buddha.constant.KeyConstants;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class SplashActivity extends Activity implements OnPageChangeListener {
    private ViewPager viewPager;
    private ArrayList<View> list;
    private int maxSize = 0;
    private int currentItem = 0;

    private Dialog listDialog = null;
    private ListView listView = null;
    // 记录所有listview的item的数据
    private List<HashMap<String, Object>> mapLists = null;
    private SimpleAdapter adapter = null;
    private int buddhaCount = Constants.BUDDHA_NAME_RES_ID.length;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        SharedPreferences share = getSharedPreferences(DBConstant.SHARED_PATH, 0);
        currentItem = share.getInt(KeyConstants.SELECTED_BUDDHA_INDEX, 0);

        initial();

        // 第一次，查询，是否有选择了佛，如果有，是第几个。
        // 否则，点击【佛】字，弹出到列表
        if (currentItem == 0) {
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

        ViewGroup main = (ViewGroup) inflater.inflate(R.layout.splash_main, null);
        viewPager = (ViewPager) main.findViewById(R.id.splash_viewPager);

        setContentView(main);
        viewPager.setAdapter(new MyAdapter());
        viewPager.setOnPageChangeListener(new MyListener());

        inflater = LayoutInflater.from(this);
        View viewDialog = inflater.inflate(R.layout.splash_listdialog_container, null);
        Display display = this.getWindowManager().getDefaultDisplay();
        int width = display.getWidth();

        // 设置对话框的宽高
        LayoutParams layoutParams = new LayoutParams(width * 85 / 100, LayoutParams.WRAP_CONTENT);
        listDialog = new Dialog(this);
        listDialog.setTitle(R.string.splash_list_dialog_title);
        listDialog.setContentView(viewDialog, layoutParams);

        listView = (ListView) viewDialog.findViewById(R.id.splash_listdialog_container);
        mapLists = new ArrayList<HashMap<String, Object>>();
        // 设置一个默认值
        HashMap<String, Object> map = null;

        for (int i = 0; i < buddhaCount; i++) {
            map = new HashMap<String, Object>();
            map.put("item", getResources().getString(Constants.BUDDHA_NAME_RES_ID[i]));
            mapLists.add(map);
        }

        adapter = new SimpleAdapter(this, mapLists, R.layout.splash_listdialog_item, new String[] { "item" },
                new int[] { R.id.splash_listdialog_item });
        listView.setAdapter(adapter);
    }

    /**
     * 已选择佛像
     */
    private void hasSelected() {
        viewPager.setCurrentItem(currentItem);

    }

    /**
     * 未选择佛像
     */
    private void notSelected() {
        viewPager.setCurrentItem(0);
        // 显示提示
        Toast toast = Toast.makeText(getApplicationContext(), "点击屏幕中的【佛】或 左右滑动 选择佛像", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER | Gravity.TOP, 0, this.getWindowManager().getDefaultDisplay()
                .getHeight() / 2 - 50);
        toast.show();

    }

    private void showListDialog() {
        listDialog.show();

        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                System.out.println("pos : " + position + ", id : " + id);
                listDialog.dismiss();
                viewPager.setCurrentItem(position + 1);
            }
        });
    }

    private class MyAdapter extends PagerAdapter {
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

        }

        @Override
        public Parcelable saveState() {
            return null;
        }

        @Override
        public void startUpdate(View arg0) {

        }

        @Override
        public void finishUpdate(View arg0) {
        }
    }

    private class MyListener implements OnPageChangeListener {

        @Override
        public void onPageScrollStateChanged(int arg0) {
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
        }

        @Override
        public void onPageSelected(final int index) {
            // 初始页面的佛字、每个页面的佛 都有点击事件
            View view = list.get(index);
            view.findViewById(R.id.splash_fo).setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View arg0) {
                    showListDialog();
                }
            });

            // 12个佛像的按钮事件
            if (index > 0) {
                view.findViewById(R.id.splash_btn).setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View arg0) {
                        // 保存选择了的佛的下标索引
                        SharedPreferences share = getSharedPreferences(DBConstant.SHARED_PATH, 0);
                        Editor editor = share.edit();
                        editor.putInt(KeyConstants.SELECTED_BUDDHA_INDEX, index);
                        editor.commit();

                        // 跳转到拜佛页面
                        Intent intent = new Intent();
                        intent.setClass(SplashActivity.this, PrayActivity.class);
                        intent.putExtra(KeyConstants.SELECTED_BUDDHA_INDEX, index);
                        startActivity(intent);
                    }
                });
            }
        }
    }

    @Override
    public void onPageScrollStateChanged(int arg0) {
    }

    @Override
    public void onPageScrolled(int arg0, float arg1, int arg2) {
    }

    @Override
    public void onPageSelected(int arg0) {
    }
}
