package hash;

/**
 * 一致性hash算法
 * Created by has on 2017/6/22.
 * String的hashCode()方法运算结果查看
 * http://www.cnblogs.com/xrq730/p/5186728.html
 */
public class StringHashCodeTest {
    public static void main(String[] args)
    {
        System.out.println("192.168.0.0:111的哈希值：" + "192.168.0.0:1111".hashCode());
        System.out.println("192.168.0.1:111的哈希值：" + "192.168.0.1:1111".hashCode());
        System.out.println("192.168.0.2:111的哈希值：" + "192.168.0.2:1111".hashCode());
        System.out.println("192.168.0.3:111的哈希值：" + "192.168.0.3:1111".hashCode());
        System.out.println("192.168.0.4:111的哈希值：" + "192.168.0.4:1111".hashCode());
    }
}
