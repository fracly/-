package 数据结构.linkedlist;

import javafx.util.Pair;

public class LinkedListR<E> {
    private class Node {
        public E e;
        public Node next;

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

    private Node head;
    private int size;

    public LinkedListR() {
        head = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }



    public void add(int index, E e) {
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed, Illegal index");
        }
        head = add(head, index, e);
        size ++;
    }

    private Node add(Node node, int index, E e) {
        // 如果index等于0，表示直接在队首添加一个元素，非常简单
        if(index == 0) {
            // 生成一个新的节点，节点指向以node为首的链表
            Node ret = new Node(e, node);
            return ret;
        }
        node.next = add(node.next, index - 1, e);
        return node;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }

    public E get(int index) {
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed, Illegal index");
        }
        return get(head, index);
    }

    private E get(Node node, int index) {
        if(index == 0) {
            return node.e;
        }
        return get(node.next, index - 1);
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    public void set(int index, E e) {
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed, Illegal index");
        }
        set(head, index, e);
    }

    private void set(Node node, int index, E e) {
        if(index == 0) {
            node.e = e;
            return;
        }
        set(node.next,index - 1, e);
    }

    public boolean contains(E e) {
        return contains(head, e);
    }

    private boolean contains(Node node, E e) {
        if(node != null && node.e.equals(e)) {
            return true;
        }
        return contains(node.next, e);
    }

    public E remove(int index) {
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed, Illegal index");
        }
        Pair<Node, E> pair = remove(head, index);
        head = pair.getKey();
        size --;
        return pair.getValue();
    }

    public void removeElements(E e) {
        head = removeElements(head, e);
    }

    private Node removeElements(Node node, E e) {
        if(node == null) {
            return null;
        }
        node.next = removeElements(node.next, e);
        if(node.e.equals(e)) {
            size --;
            return node.next;
        }
        return node;
    }

    //在递归循环里面，我们既需要记录head节点，也需要记录被删除的元素，所以选择工具类Pair来装一下
    private Pair<Node, E> remove(Node node, int index) {
        if(index == 0) {
            return new Pair<>(node.next, node.e);
        }
        Pair<Node, E> res = remove(node.next, index - 1);
        node.next = res.getKey();
        return new Pair<>(node, res.getValue());
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node cur = head;
        while(cur != null) {
            sb.append(cur + "->");
            cur = cur.next;
        }
        sb.append("NULL");
        return sb.toString();
    }
}
