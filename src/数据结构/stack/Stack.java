package 数据结构.stack;

public interface Stack<E> {

    // 往栈中添加元素
    void push(E e);

    // 从栈顶获取元素
    E pop();

    // 看一下栈顶元素是什么
    E peek();

    // 看一下栈目前的大小
    int getSize();

    // 看一下栈是否为空
    boolean isEmpty();
}
