package security;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * http://blog.csdn.net/u012012240/article/details/50609278
 * Created by has on 2017/6/28.
 * JAVA中AES加密和解密
 */
public class AesUtil {
    // 加密用的Key
    public static final String localkey="q1w2e3r4t5y6u7i8";
    // 加密
    public static String Encrypt(String content, String key) {
        try {
            if (key == null) {
                System.out.print("Key为空null");
                return null;
            }
            // 判断Key是否为16位
            if (key.length() != 16) {
                System.out.print("Key长度不是16位");
                return null;
            }
            if(key==localkey){
                byte[] raw = key.getBytes();
                SecretKeySpec keySpec = new SecretKeySpec(raw, "AES");
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                IvParameterSpec iv = new IvParameterSpec("0000000000123456".getBytes());
                cipher.init(Cipher.ENCRYPT_MODE, keySpec, iv);
                byte[] encrypted = cipher.doFinal(content.getBytes());
                String hexStr =byte2hex(encrypted);
                return hexStr;
            }
            else{
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    // 解密
    public static String Decrypt(String content, String key) {
        try {
            // 判断Key是否正确
            if (key == null) {
                System.out.print("Key为空null");
                return null;
            }
            // 判断Key是否为16位
            if (key.length() != 16) {
                System.out.print("Key长度不是16位");
                return null;
            }
            if(key==localkey){
                byte[] raw = key.getBytes("ASCII");
                SecretKeySpec keySpec = new SecretKeySpec(raw, "AES");
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                IvParameterSpec iv = new IvParameterSpec("0000000000123456".getBytes());
                cipher.init(Cipher.DECRYPT_MODE, keySpec, iv);
                byte[] encrypted1 = hex2byte(content);
                byte[] original = cipher.doFinal(encrypted1);
                String originalString = new String(original);
                return originalString;
            }else{
                return null;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
    //解密调用
    public static byte[] hex2byte(String strhex) {
        if (strhex == null) {
            return null;
        }
        int l = strhex.length();
        if (l % 2 == 1) {
            return null;
        }
        byte[] b = new byte[l / 2];
        for (int i = 0; i != l / 2; i++) {
            b[i] = (byte) Integer.parseInt(strhex.substring(i * 2, i * 2 + 2),
                    16);
        }
        return b;
    }
    //加密调用
    public static String byte2hex(byte[] b) {
        String hs = "";
        String stmp = "";
        for (int n = 0; n < b.length; n++) {
            stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
            if (stmp.length() == 1) {
                hs = hs + "0" + stmp;
            } else {
                hs = hs + stmp;
            }
        }
        return hs.toUpperCase();
    }
    //调用测试
    public static void main(String[] args) throws Exception {
        String cSrc = "[{'taskUrl':'http://192.168.1.178:8080/wanxue/switch/list'}]";
        System.out.println("原字符串:"+cSrc);
        //加密
        String enString = AesUtil.Encrypt(cSrc, localkey);
        System.out.println("加密后的字串是：" + enString);
        // 解密
        String DeString = AesUtil.Decrypt(enString, localkey);
        System.out.println("解密后的字串是：" + DeString);
    }
}
