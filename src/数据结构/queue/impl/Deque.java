package 数据结构.queue.impl;

import 数据结构.array.Array;

/**
 * 双端队列的实现
 * 基于Array数组，有一些操作会导致O(n)的时间复杂度
 * @param <E>
 */
public class Deque<E> {
    Array<E> array;

    public Deque(int capacity) {
        array = new Array<>(capacity);
    }

    public Deque() {
        array = new Array<>();
    }

    public void addFront(E e) {
        array.addFirst(e);
    }

    public void addLast(E e) {
        array.addLast(e);
    }

    public E removeFront() {
        return array.removeFirst();
    }

    public E removeLast() {
        return array.removeLast();
    }

    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int getSize() {
        return array.getSize();
    }

    public E getFront() {
        return array.get(0);
    }

    public E getLast() {
        return array.get(array.getSize() - 1);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Deque: size: %d, capacity: %d, front [", array.getSize(), array.getCapacity()));
        for(int i = 0; i < array.getSize(); i ++) {
            sb.append(array.get(i));
            if(i != getSize() - 1) {
                sb.append(", ");
            }
        }
        sb.append("] tail");
        return sb.toString();
    }
}
