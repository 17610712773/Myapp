package wandroid.group4.com.myapplication.base.baseactivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import wandroid.group4.com.myapplication.Util.SystemUtil;
import wandroid.group4.com.myapplication.base.interfaces.IBasepresenter;
import wandroid.group4.com.myapplication.base.interfaces.IBaseview;

public abstract class BaseActivity<V extends IBaseview,P extends IBasepresenter>extends AppCompatActivity implements IBaseview {
    protected AppCompatActivity appCompatActivity;
    protected Context context;
    private SharedPreferences sp; //sp本地数据保存类
    protected String uid; //用户的UID
    protected P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        appCompatActivity = this;
        context = this;
        if(!SystemUtil.isMobileNetworkConnected()){
            showNetWorkErorr();
        }else {
            presenter = createPresenter();
            presenter.attchView(this);
            initView();
            initData();
        }
    }

    //获取布局的id
    protected abstract int getLayout();
    //初始化p层
    protected abstract P createPresenter();

    //初始化数据
    protected abstract void initData();

    //初始化界面findViewById
    protected abstract void initView();

    @Override
    protected void onResume() {
        super.onResume();
        if(presenter!=null){
            presenter.attchView(this);

        }
    }

    @Override
    public void showDataError(String tips) {

    }

    @Override
    public void showNetWorkErorr() {

    }

    @Override
    public void showLoading() {

    }
    //界面释放
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(presenter!=null){
            presenter.detachView();
        }
    }
}
