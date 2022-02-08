package 数据结构.queue.impl;

import 数据结构.queue.Queue;

public class LinkedListQueue<E> implements Queue<E> {

    private class Node {
        private E e;
        private Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    // 添加一个尾指针，方便从链表尾部添加元素，但是从尾部删除元素依旧不容易，O(n)
    private Node head, tail;
    private int size;

    public LinkedListQueue() {
        head = tail = null;
        size = 0;
    }


    @Override
    public void enqueue(E e) {
        // 从尾部添加元素
        if(tail == null) {
            tail = head = new Node(e);
        } else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size ++;
    }

    @Override
    public E dequeue() {
        if(isEmpty()) {
            throw new IllegalArgumentException("cannot dequeue from  an empty queue");
        }
        Node ret = head;
        head = head.next;
        if(head == null) {
            tail = null;
        }
        return ret.e;
    }

    @Override
    public E getFront() {
        if(isEmpty()) {
            throw new IllegalArgumentException("Get failed, empty queue");
        }
        return head.e;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Queue: front ");
        for(Node cursor = head; cursor!= null; cursor = cursor.next) {
            sb.append(cursor.e + "->");
        }
        sb.append("NULL tail");
        return sb.toString();
    }
}
