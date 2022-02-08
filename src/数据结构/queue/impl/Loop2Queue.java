package 数据结构.queue.impl;

import 数据结构.queue.Queue;

/**
 * 循环队列的第二种实现方式， 不浪费那一个空间，为了区别为空和满了的时候都符合 tail == front的情况
 * 所以用size来判断为空
 * @param <E>
 */
public class Loop2Queue<E> implements Queue<E> {

    private E[] data;
    private int size;

    private int front, tail;

    public Loop2Queue(int capacity) {
        data = (E[])new Object[capacity];
        front = 0;
        tail = 0;
        size = 0;
    }

    public Loop2Queue() {
        this(10);
    }

    public int getCapacity() {
        return data.length;
    }


    @Override
    public void enqueue(E e) {
        if(size == getCapacity()) {
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size ++;
    }

    @Override
    public E dequeue() {
        if(isEmpty()) {
            throw new IllegalArgumentException("cannot dequeue from an empty queue");
        }
        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size --;
        if(size == getCapacity() / 4 && getCapacity() != 0) {
            resize(getCapacity() / 2);
        }
        return ret;
    }

    @Override
    public E getFront() {
        if(isEmpty()) {
            throw new IllegalArgumentException("cannot dequeue from an empty queue");
        }
        return data[front];
    }

    @Override
    public int getSize() {
        return size;
    }

    // 这里用size来判断是否为空
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[])new Object[newCapacity];
        for(int i = 0; i < size; i ++) {
            newData[i] = data[(i + front) % data.length];
        }
        tail = size;
        front = 0;
        data = newData;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Queue: size: %d, capacity: %d, front [", size, getCapacity()));
        for(int i = 0; i < size; i ++) {
            sb.append(data[(i + front) % data.length]);
            if((i + front + 1) % data.length != tail) {
                sb.append(", ");
            }
        }

//        for(int i = front; i != tail; i = (i + 1) % data.length) {
//            sb.append(data[i]);
//            if((i + 1) % data.length != tail) {
//                sb.append(", ");
//            }
//        }
        sb.append("] tail");
        return sb.toString();
    }

}
