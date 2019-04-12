package wandroid.group4.com.myapplication.Util;

import android.util.DisplayMetrics;

import wandroid.group4.com.myapplication.app.MyApp;


/**
 * Created by Administrator on 2019/4/1.
 */

public class DensityUtils {


    private static float getDesity() {
        DisplayMetrics displayMetrics = MyApp.getAppContext().getResources().getDisplayMetrics();
        return displayMetrics.density;
    }

    public static float dp2px(float dp) {
        return dp * getDesity();
    }

    public static float px2dp(float px) {
        return px / getDesity();
    }

}

