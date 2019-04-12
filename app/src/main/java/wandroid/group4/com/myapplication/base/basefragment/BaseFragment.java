package wandroid.group4.com.myapplication.base.basefragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import wandroid.group4.com.myapplication.Util.SystemUtil;
import wandroid.group4.com.myapplication.base.interfaces.IBasepresenter;
import wandroid.group4.com.myapplication.base.interfaces.IBaseview;


public abstract class BaseFragment<P extends IBasepresenter>extends Fragment implements IBaseview {

    protected Context context;

    protected P presenter;

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(presenter != null && isVisibleToUser){
            initData();
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayout(),null);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(!SystemUtil.isMobileNetworkConnected()){
            showNetWorkErorr();
        }else{
            presenter = createPresenter();
            presenter.attchView(this);
            initView(view);
            initData();
        }
    }


    protected abstract int getLayout();

    protected abstract P createPresenter();

    protected abstract void initView(View view);

    protected abstract void initData();




    @Override
    public void showDataError(String tips) {

    }

    @Override
    public void showNetWorkErorr() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void onResume() {
        super.onResume();
        if(presenter != null){
            presenter.attchView(this);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(presenter != null){
            presenter.detachView();
        }
    }


}
