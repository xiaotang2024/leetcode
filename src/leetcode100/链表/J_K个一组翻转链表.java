package leetcode100.链表;

public class J_K个一组翻转链表 {
    public static void main(String[] args) {
        J_K个一组翻转链表 code = new J_K个一组翻转链表();
        ListNode head = ListNode.createLinkedList(new int[]{1, 2, 3, 4, 5});
        ListNode res = code.reverseKGroup(head, 2);
        ListNode.printLinkedList(res);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }
        ListNode dummy = new ListNode(0); // 哑元节点
        dummy.next = head;
        // 每一组的前缀节点
        ListNode preGroup = dummy;
        while (true){
            // 每一组的开始节点
            ListNode start = preGroup.next;
            // 获取每一组的结束节点
            ListNode end = start;
            for (int i = 0; end != null && i < k - 1; i++) {
                end = end.next;
            }
            if (end == null){
                break;
            }
            // 记录下一个开始节点
            ListNode nextStart = end.next;
            // 断开当前组和下一组的关系
            end.next = null;
            // 翻转当前组节点
            ListNode currGroup =  reverse(start);
            // 前置节点指向反转后的开始节点
            preGroup .next = currGroup;
            // 反转后的尾节点指向下一组的开始节点
            start.next = nextStart;
            // 更新下一组的前缀节点
            preGroup = start;
        }

        return dummy.next;
    }
    public ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode pre = null;
        while (curr != null){
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        return pre;
    }
}
