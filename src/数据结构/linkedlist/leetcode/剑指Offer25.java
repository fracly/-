package 数据结构.linkedlist.leetcode;

public class 剑指Offer25 {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //思路：依次获取两个链表中的第一个，比较，小的拿出来
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;
        while(l1 != null || l2 != null) {

            if(l1 != null && l2 == null) {
                cur.next = new ListNode(l1.val);
                l1 = l1.next;
            } else if(l2 != null && l1 == null) {
                cur.next = new ListNode(l2.val);
                l2 = l2.next;
            } else {
                if(l1.val <= l2.val) {
                    cur.next = new ListNode(l1.val);
                    l1 = l1.next;
                } else {
                    cur.next = new ListNode(l2.val);
                    l2 = l2.next;
                }
            }
            cur = cur.next;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {1, 3, 4};
        ListNode l1 = new ListNode(nums1);
        ListNode l2 = new ListNode(nums2);

        System.out.println(mergeTwoLists(l1, l2));
    }
}
