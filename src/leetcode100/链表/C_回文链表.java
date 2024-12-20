package leetcode100.链表;


import java.util.Stack;

/**
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 */
public class C_回文链表 {

    public static void main(String[] args) {

        C_回文链表 code = new C_回文链表();

        ListNode node = ListNode.createLinkedList(new int[]{1, 2});
        boolean res = code.isPalindrome(node);

        System.out.println(res);
    }


    public boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode p = head;
        while (p != null){
            stack.push(p.val);
            p = p.next;
        }
        while (head != null){
            if (stack.pop() != head.val){
                return false;
            }
            head = head.next;
        }
        return true;
    }
}
