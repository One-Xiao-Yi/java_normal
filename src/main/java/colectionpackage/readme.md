#集合：  
## 常见的集合分为List、Map、Set、Queue、Stack
##List是存储可重复元素的列表。分为：ArrayList、LinkedList
####ArrayList是连续存储的列表，通过索引，可以快速定位元素，但对于增加和删除元素，则需将插入索引之后的元素移动。
####LinkedList是非连续存储的列表，通过指针将元素连接。定位元素时，需从头部开始遍历，但插入删除元素时，只需将前一个元素的指针指向插入的元素(插入)或下一个元素(删除)，效率更高。  
##Map是以key-value形式存储数据的集合。分为HashMap、TreeMap、EnumMap
####HashMap是最基础的map，通过Key-Value的形式存储数据，通过计算key的hashCode，与内存中存储的value形成映射。
####TreeMap是key有序的map，通过Key-Value的形式存储数据，并可根据自定义的排序规则进行排序。
####EnumMap是以枚举类型为key的map，通过Key-Value的形式存储数据，value存储非常紧凑，可通过key直接定位value，效率更高，没有额外的空间消耗。
##Set是存储不重复元素的列表，Set底层由Map实现，可以视为只有key的Map。分为HashSet、TreeSet
####HashSet由HashMap实现，是无序的、元素不可重复的列表。
####TreeSet由TreeMap实现，是有序的、元素不可重复的列表。排序规则与TreeMap相同，需指定排序规则。
##Queue是一种实现先进先出的队列。常见的有LinkedList、PriorityQueue、Deque，LinkedList既Queue的基本实现。
####PriorityQueue 是一种可以排序的队列（设定优先级），与TreeSet类似，需指定排序规则。
####Deque 是一种可以两端添加、两端获取、两端出队的队列。
##Stack 是一种后进先出的队列，由Deque模拟实现。