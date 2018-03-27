package com.example.code;

/**
 * <p>描述：双向链表的java实现
 * 链表的表头为null 没有存储数据
 * </p>
 * 作者： liujiyi<br>
 * 日期： 2018/3/27<br>
 */
public class DoubleLink<T> {
    private Node<T> mHead;
    private int count;

    public DoubleLink() {
        this.mHead = new Node<>(null, null, null);
        mHead.next = mHead.pre = mHead;
        this.count = 0;
    }

    private static class Node<T> {
        private Node pre;
        private Node next;
        private T value;

        public Node(Node pre, Node next, T value) {
            this.pre = pre;
            this.next = next;
            this.value = value;
        }
    }

    /**
     * 在指定位置之前添加数据
     *
     * @param index
     * @param value
     */
    public void add(int index, T value) {
        if (index == 0) {
            //加在头部
            Node node = mHead.next;
            Node<T> tNode = new Node<>(mHead, node, value);
            mHead.next = tNode;
            node.pre = tNode;
            if (count == 0) {
                mHead.pre = tNode;
            }
            count++;
            return;
        }
        if (index == count+1) {
            //加在尾部
            Node node = find(count-1);
            Node<T> tNode = new Node<>(node, mHead, value);
            node.next = tNode;
            mHead.pre = tNode;
            count++;
            return;
        }
        Node node = find(index);
        Node<T> tNode = new Node<>(node.pre, node, value);
        node.pre.next = tNode;
        node.pre = tNode;
        count++;
    }

    /**
     * 在指定位置查找数据
     *
     * @param index
     */
    public Node find(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException();
        }

        if (index <= count / 2) {
            //正向查找
            Node node = mHead.next;
            for (int x = 0; x < index; x++) {
                node = node.next;
            }
            return node;
        }
        //反向查找
        Node node = mHead.pre;
        for (int x = 0; x < (count - index - 1); x++) {
            node = node.pre;
        }
        return node;
    }

    /**
     * 在指定位置删除数据
     *
     * @param index
     */
    public void del(int index) {
        Node node = find(index);
        node.pre.next = node.next;
        node.next.pre = node.pre;
        count--;
    }

    /**
     * 打印链表
     */
    public void display() {
        System.out.println(" ");
        Node node = mHead.next;
        for (int x = 0; x < count; x++) {
            System.out.println(node.value);
            node = node.next;
        }
//        while (node != null) {
//            System.out.println(mHead.next.value);
//            node = node.next;
//        }
    }
}
