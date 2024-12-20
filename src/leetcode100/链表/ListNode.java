package leetcode100.链表;

/**
 * 链表节点
 */
public class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
        next = null;
     }

    ListNode() {
    }


    // 创建链表的方法
    public static ListNode createLinkedList(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;  // 如果数组为空，返回 null
        }

        ListNode head = new ListNode(arr[0]);  // 创建头节点
        ListNode current = head;  // 用于遍历链表

        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);  // 创建下一个节点
            current = current.next;  // 移动到下一个节点
        }

        return head;  // 返回链表的头节点
    }

    // 打印链表的方法
    public static void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

}