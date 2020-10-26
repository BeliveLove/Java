# MAP
## HashMAP(无序)
```   
HashMap的put操作
final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                   boolean evict) {
        HashMap.Node<K, V>[] tab;
        HashMap.Node<K, V> p;
        int n, i;
        //主干Node<K,V>[]的初始数组判定,第一次put时会进行初始化,调用resize()方法初始化数组
        if ((tab = table) == null || (n = tab.length) == 0)
            n = (tab = resize()).length;
        //将table的第i(这个i指的tab[]的第0个或者length-1个)个元素赋给p.
        if ((p = tab[i = (n - 1) & hash]) == null)
        //如果tab[i]为null,则直接追加节点
            tab[i] = newNode(hash, key, value, null);
        //如果tab[i]不为null，则进入else循环
        else {
            HashMap.Node<K, V> e;
            K k;
            //这个if判定p节点的key的hash值与传入值的key的hash值比较,hash相同则取代
            //这个p指每个链的第0个节点，每个链的第0个节点构成了一个数组,这就是HashMap.
            //可以理解为HashMap的主轴是数组，同时主轴的每个元素为链表的第0共和元素
            if (p.hash == hash &&
                    ((k = p.key) == key || (key != null && key.equals(k))))
                e = p;
            //如果p节点是个tree实例,则进行树节点的操作
            //???所以什么时候会进行树操作???目前不知道😂
            else if (p instanceof HashMap.TreeNode)
                e = ((HashMap.TreeNode<K, V>) p).putTreeVal(this, tab, hash, key, value);
            else {
            //这个else表示既不进行tree操作,也不进行替换操作
            //此处死循环用来给链表追加节点
                for (int binCount = 0; ; ++binCount) {
                    if ((e = p.next) == null) {
                        p.next = newNode(hash, key, value, null);
                        //网上说这个判定用于      当链表长度>8时，将链表转换为红黑树
                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                            treeifyBin(tab, hash);
                        break;
                    }
                    //判定链表的元素与传进来的元素key值的比较，如果相同则取代
                    if (e.hash == hash &&
                            ((k = e.key) == key || (key != null && key.equals(k))))
                        break;
                    p = e;
                }
            }
            //???这个if还是不知道干啥      网上说解决Hash冲突???
            if (e != null) { // existing mapping for key
                V oldValue = e.value;
                if (!onlyIfAbsent || oldValue == null)
                    e.value = value;
                afterNodeAccess(e);
                return oldValue;
            }
        }
        ++modCount;
        //如果HashMap的size大于threshold,则进行扩容
        if (++size > threshold)
            resize();
        afterNodeInsertion(evict);
        return null;
    }
```
```
HashMap扩容操作
    final Node<K,V>[] resize() {
        //扩容操作分为第一次以及第n次
        Node<K,V>[] oldTab = table;
        int oldCap = (oldTab == null) ? 0 : oldTab.length;
        int oldThr = threshold;
        int newCap, newThr = 0;
        if (oldCap > 0) {
            //当主轴的长度>MAXIMUM_CAPACITY时,就会把扩容因子变成Integer.MAX_VALUE
            if (oldCap >= MAXIMUM_CAPACITY) {
                threshold = Integer.MAX_VALUE;
                return oldTab;
            }
            //把存储数据量拓展2倍，扩容因子扩大2倍
            else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY &&
                     oldCap >= DEFAULT_INITIAL_CAPACITY)
                newThr = oldThr << 1; // double threshold
        }
        else if (oldThr > 0)
             //初始化
            newCap = oldThr;
        else {    
            //这是oldTab初始化进入的方法
            newCap = DEFAULT_INITIAL_CAPACITY;
            newThr = (int)(DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);
        }
        if (newThr == 0) {
            float ft = (float)newCap * loadFactor;
            newThr = (newCap < MAXIMUM_CAPACITY && ft < (float)MAXIMUM_CAPACITY ?
                      (int)ft : Integer.MAX_VALUE);
        }
        threshold = newThr;
        //新数组(容量以及扩容因子都被改变了)替换旧数组
        @SuppressWarnings({"rawtypes","unchecked"})
            Node<K,V>[] newTab = (Node<K,V>[])new Node[newCap];
        table = newTab;
        if (oldTab != null) {
            for (int j = 0; j < oldCap; ++j) {
                Node<K,V> e;
                if ((e = oldTab[j]) != null) {
                    oldTab[j] = null;
                    if (e.next == null)
                        newTab[e.hash & (newCap - 1)] = e;
                    else if (e instanceof TreeNode)
                        ((TreeNode<K,V>)e).split(this, newTab, j, oldCap);
                    else { // preserve order
                        Node<K,V> loHead = null, loTail = null;
                        Node<K,V> hiHead = null, hiTail = null;
                        Node<K,V> next;
                        do {
                            next = e.next;
                            if ((e.hash & oldCap) == 0) {
                                if (loTail == null)
                                    loHead = e;
                                else
                                    loTail.next = e;
                                loTail = e;
                            }
                            else {
                                if (hiTail == null)
                                    hiHead = e;
                                else
                                    hiTail.next = e;
                                hiTail = e;
                            }
                        } while ((e = next) != null);
                        if (loTail != null) {
                            loTail.next = null;
                            newTab[j] = loHead;
                        }
                        if (hiTail != null) {
                            hiTail.next = null;
                            newTab[j + oldCap] = hiHead;
                        }
                    }
                }
            }
        }
        return newTab;
    }
```
### LinkedHashMap(保持顺序)
## TreeMAP(排序)