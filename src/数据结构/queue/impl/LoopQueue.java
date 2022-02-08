package 数据结构.queue.impl;

import 数据结构.queue.Queue;

/**
 * 循环队列的实现方式1
 * 相较于数组队列，在出队的时候，时间复杂度是O(n),循环队列的事件复杂为O(1)
 */
public class LoopQueue<E> implements Queue<E> {
    // 实际存储依旧用数组
    private E[] data;
    // 用一个变量来维护队列大小，更加方便
    private int size;

    //队列中，front 指向队首元素， tail指向队尾元素后一位所在的元素下标，也就是下一个加入元素的位置
    private int front, tail;

    // 利用浪费一个空间，来避免在队列为0或者满了的情况下 tail == front时无法区分的问题，
    // 在这个实现中，我们规定tail == front 只会在数组为空时成立
    public LoopQueue(int capacity) {
        data = (E[])new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    public int getCapacity() {
        return data.length - 1;
    }


    @Override
    public void enqueue(E e) {
        if((tail + 1) % data.length == front) {
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

    @Override
    public boolean isEmpty() {
        return tail == front;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[])new Object[newCapacity + 1];
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
