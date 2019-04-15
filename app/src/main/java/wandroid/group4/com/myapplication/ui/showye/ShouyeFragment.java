package wandroid.group4.com.myapplication.ui.showye;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import wandroid.group4.com.myapplication.R;
import wandroid.group4.com.myapplication.base.basefragment.BaseFragment;
import wandroid.group4.com.myapplication.base.interfaces.index.Indexcontract;
import wandroid.group4.com.myapplication.modlue.bean.Index;
import wandroid.group4.com.myapplication.present.IndexPresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShouyeFragment extends BaseFragment<IndexPresenter> implements Indexcontract.View {


    @BindView(R.id.banner)
    Banner banner;
    Unbinder unbinder;
    private List<String> mStringList= new ArrayList<>();

    @Override
    protected int getLayout() {
        return R.layout.fragment_shouye;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bann(mStringList);
    }

    @Override
    protected IndexPresenter createPresenter() {
        return new IndexPresenter();
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected void initData() {
        presenter.getindex();
    }

    @Override
    public void showindex(Index index) {
        List<Index.DataBean.BannerBean> banner = index.getData().getBanner();
        for (int i=0 ;i<banner.size();i++){
            mStringList.add(banner.get(i).getImage_url());
        }
    }

    public void bann(List<String> list) {
        //把创建的数据源传过来   list
        banner.setImages(list);
        banner.setImageLoader(new MyLoader());
        //设置banner的自动轮播时间
        banner.setDelayTime(2000);
        //设置banner是否自动轮播
        banner.isAutoPlay(true);
        //banner设置点击事件
        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {

            }
        });
        //开启banner
        banner.start();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    private class MyLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context.getApplicationContext())
                    .load((String) path)
                    .into(imageView);
        }
    }


}
