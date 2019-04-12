package wandroid.group4.com.myapplication.base.interfaces;

public interface IBasepresenter<V extends IBaseview> {
    //关联
    void attchView(V mview);
    //取关
    void detachView();
}
