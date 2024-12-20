package leetcode100.链表;

/**
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 */
public class B_反转链表 {
    public static void main(String[] args) {
        B_反转链表 code = new B_反转链表();
        ListNode node = ListNode.createLinkedList(new int[]{1, 2, 3, 4, 5});
        ListNode root = code.reverseList(node);

        ListNode.printLinkedList(root);

    }


    public ListNode reverseList(ListNode head) {
        ListNode cur = head, pre = null;
        while(cur != null){
            ListNode tmp = cur.next; // 暂存后继节点 cur.next
            cur.next = pre;          // 修改 next 引用指向
            pre = cur;               // pre 暂存 cur
            cur = tmp;               // cur 访问下一节点
        }
        return pre;
    }
}
