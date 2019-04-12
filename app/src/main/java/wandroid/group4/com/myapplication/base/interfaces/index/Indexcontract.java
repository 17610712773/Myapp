package wandroid.group4.com.myapplication.base.interfaces.index;

import wandroid.group4.com.myapplication.base.interfaces.IBasepresenter;
import wandroid.group4.com.myapplication.base.interfaces.IBaseview;
import wandroid.group4.com.myapplication.modlue.bean.Index;

/**
 * @author T-sy
 * @description:
 * @date :2019/4/12 16:15
 */
public interface Indexcontract {
    interface View extends IBaseview{
        void showindex(Index index);
    }
    interface Presenter extends IBasepresenter<View>{
        void getindex();
    }
}
