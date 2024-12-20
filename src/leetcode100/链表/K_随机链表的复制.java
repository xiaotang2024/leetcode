package leetcode100.链表;

public class K_随机链表的复制 {
    public static void main(String[] args) {

    }

    /**
     * 思路：先创建好节点，再处理随机指针
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null; // 如果原链表为空，直接返回 null
        }

        // 第一步：复制每个节点并插入到原节点后面
        Node current = head;
        while (current != null) {
            Node newNode = new Node(current.val);
            newNode.next = current.next;
            current.next = newNode;
            current = newNode.next; // 移动到原链表的下一个节点
        }

        // 第二步：设置随机指针
        current = head;
        while (current != null) {
            Node newNode = current.next;
            newNode.random = (current.random != null) ? current.random.next : null;
            current = newNode.next; // 跳到下一个原节点
        }

        // 第三步：拆分链表
        Node newHead = head.next;
        current = head;
        while (current != null) {
            Node newNode = current.next;
            current.next = newNode.next; // 恢复原链表
            current = current.next; // 移动到下一个原节点
            if (newNode.next != null) {
                newNode.next = newNode.next.next; // 链接新链表
            }
        }

        return newHead;
    }
}
