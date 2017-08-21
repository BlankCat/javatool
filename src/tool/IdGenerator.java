package tool;
import java.util.Random;

/**
 * http://blog.csdn.net/u012012240/article/details/51249992
 * Created by has on 2017/6/28.
 * 采用的时间戳和随机数方法,在执行效率都比较快的。
     时间戳精确到毫秒+三位随机数,你觉得可能重复吗?
 */
public class IdGenerator {
    /**
     * 生成主键(16位数字)
     * 主键生成方式,年月日时分秒毫秒的时间戳+四位随机数保证不重复
     */
    public static  String getId() {
        //当前系统时间戳精确到毫秒
        Long simple=System.currentTimeMillis();
        //三位随机数
        int random=new Random().nextInt(900)+100;//为变量赋随机值100-999;
        return simple.toString()+random;
    }
}
