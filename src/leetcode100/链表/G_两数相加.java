package leetcode100.链表;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 *输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 */
public class G_两数相加 {
    public static void main(String[] args) {
        G_两数相加 code = new G_两数相加();
        ListNode l1 = ListNode.createLinkedList(new int[]{2,4,9});
        ListNode l2 = ListNode.createLinkedList(new int[]{5,6,4,9});
        ListNode res = code.addTwoNumbers(l1, l2); // 10417
        ListNode.printLinkedList(res);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        ListNode temp = res;
        int m = 0; // 进位
        while (l1 != null || l2 != null) {
            int val = 0;
            if(l1 != null && l2 != null){
                val = (l1.val + l2.val + m) % 10;
                m = (l1.val + l2.val + m) / 10;
                l1 = l1.next;
                l2 = l2.next;
            }else if(l1 != null){
                val = (l1.val + m) % 10;
                m = (l1.val + m) / 10;
                l1 = l1.next;
            }else {
                val = (l2.val + m) % 10;
                m = (l2.val + m) / 10;
                l2 = l2.next;
            }
            temp.next = new ListNode(val);
            temp = temp.next;
        }
        // 处理最后一位进位
        if (m != 0){
            temp.next =  new ListNode(m);
        }
        return res.next;
    }
}
