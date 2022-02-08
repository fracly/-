package 数据结构.stack.impl;

import 数据结构.array.Array;
import 数据结构.stack.Stack;

public class ArrayStack<E> implements Stack<E> {

    Array<E> array;

    public ArrayStack(int capacity) {
        array = new Array<>(capacity);
    }

    public ArrayStack() {
        array = new Array<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Stack: [");
        for(int i = 0; i < array.getSize(); i ++) {
            sb.append(array.get(i));
            if(i != array.getSize() - 1) {
                sb.append(", ");
            }
        }
        sb.append("] top");
        return sb.toString();
    }

}
