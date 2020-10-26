package map;

import java.util.HashMap;

/**
 * @author Administrator
 */
public class Map {
    public static void main(String[] args) {
        hashMap();
    }

    public static void hashMap() {
        /*HashMap的属性
         * size:表示HashMap中存放KV的数量
         * capacity:就是指HashMap中桶的数量,默认值为16.
         * loadFactor:装载因子,默认值为0.75f,实时loadFactor:size/capacity
         * threshold:capacity*loadFactor,当HashMap的size大于threshold时会执行resize操作
         * */

        /*
         * HashMap的初始化
         * 需要传入初始的HashMap大小，以及加载因子，如果没有传入，则使用默认的参数,判断传入的参数是否合法
         * public HashMap(int initialCapacity, float loadFactor)
         * //初始化扩容标准    通过initialCapacity的值进行位运算,确定扩容条件
         * this.threshold = tableSizeFor(initialCapacity);初始this.threshold=15+1=16
    }* */
        HashMap hashMap = new HashMap();
        for (int i = 0; i < 12; i++) {
            hashMap.put("a" + i, "a" + i + 1);
        }
        for (int i = 0; i < 12; i++) {
            System.out.println(hashMap.get("a" + i).hashCode());
        }
        System.out.println(hashMap.toString());
    }


}

