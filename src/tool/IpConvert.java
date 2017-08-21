package tool;

/**
 * Created by has on 2017/6/28.
 */
public class IpConvert {
//    /**
//     * 获取客户端浏览器的ip地址
//     */
//    public static String getIpAddr(HttpServletRequest request) {
//        String ip = request.getHeader("x-forwarded-for");
//
//        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//            ip = request.getHeader("Proxy-Client-IP");
//        }
//        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//            ip = request.getHeader("WL-Proxy-Client-IP");
//        }
//        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//            ip = request.getRemoteAddr();
//        }
//        if (ip != null && ip.indexOf(":") >= 0) { // 判断是否为IPV6地址
//            ip = "127.0.0.1";
//        }
//        return ip;
//    }

    // 將IP地址转换成10进制整数
    public static Integer IpToLong(String strIp) {
        long[] ip = new long[4];
        // 先找到IP地址字符串中.的位置
        int position1 = strIp.indexOf(".");
        int position2 = strIp.indexOf(".", position1 + 1);
        int position3 = strIp.indexOf(".", position2 + 1);
        // 将每个.之间的字符串转换成整型
        ip[0] = Integer.parseInt(strIp.substring(0, position1));
        ip[1] = Integer.parseInt(strIp.substring(position1 + 1, position2));
        ip[2] = Integer.parseInt(strIp.substring(position2 + 1, position3));
        ip[3] = Integer.parseInt(strIp.substring(position3 + 1));
        return (int) ((ip[0] << 24) + (ip[1] << 16) + (ip[2] << 8) + ip[3]);
    }

    // 将十进制整数形式转换成127.0.0.1形式的ip地址
    public static String LongToIP(Integer longIp) {
        StringBuffer sb = new StringBuffer("");
        // 直接右移24位
        sb.append(String.valueOf((longIp >>> 24)));
        sb.append(".");
        // 将高8位置0，然后右移16位
        sb.append(String.valueOf((longIp & 0x00FFFFFF) >>> 16));
        sb.append(".");
        // 将高16位置0，然后右移8位
        sb.append(String.valueOf((longIp & 0x0000FFFF) >>> 8));
        sb.append(".");
        // 将高24位置0
        sb.append(String.valueOf((longIp & 0x000000FF)));
        return sb.toString();
    }

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {
//        Integer ip=IpToLong("127.0.0.1");
        Integer ip=IpToLong("49.4.169.187");
        System.out.println(ip);
        System.out.println(LongToIP(ip));
    }
}
