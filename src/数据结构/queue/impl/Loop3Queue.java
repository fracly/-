package 数据结构.queue.impl;

import 数据结构.queue.Queue;

/**
 * 循环队列的实现方法3
 * 继续浪费一个空间，但是减少一个变量维护的size
 */
public class Loop3Queue<E> implements Queue<E> {

    private E[] data;

    private int front, tail;

    public Loop3Queue(int capacity) {
        data = (E[])new Object[capacity + 1];
        front = 0;
        tail = 0;
    }

    public Loop3Queue() {
        this(10);
    }

    public int getCapacity() {
        return data.length - 1;
    }


    @Override
    public void enqueue(E e) {
        if((tail + 1)%data.length == front) {
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
    }

    @Override
    public E dequeue() {
        if(isEmpty()) {
            throw new IllegalArgumentException("cannot dequeue from an empty queue");
        }
        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        if(getSize() == (getCapacity() / 4) && getCapacity() != 0) {
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
        return tail < front ? tail + data.length - front : tail - front;
    }

    @Override
    public boolean isEmpty() {
        return tail == front;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[])new Object[newCapacity + 1];
        for(int i = 0; i < getSize(); i ++) {
            newData[i] = data[(i + front) % data.length];
        }
        tail = getSize();
        front = 0;
        data = newData;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Queue: size: %d, capacity: %d, front [", getSize(), getCapacity()));
        for(int i = 0; i < getSize(); i ++) {
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
