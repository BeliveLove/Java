package connection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.function.Consumer;

/**
 * @author Administrator
 */
public class Set {
    public static void main(String[] args) {
        hashSet();
    }

    public static void hashSet() {
        /* 1.HashSet底层就是HashMap实现的
         * 2.HashSet默认使用HashMap的初始大小以及加载因子
         * 3.HashSet的Value实际上为HashMap的KEY，根据HashMap的KEY的唯一性，来确定HashSet值的唯一性
         * (简单的来说就是HashSet的Value等于HashMap的Key)
         * 4.HashMap的putVal方法，通过将Key值转化为Hash值来保证KEY的唯一性(onlyIfAbsent属性:确定是否覆盖已存在的KEY值的VALUE值)
         * 5.HashSet默认的PRESENT对象目前还不了解
         * */
        HashSet hashSet = new HashSet();
        hashSet.add("YYB");
        hashSet.add("YYB");
        hashSet.add("YYB");
        hashSet.add("YYB1");

        hashSet.forEach((el) -> {
            System.out.println(el);
        });
    }
}
