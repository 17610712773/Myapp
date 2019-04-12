package wandroid.group4.com.myapplication.ui.mian.adapter;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * @author T-sy
 * @description:
 * @date :2019/4/12 15:25
 */
public class Tabadapter extends FragmentPagerAdapter {
    List<Fragment> mFragmentList;
    List<String> mStringList;

    public Tabadapter(FragmentManager fm, List<Fragment> fragmentList, List<String> stringList) {
        super(fm);
        mFragmentList = fragmentList;
        mStringList = stringList;
    }

    @Override
    public Fragment getItem(int i) {
        return mFragmentList.get(i);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mStringList.get(position);
    }
}
