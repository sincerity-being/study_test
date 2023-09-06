1.  a[i]_address = base_address + i * data_type_size
2. 数组支持随机访问，根据下标随机访问的时间复杂度为 O(1)。
3. 如果数组中的数据是有序的，我们在某个位置插入一个新的元素时，
就必须按照刚才的方法搬移 k 之后的数据。但是，如果数组中存储的数据并没有任何规律，数组只是被当作一个存储数据的集合。
在这种情况下，如果要将某个数据插入到第 k 个位置，为了避免大规模的数据搬移，
我们还有一个简单的办法就是，直接将第 k 位的数据搬移到数组元素的最后，把新的元素直接放入第 k 个位置。
4. 为了避免 d，e，f，g，h 这几个数据会被搬移三次，我们可以先记录下已经删除的数据。
每次的删除操作并不是真正地搬移数据，只是记录数据已经被删除。
当数组没有更多空间存储数据时，我们再触发执行一次真正的删除操作，这样就大大减少了删除操作导致的数据搬移。
5. 这不就是 JVM 标记清除垃圾回收算法的核心思想吗？没错，数据结构和算法的魅力就在于此，
很多时候我们并不是要去死记硬背某个数据结构或者算法，而是要学习它背后的思想和处理技巧，
这些东西才是最有价值的。如果你细心留意，不管是在软件开发还是架构设计中，总能找到某些算法和数据结构的影子。
6. 数组在高级语言中使用情况:
```text
1.Java ArrayList 无法存储基本类型，比如 int、long，需要封装为 Integer、Long 类，
而 Autoboxing、Unboxing 则有一定的性能消耗，所以如果特别关注性能，或者希望使用基本类型，就可以选用数组。
2. 如果数据大小事先已知，并且对数据的操作非常简单，用不到 ArrayList 提供的大部分方法，也可以直接使用数组。
3. 还有一个是我个人的喜好，当要表示多维数组时，用数组往往会更加直观。
比如 Object[][] array；而用容器的话则需要这样定义：ArrayList<ArrayList<object> > array。
```
7. a[k]_address = base_address + k * type_size
   a[k]_address = base_address + (k-1)*type_size