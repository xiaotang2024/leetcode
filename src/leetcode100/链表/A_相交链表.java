package leetcode100.链表;

/**
 * 《相交链表》给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null
 */
public class A_相交链表 {
    public static void main(String[] args) {
        // 创建相交链表的节点
        ListNode intersection = new ListNode(8);
        intersection.next = new ListNode(4);
        intersection.next.next = new ListNode(5);

        // 创建 listA: [4,1,8,4,5]
        ListNode listA = new ListNode(4);
        listA.next = new ListNode(1);
        listA.next.next = intersection; // 相交节点

        // 创建 listB: [5,6,1,8,4,5]
        ListNode listB = new ListNode(5);
        listB.next = new ListNode(6);
        listB.next.next = new ListNode(1);
        listB.next.next.next = intersection; // 相交节点

        // 调用方法并输出结果
        ListNode intersectionNode = getIntersectionNode(listA, listB);
        if(intersectionNode != null) {
            System.out.println("相交节点的值: " + intersectionNode.val);
        } else {
            System.out.println("两个链表没有相交节点");
        }
    }


    /**
     * 思路：创建两个指针，指针p1从链表A开始遍历，指针p2从链表B开始遍历。指针p1遍历完链表A后开始遍历链表B。指针p2遍历完链表B后开始遍历链表A。他们会在相交的节点相遇
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        ListNode p1 = headA;
        ListNode p2 = headB;
        // 如果没有相交节点，指针p1和p2也会在null值时相等，所有不会发生死循环的问题
        while (p1 != p2) {
            p1 = (p1 == null) ? headB : p1.next;
            p2 = (p2 == null) ? headA : p2.next;
        }
        return p1;
    }
}





