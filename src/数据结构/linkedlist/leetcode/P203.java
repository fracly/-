package 数据结构.linkedlist.leetcode;

public class P203 {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 6, 4, 6};
        ListNode head = new ListNode(arr);
        System.out.println(head);
        (new P203()).removeElements3(head, 6);
        System.out.println(head);
    }

    public ListNode removeElements(ListNode head, int val) {
        while(head!= null && head.val == val) {
            head = head.next;
        }

        if(head == null)
            return null;

        ListNode prev = head;
        while(prev.next != null) {
            if(prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return head;
    }

    public ListNode removeElements2(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode prev = dummyHead;
        while(prev.next != null) {
            if(prev.next.val == val) {
                prev.next =prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return dummyHead.next;
    }

    public ListNode removeElements3(ListNode head, int val) {
        if(head == null)
            return null;

        ListNode res = removeElements3(head.next, val);

        if(head.val == val) {
            return res;
        } else {
            head.next = res;
            return head;
        }
    }
}
