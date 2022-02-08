package 数据结构.queue.impl;

import 数据结构.array.Array;
import 数据结构.queue.Queue;

public class ArrayQueue<E> implements Queue<E> {
    Array<E> array;

    public ArrayQueue(int capacity) {
        array = new Array(capacity);
    }

    public ArrayQueue() {
        array = new Array();
    }
    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Queue: front [");
        for(int i = 0; i < array.getSize(); i ++) {
            sb.append(array.get(i));
            if(i != array.getSize() - 1) {
                sb.append(", ");
            }
        }
        sb.append("] tail");
        return sb.toString();
    }
}
