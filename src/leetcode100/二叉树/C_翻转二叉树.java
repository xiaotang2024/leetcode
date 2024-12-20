package leetcode100.二叉树;

import java.util.List;

/**
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 *
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 */
public class C_翻转二叉树 {

    public static void main(String[] args) {
        C_翻转二叉树 code = new C_翻转二叉树();
        TreeNode root = TreeNode.createBT(new Integer[]{4, 2, 7, 1, 3, 6, 9});

        TreeNode result = code.invertTree(root);
        List<Integer> print = TreeNode.levelOrder(result); // 层次遍历
        System.out.println(print);
    }

    public TreeNode invertTree(TreeNode root) {
        dfs(root);
        return root;
    }

    void dfs(TreeNode root){
        if (root == null){
            return;
        }
        // 交换左右子树
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        dfs(root.left);
        dfs(root.right);
    }
}
