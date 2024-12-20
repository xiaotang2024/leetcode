package leetcode100.二叉树;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 *
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 */
public class A_中序遍历 {

    List<Integer> res = new ArrayList<>();

    public static void main(String[] args) {
        A_中序遍历 code = new A_中序遍历();
        List<Integer> result = code.inorderTraversal(TreeNode.createBT(new Integer[]{1,null,2,3}));
        System.out.println(result);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        dfs(root);
        return res;
    }

    void dfs(TreeNode root){
        if(root == null){
            return;
        }
        dfs(root.left);
        res.add(root.val);
        dfs(root.right);
    }
}
