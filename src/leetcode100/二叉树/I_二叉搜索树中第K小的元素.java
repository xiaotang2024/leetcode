package leetcode100.二叉树;

/**
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 小的元素（从 1 开始计数）。
 *
 * 输入：root = [3,1,4,null,2], k = 1
 * 输出：1
 */
public class I_二叉搜索树中第K小的元素 {

    int res = 0;
    int k = 0;

    public static void main(String[] args) {
        I_二叉搜索树中第K小的元素 code = new I_二叉搜索树中第K小的元素();

        TreeNode root = TreeNode.createBT(new Integer[]{3, 1, 4, null, 2});
        int res = code.kthSmallest(root, 1);
        System.out.println(res);
    }

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }

    public void dfs(TreeNode root) {
        if (root == null ){
            return;
        }
        dfs(root.left);
        k--;
        if (k == 0){
            res = root.val;
        }
        dfs(root.right);
    }
}
