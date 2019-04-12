package wandroid.group4.com.myapplication.component;

import android.text.TextUtils;

import io.reactivex.subscribers.ResourceSubscriber;
import wandroid.group4.com.myapplication.base.interfaces.IBaseview;


public abstract class CommonSubscriber<T> extends ResourceSubscriber<T> {

    private IBaseview mView;
    private String errorMsg;
    private boolean isShowErrorState = false;

    protected CommonSubscriber(IBaseview view){
        mView = view;
    }

    protected CommonSubscriber(IBaseview view, String emsg){
        mView = view;
        errorMsg = emsg;
    }

    protected CommonSubscriber(IBaseview view, boolean isError){
        mView = view;
        isShowErrorState = isError;
    }

    protected CommonSubscriber(IBaseview view, String emsg, boolean isError){
        mView = view;
        errorMsg = emsg;
        isShowErrorState = isError;
    }

    @Override
    public void onError(Throwable t) {
        if(mView == null) return;
        if(errorMsg != null && TextUtils.isEmpty(errorMsg)){
            mView.showDataError(errorMsg);
        }
    }

    @Override
    public void onComplete() {

    }
}
