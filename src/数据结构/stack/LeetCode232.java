package 数据结构.stack;

import java.util.Stack;
public class LeetCode232 {

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.pop();
        myQueue.isEmpty();

    }
}
class MyQueue{
    private Stack<Integer> inStack;
    private Stack<Integer> outStack;

    private int inSize;
    private int outSize;

    public MyQueue() {
        inStack = new Stack<Integer>();
        outStack = new Stack<Integer>();
        inSize = 0;
        outSize = 0;
    }

    public void push(int x) {
        int count = outSize;
        for(int i = 0; i < count; i ++) {
            inStack.push(outStack.pop());
            inSize ++;
            outSize --;
        }
        inStack.push(x);
        inSize ++;
    }

    public int pop() {
        int count = inSize;
        for(int i = 0; i < count; i ++) {
            outStack.push(inStack.pop());
            inSize --;
            outSize ++;
        }
        outSize --;
        return outStack.pop();
    }

    public int peek() {
        int count = inSize;
        for(int i = 0; i < count; i ++) {
            outStack.push(inStack.pop());
            inSize --;
            outSize ++;
        }
        return outStack.peek();
    }

    public boolean isEmpty() {
        return inSize == 0 && outSize == 0;
    }
}

