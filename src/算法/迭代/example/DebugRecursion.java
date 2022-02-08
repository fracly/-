package 算法.迭代.example;


public class DebugRecursion {
    public ListNode removeElements(ListNode head, int val, int depth) {
        String depthString = generateDepthString(depth);
        System.out.print(depthString);
        System.out.println("Call: remove element " + val);

        if(head == null) {
            System.out.print(depthString);
            System.out.println("Return:" + head);
            return head;
        }

        ListNode res = removeElements(head.next, val, depth + 1);
        System.out.print(depthString);
        System.out.println("After remove " + val + " :" + res);
        head.next = res;
        System.out.print(depthString);
        System.out.println("Return: " + (head.val == val ? head.next : head));
        return head.val == val ? head.next : head;
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < depth; i ++) {
            res.append("==");
        }
        return res.toString();
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);
        ListNode res = (new DebugRecursion().removeElements(head, 6, 0));
        System.out.println(res);
    }
}

class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public ListNode(int[] arr) {
        if(arr == null || arr.length == 0) {
            throw new IllegalArgumentException("无法从空数组进行初始化");
        }

        this.val = arr[0];
        ListNode cur = this;

        for(int i = 1; i < arr.length - 1; i ++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        ListNode cur = this;
        while(cur != null) {
            s.append(cur.val + "->");
            cur = cur.next;
        }
        s.append("NULL");
        return s.toString();
    }
}
