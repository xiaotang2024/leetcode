package leetcode100.二叉树;


import java.util.List;

/**
 *
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1,3,4]
 */
public class J_二叉树的右视图 {
    public static void main(String[] args) {
        J_二叉树的右视图 code = new J_二叉树的右视图();

        TreeNode root = TreeNode.createBT(new Integer[]{});
        List<Integer> res = code.rightSideView(root);
        System.out.println(res);
    }

    public List<Integer> rightSideView(TreeNode root) {


        return null;
    }

    void dfs(List<Integer> res,TreeNode root){

    }
}
