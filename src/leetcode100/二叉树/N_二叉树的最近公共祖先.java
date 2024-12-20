package leetcode100.二叉树;

import leetcode100.链表.ListNode;

import java.util.Arrays;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 */
public class N_二叉树的最近公共祖先 {

    public static void main(String[] args) {

        N_二叉树的最近公共祖先 code = new N_二叉树的最近公共祖先();
        TreeNode root = TreeNode.createBT(new Integer[]{3,5,1,6,2,0,8,null,null,7,4});
        code.lowestCommonAncestor(root,new TreeNode(5),new TreeNode(4));
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 如果当前节点为空或者当前节点是p或q，直接返回当前节点
        if(root == null || root == p || root == q) return root;

        // 递归查找左子树中的最低公共祖先
        TreeNode left = lowestCommonAncestor(root.left, p, q);

        // 递归查找右子树中的最低公共祖先
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 如果左子树和右子树都没有找到p或q，返回null
        if(left == null && right == null) return null; // 1. 此时没有找到任何一个节点

        // 如果左子树没有找到，返回右子树的结果
        if(left == null) return right; // 3. 只有右子树找到了一个节点

        // 如果右子树没有找到，返回左子树的结果
        if(right == null) return left; // 4. 只有左子树找到了一个节点

        // 如果左右子树都找到了节点，则当前节点为最低公共祖先
        return root; // 2. if(left != null and right != null)
    }
}
