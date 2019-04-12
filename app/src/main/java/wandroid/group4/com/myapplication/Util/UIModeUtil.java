package wandroid.group4.com.myapplication.Util;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;

public class UIModeUtil {

    /**
     * 夜间模式切换
     */
    public static void changeModeUI(AppCompatActivity activity){
        int currentNightMode = activity.getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
        if(currentNightMode == Configuration.UI_MODE_NIGHT_NO){
            activity.getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            SharedPreferencesUtil.addModeUI(activity.getBaseContext(),true);
        }else{
            activity.getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            SharedPreferencesUtil.addModeUI(activity.getBaseContext(),false);
        }
    }

    /**
     * 显示当前的模式
     * @param activity
     * @param mode
     */
    public static void showModeUI(AppCompatActivity activity, int mode){
        activity.getDelegate().setLocalNightMode(mode);
    }
}
