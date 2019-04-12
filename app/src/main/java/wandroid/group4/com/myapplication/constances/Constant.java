package wandroid.group4.com.myapplication.constances;


import java.io.File;

import wandroid.group4.com.myapplication.app.MyApp;


public class Constant {

    public static final String BASE_URL = "http://172.16.53.30:8360/api/";


    //网络缓存的地址
    public static final String PATH_DATA = MyApp.myApp.getCacheDir().getAbsolutePath() + File.separator + "data";
    public static final String PATH_CACHE = PATH_DATA + "/NetCache";




}
