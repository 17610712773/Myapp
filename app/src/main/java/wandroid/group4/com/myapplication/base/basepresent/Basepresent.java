package wandroid.group4.com.myapplication.base.basepresent;



import java.lang.ref.WeakReference;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import wandroid.group4.com.myapplication.base.interfaces.IBasepresenter;
import wandroid.group4.com.myapplication.base.interfaces.IBaseview;
import wandroid.group4.com.myapplication.component.RxBus;

public class Basepresent<V extends IBaseview> implements IBasepresenter<V> {

    //当前的view
    protected  V mView;
    private WeakReference<V> weakReference;
    //rxjava数据加载相关（处理rxjava被压式产生的内存泄露）m层
    protected CompositeDisposable compositeDisposable;


    @Override
    public void attchView(V mview) {
        weakReference = new WeakReference<V>(mview);
        this.mView  = weakReference.get();
    }

    @Override
    public void detachView() {
        this.mView = null;
        unSubscribe();
    }

    //解绑观察者和被观察者
    private void unSubscribe() {
        if(compositeDisposable!=null){
            compositeDisposable.clear();
        }
    }
    //添加观察者和被观察者的操作类
    protected void addSubscribe(Disposable disposable){
        if(compositeDisposable == null){
            compositeDisposable = new CompositeDisposable();
        }
    }
    //addSubscribe
    //添加带事件的观察者和被观察者
    protected <E> void addRxBusSubsrube(Class<E>evenType,Consumer<E> consumer){
        if(compositeDisposable == null) compositeDisposable = new CompositeDisposable();
        compositeDisposable.add(RxBus.getDefault().toDefaultFlowable(evenType,consumer));
    }

}
