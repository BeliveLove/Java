import netscape.security.UserTarget;

/**
 * @author Administrator
 */
public class Basic {
    public static void main(String[] args) {
       intDemo();
//        stringDemo();
    }

    public static void intDemo() {
        int a = 127;
        //byte: -128~127
        /*
        *a=126  b=127
        * 下面的越界，当a=127时，b=-128，越界，取余为1，所以为循环体的第一个-128  128%127==1
        *a=127  b=-128
        *a=128  b=-127
        * */
        //越界转为负数
        byte b = (byte) a;
        //此时C为129，但是a已经变成130
        int c = a++;
        //此时d为131
        int d = ++a;
        //
        int e = ++b;
        System.out.println("a:" + a);
        System.out.println("b:" + b);
        System.out.println("c:" + c);
        System.out.println("d:" + d);
        System.out.println("e:" + e);
    }

    public static void stringDemo() {
        String s0 = "hello";
        String s1 = "hello";
        String s2 = "he" + "llo";
        System.out.println(s0 == s1);
        System.out.println(s0 == s2);
        String s3 = new String("hello");
        System.out.println(s0 == s3);

    }
}
