package 笔试.快手.LRU算法;

import java.util.HashMap;
import java.util.Map;

/**
 * LRU(哈希表+双向链表)      也可以直接使用LinkedHashMap(面试的时候别用这个，直接调API就完了)
 * 双向链表按照被使用的顺序存储这些键值对，靠近头部的键值对是最近使用的，靠近尾部的键值对是最久未使用的
 * 哈希表即为普通的哈希映射(HashMap),通过缓存数据的键映射到其在双向链表中的位置
 * <p>
 * 这样的话，我们首先使用哈希表进行定位，找到缓存项在双向链表中的位置，然后将其移动到链表头部
 * 即可在O(1)时间内完成get和put操作
 */
public class LRUCache {
    private Map<Integer, LinkedNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private LinkedNode head, tail;   //引入两个头尾指针，方便操作

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        //双向链表初始化
        head = new LinkedNode();
        tail = new LinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        LinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        //如果key存在，先通过哈希表定位，再移到头部
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        LinkedNode node = cache.get(key);
        if (node == null) {
            //如果key不存在，创建一个新的节点
            LinkedNode newNode = new LinkedNode(key, value);
            //添加进哈希表
            cache.put(key, newNode);
            //添加至双向链表的头部
            addToHead(newNode);
            ++size;
            if (size > capacity) {
                //如果超出容量，删除双向链表的尾部节点
                LinkedNode tail = removeTail();
                //删除哈希表中对应的项
                cache.remove(tail.key);
                --size;
            }
        } else {
            //如果key存在，先通过哈希表定位，再修改value,并移到头部
            node.value = value;
            moveToHead(node);
        }
    }

    //将一个节点添加到链表头部
    public void addToHead(LinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    //删除节点
    public void removeNode(LinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    //删除最后尾部节点
    public LinkedNode removeTail() {
        LinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }

    //将链表中的节点移动到头部，先脱链再移动到头
    public void moveToHead(LinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    public void print() {
        LinkedNode cur = head;
        while (cur.next != tail) {
            cur = cur.next;
            System.out.print(cur.value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        //缓存容量为2
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        //该操作会将key=2的节点移除，因为缓存容量满了，删除最久未使用的，然后key=3的会被移到头节点
        cache.put(3, 3);//链表：[3->1]
        System.out.println(cache.get(2));//找不到，返回-1
        //该操作会将key=1的节点移除，因为缓存容量满了，删除最久未使用的，然后key=4的会被移到头节点
        cache.put(4, 4);//链表：[4->3]
        System.out.println(cache.get(1));   //找不到，返回-1
        System.out.println(cache.get(3));   //返回3,此时链表[3->4]
        System.out.println(cache.get(4));   //返回4,此时链表[4->3]
    }
}

//双向链表，节点值为键值对
class LinkedNode {
    int key;
    int value;
    LinkedNode prev;
    LinkedNode next;

    public LinkedNode() {
    }

    public LinkedNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
