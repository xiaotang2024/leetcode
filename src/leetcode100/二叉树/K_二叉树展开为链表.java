package leetcode100.二叉树;

import java.util.List;

/**
 *
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 *
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 *
 * 输入：root = [1,2,5,3,4,null,6]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6]
 */
public class K_二叉树展开为链表 {
    TreeNode preNode;
    public static void main(String[] args) {
        K_二叉树展开为链表 code = new K_二叉树展开为链表();
        TreeNode root = TreeNode.createBT(new Integer[]{1, 2, 5, 3, 4, null, 6});
        code.flatten(root);

        List<Integer> res = TreeNode.levelOrder(root);
        System.out.println(res);
    }


    // 反前序遍历 (右左中)
    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.right);
        flatten(root.left);
        root.left = null;
        root.right = preNode;
        preNode = root;
    }
}
