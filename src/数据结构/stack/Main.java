package 数据结构.stack;

import 数据结构.stack.impl.ArrayStack;
import 数据结构.stack.impl.LinkedListStack;

public class Main {
    public static void main(String[] args) {
//        LinkedListStack<Integer> arrayStack = new LinkedListStack<>();
//        for(int i =0 ; i < 5; i ++) {
//            arrayStack.push(i);
//            System.out.println(arrayStack);
//        }
//
//        arrayStack.pop();
//        System.out.println(arrayStack);

        LinkedListStack<Integer> linkedListStack = new LinkedListStack();
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        int opCount = 1000000;
        double time1 = testStack(linkedListStack, opCount) / 1000000000.0;
        System.out.println(time1);
        double time2 = testStack(arrayStack, opCount) / 1000000000.0;
        System.out.println(time2);
    }

    public static long testStack(Stack<Integer> stack, int opCount) {
        long startTime = System.nanoTime();

        for(int i = 0; i < opCount; i ++) {
            stack.push(i);
        }

        for(int i = 0; i < opCount; i ++) {
            stack.pop();
        }
        long endTime = System.nanoTime();
        return endTime - startTime;
    }
}
