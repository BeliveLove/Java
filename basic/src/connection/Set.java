package connection;


import java.util.HashSet;


/**
 * @author Administrator
 */
public class Set {
    public static void main(String[] args) {
//        hashSet();
        int a = 4;
        int c = a >> 1;
        System.out.println(c);
    }

    public static void hashSet() {
        /*
         * 什么是Hash:可以认为是数据对于地址的映射
         * 1.HashSet底层就是HashMap实现的
         * 2.HashSet的Value实际上为HashMap的KEY，根据HashMap的KEY的唯一性，来确定HashSet值的唯一性
         * 2.1简单的来说就是HashSet的Value等于HashMap的Key
         * 3.HashMap的putVal方法，通过将Key值转化为Hash值来保证KEY的唯一性(onlyIfAbsent属性:确定是否覆盖已存在的KEY值的VALUE值)
         * 4.HashSet无序
         */
        HashSet hashSet = new HashSet();
        hashSet.add("YYB");
        hashSet.add("YYB1");
        hashSet.add("YYB2");
        hashSet.add("A");
        hashSet.add("a");
        hashSet.forEach((el) -> {
            System.out.println(el.hashCode());
        });
        //无序
//        System.out.println(hashSet.toString());
    }

    public static void treeSet() {

    }
}
