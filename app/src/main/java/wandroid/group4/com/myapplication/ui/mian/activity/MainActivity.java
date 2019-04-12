package wandroid.group4.com.myapplication.ui.mian.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import wandroid.group4.com.myapplication.R;
import wandroid.group4.com.myapplication.ui.fenlei.FenleiFragment;
import wandroid.group4.com.myapplication.ui.gouwuche.GouwucheFragment;
import wandroid.group4.com.myapplication.ui.mian.adapter.Tabadapter;
import wandroid.group4.com.myapplication.ui.showye.ShouyeFragment;
import wandroid.group4.com.myapplication.ui.wode.WodeFragment;
import wandroid.group4.com.myapplication.ui.zhuanti.ZhuantiFragment;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.views)
    ViewPager views;
    @BindView(R.id.tab)
    TabLayout tab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        List<Fragment> list = new ArrayList<>();
        list.add(new ShouyeFragment());
        list.add(new ZhuantiFragment());
        list.add(new FenleiFragment());
        list.add(new GouwucheFragment());
        list.add(new WodeFragment());
        List<String> list1 = new ArrayList<>();
        list1.add("首页");
        list1.add("专题");
        list1.add("分类");
        list1.add("购物车");
        list1.add("我的");
        views.setAdapter(new Tabadapter(getSupportFragmentManager(),list,list1));
        tab.setupWithViewPager(views);
    }
}
