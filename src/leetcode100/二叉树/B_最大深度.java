package leetcode100.二叉树;

/**
 * 给定一个二叉树 root ，返回其最大深度。
 * 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
 *
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：3
 */
public class B_最大深度 {

    public static void main(String[] args) {
        B_最大深度 code = new B_最大深度();
        // 构造二叉树
        TreeNode root = TreeNode.createBT(new Integer[]{3,9,20,null,null,15,7});

        int result = code.maxDepth(root);
        System.out.println(result);
    }

    public int maxDepth(TreeNode root) {
        return dfs(root);
    }
    int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = dfs(root.left) + 1;
        int right = dfs(root.right) + 1;
        return Math.max(left,right);
    }
}
