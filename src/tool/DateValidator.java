package tool;

import java.text.SimpleDateFormat;

/**
 * Created by has on 2017/6/28.
 * 接收前台传来的时间代码字符串
 */
public class DateValidator {
    /*****其他代码省略**/
    public boolean isValidDate(String s){
        try {
            // 指定日期格式为四位年/两位月份/两位日期，注意yyyy-MM-dd其中MM为大写
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm");
            // 设置lenient为false. 否则SimpleDateFormat会比较宽松地验证日期，比如2004/02/29会被接受，并转换成2004/03/01
            dateFormat.setLenient(false);
            dateFormat.parse(s);
            return true;
        }catch (Exception e) {
            // 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
            return false;
        }
    }
}
