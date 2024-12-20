package leetcode100.链表;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 */
public class H_删除链表的倒数第N个结点 {

    public static void main(String[] args) {
        H_删除链表的倒数第N个结点 code = new H_删除链表的倒数第N个结点();
        ListNode root = ListNode.createLinkedList(new int[]{1});
        ListNode res = code.removeNthFromEnd(root, 1);
        ListNode.printLinkedList(res);
    }

    /**
     * 思路：双指针。先让右指针走n步，再左指针。到终点时，左指针所在节点就是要删除的节点
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        ListNode left = head; // 左指针 也是要删除元素所在节点
        ListNode right = head; // 右指针
        ListNode pre = null; // 删除元素的前置节点
        ListNode last = left.next; // 删除元素的后置节点
        int k = 0;
        while(right != null){
            right = right.next;
            if(k >= n){
                pre = left;
                left = left.next;
                last = left.next;
            }
            k++;
        }
        if (pre == null){
            return last;
        }
        pre.next = last;
        return head;
    }
}
