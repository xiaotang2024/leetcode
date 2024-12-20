package leetcode100.链表;

import java.util.Stack;

/**
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 *
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 */
public class I_两两交换链表中的节点 {
    public static void main(String[] args) {
        I_两两交换链表中的节点 code = new I_两两交换链表中的节点();

        ListNode root = ListNode.createLinkedList(new int[]{1, 2, 3, 4});
        ListNode res = code.swapPairs(root);
        ListNode.printLinkedList(res);
    }


    public ListNode swapPairs(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        stack.peek();
        ListNode dummyHead = new ListNode(0); // 哑元节点
        dummyHead.next = head;
        ListNode temp = dummyHead;
        while (temp.next != null && temp.next.next != null) {
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            temp = node1;
        }
        return dummyHead.next;
    }
}
