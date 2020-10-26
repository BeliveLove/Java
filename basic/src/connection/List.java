package connection;

import java.util.ArrayList;

/**
 * @author Administrator
 */
public class List {
    public static void main(String[] args) {
        arrayList();
    }

    private static void arrayList() {
        /*
            minCapacity:当前存入元素的上限
            1.JDK8.0版本的ArrayList的初始大小为0
            2.ArrayList的add操作
            2.1:ensureCapacityInternal(size + 1);//扩容
            2.2:elementData[size++] = e;添加元素
            3.ensureCapacityInternal(minCapacity):
            3.1:先获取默认的elementData的大小
            3.2:如果elementData跟DEFAULTCAPACITY_EMPTY_ELEMENTDATA一样,则element未进行初始化,此时进行初始化
                (把数组当前的size跟DEFAULT_CAPACITY比较，谁大听谁的，且赋值给minCapacity)
            3.3:ensureExplicitCapacity(minCapacity)//此时才是是否扩容的真正的判断条件
            3.3.1:如果此时数组的存入元素个数大于elementData的长度,则扩容,进入grow(minCapacity)方法;
            4.???怎样扩容???
            int oldCapacity = elementData.length;//获取数组的长度
            int newCapacity = oldCapacity + (oldCapacity >> 1);//扩大1.5倍
            if (newCapacity - minCapacity < 0)//如果扩大1.5倍后,还是少于当前存入元素的大小
            newCapacity = minCapacity;//则把当前容量上限改为minCapacity
            if (newCapacity - MAX_ARRAY_SIZE > 0)//如果扩大1.5倍后,大于MAX_ARRAY_SIZE(数组元素容量上限)
            newCapacity = hugeCapacity(minCapacity);//执行hugeCapacity(minCapacity)
            5.hugeCapacity(minCapacity)
            1.这个方法就是判定越界
            2.扩大后如果大于MAX_ARRAY_SIZE,则数组元素容量上限变为Integer.MAX_VALUE(Int的最大值),否则容量上限依然为MAX_ARRAY_SIZE
            6.elementData = Arrays.copyOf(elementData, newCapacity);
                            修改数组容量上限,且不改变原数组的数据
    */
        ArrayList arrayList = new ArrayList();
        arrayList.forEach((o) -> {
        });
        System.out.println(arrayList.size());
    }
}
