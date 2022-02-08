package 数据结构.linkedlist;

public class Main {
    public static void main(String[] args) {
        LinkedListR<Integer> linkedList = new LinkedListR<>();
        for(int i = 0; i < 5; i ++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }

        linkedList.add(0, 1);
        linkedList.add(0, 1);
        System.out.println(linkedList);
        linkedList.removeElements(1);
        System.out.println(linkedList);
//        linkedList.add(2, 666);
//        System.out.println(linkedList);
//
//        linkedList.remove(2);
//        System.out.println(linkedList);
//
//        linkedList.removeFirst();
//        System.out.println(linkedList);
//
//        linkedList.removeLast();
//        System.out.println(linkedList);
//
//        linkedList.set(2, 777);
//        System.out.println(linkedList);
//
//        System.out.println(linkedList.get(2));
//        System.out.println(linkedList.get(0));
    }
}
