package leetcode100.二叉树;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）
 *
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[9,20],[15,7]]
 */
public class F_二叉树的层次遍历 {

    public static void main(String[] args) {
        F_二叉树的层次遍历 code = new F_二叉树的层次遍历();
        TreeNode root = TreeNode.createBT(new Integer[]{3,9,20,null,null,15,7});
        List<List<Integer>> result = code.levelOrder(root);
        System.out.println(result);
    }


    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root,res,0);
        return res;
    }

    /**
     * 用一个变量记录遍历到哪层了，就简单很多
     * @param root
     * @param res
     * @param row 记录遍历到哪层了
     */
    void dfs(TreeNode root,List<List<Integer>> res,int row){
        if (root == null){
            return;
        }
        // 如果当前层次已有元素了，就把集合拿出来加入一个新的元素
        if (res.size() > row){
            List<Integer> temp = res.get(row);
            temp.add(root.val);
        }else {
            // 如果没有，就创建新的节点加进去
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(root.val);
            res.add(new ArrayList<>(temp));
        }
        dfs(root.left,res,row + 1);
        dfs(root.right,res,row + 1);
    }
}
