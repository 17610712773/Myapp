package wandroid.group4.com.myapplication.Util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DetaUtil {

    /*
    * 获取本地系统当前日期和时间
    * */
    public static String getCurrenDate(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyy年MM月dd日");
        return simpleDateFormat.format(new Date());
    }

    /*
    *把获取到的服务器时间戳转换日期格式
    * */
    public  static String getDateStringByDate(long dt){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyMMdd");
        return simpleDateFormat.format(new Date(dt));
    }
    /*
    * 获取当前年份
    * */
    public static int getCurrenYear(){
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.YEAR);
    }
}
