package wandroid.group4.com.myapplication.modlue.api;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import wandroid.group4.com.myapplication.modlue.bean.Index;

/**
 * @author T-sy
 * @description:
 * @date :2019/4/12 16:10
 */
public interface Shouyeapi {

    @GET("index/index")
    Flowable<Index> getindex();
}
