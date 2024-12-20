package leetcode100.链表;

/**
 *给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 *
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 */
public class L_排序链表 {
    public static void main(String[] args) {
        L_排序链表 code = new L_排序链表();
        ListNode head = ListNode.createLinkedList(new int[]{4, 2, 1, 3});
        ListNode res = code.sortList2(head);
        ListNode.printLinkedList(res);
    }


    /**
     * 暴力排序，直接超时
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        ListNode dummy = new ListNode(0); // 哑元节点
        dummy.next = head;
        ListNode pre = dummy;
        ListNode curr = dummy.next;
        int n = 0;
        while (curr.next != null) {
            ListNode next = curr.next;
            if (curr.val > next.val) {
                // 交换节点
                curr.next = next.next;
                next.next = curr;
                pre.next = next;
                pre = next;
            }else{
                pre = curr;
                curr = next;
            }
            ++n;
        }
        while (n > 0) {
            pre = dummy;
            curr = dummy.next;
            int m = n - 1;
            while (m > 0 && curr.next != null) {
                ListNode next = curr.next;
                if (curr.val > next.val) {
                    // 交换节点
                    curr.next = next.next;
                    next.next = curr;
                    pre.next = next;
                    pre = next;
                }else{
                    pre = curr;
                    curr = next;
                }
            }
            n--;
        }
        return dummy.next;
    }

    /**
     * 归并排序，有空了解一下
     * @param head
     * @return
     */
    public ListNode sortList2(ListNode head) {
        if (head == null || head.next == null) {
            return head; // 基本情况：空链表或仅有一个节点
        }

        // 找到链表的中间节点
        ListNode mid = getMid(head);
        ListNode left = sortList2(head); // 递归排序左半部分
        ListNode right = sortList2(mid); // 递归排序右半部分

        return merge(left, right); // 合并已排序的两部分
    }

    private ListNode getMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next; // 快指针走两步，慢指针走一步
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next; // 中间节点
        slow.next = null; // 切断链表
        return mid;
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next; // 移动当前指针
        }
        // 连接剩余部分
        if (l1 != null) {
            current.next = l1;
        } else {
            current.next = l2;
        }
        return dummy.next; // 返回合并后的链表
    }
}
