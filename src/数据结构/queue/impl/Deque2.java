package 数据结构.queue.impl;

/**
 * 基于循环队列的双端队列实现
 */
public class Deque2<E> {
    private E[] data;
    private int front, tail;

    private int size; // 由于使用了size，所以不再浪费一个空间

    public Deque2(int capacity) {
        data = (E[])new Object[capacity];
        front = 0;
        tail  = 0;
        size = 0;
    }

    public Deque2() {
        this(10);
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getCapacity() {
        return data.length;
    }

    public void addLast(E e) {
        //先判断是否满了
        if(size == getCapacity()) {
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size ++;
    }

    public void addFront(E e) {
        //先判断是否满了
        if(size == getCapacity()) {
            resize(getCapacity() * 2);
        }
        front = (front - 1 < 0 ? front - 1 + data.length : front - 1) % data.length;
        data[front] = e;
        size ++;
    }

    public E removeFront() {
        if(isEmpty()) {
            throw new IllegalArgumentException("cannot remove from an empty deque");
        }
        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size --;
        if(size < getCapacity() / 4 && getCapacity() != 0) {
            resize(getCapacity() / 2);
        }
        return ret;
    }

    public E removeLast() {
        if(isEmpty()) {
            throw new IllegalArgumentException("cannot remove from an empty deque");
        }
        tail = tail - 1 < 0 ? data.length + tail - 1 : tail - 1;
        E ret = data[tail];
        data[tail] = null;
        size --;
        if(size < getCapacity() / 4 && getCapacity() != 0) {
            resize(getCapacity() / 2);
        }
        return ret;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[])new Object[newCapacity];
        for(int i = 0; i < size; i ++) {
            newData[i] = data[(front + i) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Deque2: size: %d, capacity: %d, front [", size, getCapacity()));
        for(int i = 0; i < size; i ++) {
            sb.append(data[(i + front) % data.length]);
            if(i != size - 1) {
                sb.append(", ");
            }
        }
        sb.append("] tail");
        return sb.toString();
    }
}
