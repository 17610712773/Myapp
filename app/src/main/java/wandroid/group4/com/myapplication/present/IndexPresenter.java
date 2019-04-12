package wandroid.group4.com.myapplication.present;

import wandroid.group4.com.myapplication.Util.RxUtils;
import wandroid.group4.com.myapplication.base.basepresent.Basepresent;
import wandroid.group4.com.myapplication.base.interfaces.index.Indexcontract;
import wandroid.group4.com.myapplication.component.CommonSubscriber;
import wandroid.group4.com.myapplication.modlue.bean.Index;
import wandroid.group4.com.myapplication.modlue.http.HttpManager;

/**
 * @author T-sy
 * @description:
 * @date :2019/4/12 16:20
 */
public class IndexPresenter extends Basepresent<Indexcontract.View> implements Indexcontract.Presenter {
    @Override
    public void getindex() {
        addSubscribe(HttpManager.getApizhishi().getindex()
        .compose(RxUtils.<Index>rxScheduler())
        .subscribeWith(new CommonSubscriber<Index>(mView) {
            @Override
            public void onNext(Index index) {
                mView.showindex(index);
            }

            @Override
            public void onError(Throwable t) {
                super.onError(t);
            }
        }));
    }
}
