package 数据结构.array;

public class Array<E> {
    private E[] data;
    private int size;

    public Array(int capacity) {
        data = (E[])new Object[capacity];
        size = 0;
    }

    public Array(){
        this(10);
    }

    public int getCapacity() {
        return data.length;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // 在指定的索引位置，添加元素到数组
    public void add(int index, E e) {

        // if(index < 0 || index >= data.length)  错误，不能不按照顺序插入，也就是数组元素之间不要空着
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("参数不合法！");
        }

        if(size == data.length) {
            //数组满了，需要扩容
            resize(data.length * 2);
        }

        for(int i = size; i > index; i --) {
            data[i] = data[i - 1];
        }
        data[index] = e;
        size ++;
    }

    // 其他工具方法, 最终是调用add
    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }

    // 删除索引为index的元素
    public E remove(int index) {
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("数组索引越界！");
        }
        E res = data[index];
        for(int i = index; i < size - 1; i ++) {
            data[i] = data[i + 1];
        }
        size --;
        if(size < (data.length / 4)) {
            resize(data.length / 2);
        }
        return res;
    }

    // 删除的工具方法，实际是调用delete（index）方法
    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public void removeElement(E e) {
        int index = find(e);
        if(index != -1) {
            remove(index);
        }

    }

    // 获取某个索引位置的元素
    public E get(int index) {
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("数组越界");
        }
        return data[index];
    }

    // 获取最后一个元素
    public E getLast() {
        return get(size - 1);
    }

    // 获取第一个元素
    public E getFirst() {
        return get(0);
    }

    // 修改某个位置的元素
    public void set(int index, E e) {
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("数组越界");
        }
        data[index] = e;
    }

    // 查找是否存在某元素
    public boolean contains(E e) {
        for(int i = 0; i < size; i ++) {
            if(data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    // 查找元素所在的索引位置
    public int find(E e) {
        for(int i = 0; i < size; i ++) {
            if(data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[])new Object[newCapacity];
        for(int i = 0; i < size; i ++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Array: size = %d, capacity = %d", size, data.length));
        sb.append(" [");
        for(int i = 0; i < size; i ++) {
            sb.append(data[i]);
            if(i != size - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
