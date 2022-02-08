package 数据结构.queue;

import 数据结构.queue.impl.*;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
//        Deque2 deque = new Deque2();
//        testDequeue(deque);
//        ArrayQueue<Integer> queue = new ArrayQueue<>();
        LinkedListQueue queue = new LinkedListQueue();
        for(int i = 0; i < 10; i ++) {
            queue.enqueue(i);
            System.out.println(queue);

            if(i %3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }

//        int opCount = 100000;
//        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
//        double time1 = testQueue(arrayQueue, opCount);
//        System.out.println("ArrayQueue, time:" + time1);
//
//        LoopQueue<Integer> loopQueue = new LoopQueue<>();
//        double time2 = testQueue(loopQueue, opCount);
//        System.out.println("LoopQueue, time:" + time2);
//
//        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
//        double time3 = testQueue(linkedListQueue, opCount);
//        System.out.println("LinkedListQueue, time:" + time3);
    }

    // 测试使用queue运行opCount个enqueue 和 dequeue 操作所需要的时间，单位：秒s
    private static double testQueue(Queue<Integer> q, int opCount) {
        long startTime = System.nanoTime();

        Random random = new Random();
        for(int i = 0; i < opCount; i ++) {
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i =0; i < opCount; i ++) {
            q.dequeue();
        }
        long endTIme = System.nanoTime();
        return (endTIme - startTime) / 1000000000.0;
    }

    private static void testDequeue(Deque2 deque) {
        for(int i = 0; i < 10; i ++) {
            if(i % 2 == 0) {
                deque.addFront(i);
            } else {
                deque.addLast(i);
            }
            System.out.println(deque);
        }

        for(int i = 0; i < 10; i ++) {
            if(i % 2 == 0) {
                deque.removeLast();
            } else {
                deque.removeFront();
            }
            System.out.println(deque);
        }
    }
}
