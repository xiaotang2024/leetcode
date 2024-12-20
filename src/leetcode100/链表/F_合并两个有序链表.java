package leetcode100.链表;

public class F_合并两个有序链表 {
    public static void main(String[] args) {
        F_合并两个有序链表 code = new F_合并两个有序链表();
        ListNode node1 = ListNode.createLinkedList(new int[]{2});
        ListNode node2 = ListNode.createLinkedList(new int[]{1});
        ListNode root = code.mergeTwoLists(node1, node2);

        ListNode.printLinkedList(root);
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 创建一个虚拟头节点，以简化链表的处理
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                p.next = list1;
                list1 = list1.next;
            } else {
                p.next = list2;
                list2 = list2.next;
            }
            p = p.next;  // 移动指针 p
        }

        // 处理剩下的节点（某一个链表可能还有元素未合并）
        p.next = list1 == null ? list2 :list1;
        // 返回合并后的链表，去掉虚拟头节点
        return dummy.next;
    }

}
