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
   * 5.HashSet默认的PRESENT对象目前还不了解
   * 6.Hash冲突:多个对象只要它们的值一样，它们的Hash值就一样。因此不同对象的值一样，它们的Hash值也一样，这就是Hash冲突
#### LinkedHashSet  (保持顺序)
### TreeSet (需要排序)
## List (有序可重复)
### ArrayList   (方便查改)
### LinkedList  (方便增删)