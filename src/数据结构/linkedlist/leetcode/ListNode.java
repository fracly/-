package 数据结构.linkedlist.leetcode;

public class ListNode {
    int val;
    ListNode next;

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(int val) {
        this(val, null);
    }

    public ListNode() {
        this(0, null);
    }

    // 构造函数，将一个数组转化为当前节点为首的额链表
    public ListNode(int[] arr) {
        if(arr == null || arr.length == 0) {
            throw new IllegalArgumentException("arr cannot be empty");
        }
        this.val = arr[0];
        ListNode cur = this;
        for(int i = 1; i < arr.length; i ++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        ListNode cur = this;
        while(cur != null) {
            stringBuilder.append(cur.val + "->");
            cur = cur.next;
        }
        stringBuilder.append("NULL");
        return stringBuilder.toString();
    }
}
