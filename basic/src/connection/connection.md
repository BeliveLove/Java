# Connection
## Set  (无序不重复)
### HashSet (无序)
#####  
   * 什么是Hash:可以认为是数据对于地址的映射
   * 1.HashSet底层就是HashMap实现的
   * 2.HashSet默认使用HashMap的初始大小以及加载因子
   * 3.HashSet的Value实际上为HashMap的KEY，根据HashMap的KEY的唯一性，来确定HashSet值的唯一性 
   * 3.1简单的来说就是HashSet的Value等于HashMap的Key
   * 4.HashMap的putVal方法，通过将Key值转化为Hash值来保证KEY的唯一性(onlyIfAbsent属性:确定是否覆盖已存在的KEY值的VALUE值)
   * 5. 
       ##### 1.HashSet方法通过add()方法添加元素
       ##### 2.调用对象的hashCode()来获得hash值
       ##### 3.通过hash值来确定存储位置
       ##### 4.该位置是否存在对象，如果存在，通过equal()判断对象是否相等，如果相等，则舍弃该对象。如果不相等，则存入集合。如果不存在，则将对象存入集合。
                            
#### LinkedHashSet  (保持顺序)
### TreeSet (需要排序)
## List (有序可重复)
### ArrayList   (方便查改)

#### minCapacity:当前存入元素的上限
#### 1.JDK8.0版本的ArrayList的初始大小为0
#### 2.ArrayList的add操作
    2.1:ensureCapacityInternal(size + 1);//扩容
    2.2:elementData[size++] = e;添加元素
#### 3.ensureCapacityInternal(minCapacity)
    3.1:先获取默认的elementData的大小
    3.2:如果elementData跟DEFAULTCAPACITY_EMPTY_ELEMENTDATA一样,则element未进行初始化,此时进行初始化
        (把数组当前的size跟DEFAULT_CAPACITY比较，谁大听谁的，且赋值给minCapacity)
    3.3:ensureExplicitCapacity(minCapacity)//此时才是是否扩容的真正的判断条件
    3.3.1:如果此时数组的存入元素数量大于elementData的长度,则扩容,进入grow(minCapacity)方法;
    
#### 4.???怎样扩容???
    int oldCapacity = elementData.length;//获取数组的长度
    int newCapacity = oldCapacity + (oldCapacity >> 1);//扩大1.5倍
    if (newCapacity - minCapacity < 0)//如果扩大1.5倍后,还是少于当前存入元素的数量
    newCapacity = minCapacity;//则把当前容量上限改为minCapacity
    if (newCapacity - MAX_ARRAY_SIZE > 0)//如果扩大1.5倍后,大于MAX_ARRAY_SIZE(数组元素容量上限)
    newCapacity = hugeCapacity(minCapacity);//执行hugeCapacity(minCapacity)
#### 5.hugeCapacity(minCapacity)
    1.这个方法就是判定越界
    2.扩大后如果大于MAX_ARRAY_SIZE,则数组元素容量上限变为Integer.MAX_VALUE(Int的最大值),否则容量上限依然为MAX_ARRAY_SIZE
#### 6.elementData = Arrays.copyOf(elementData, newCapacity);
    修改数组容量上限,且不改变原数组的数据

### LinkedList  (方便增删)
