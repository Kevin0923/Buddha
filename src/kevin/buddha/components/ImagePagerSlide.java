package kevin.buddha.components;

import android.app.Activity;
import android.support.v4.view.ViewPager;

/**
 * 图片滑动组件
 * 
 * @author Kevin Lau
 * 
 */
public class ImagePagerSlide {
    private ViewPager vierPager = null;
    private int[] imgIds;// 要滚动
    private Activity activityObj;

    public ImagePagerSlide(int[] imgIds, int viewPagerId, Activity activity) {
        this.imgIds = imgIds;
        this.activityObj = activity;
        this.vierPager = (ViewPager) activityObj.findViewById(viewPagerId);
    }
}
