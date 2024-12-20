package leetcode100.二叉树;

/**
 *
 * 给你一棵二叉树的根节点，返回该树的 直径 。
 * 二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。
 * 两节点之间路径的 长度 由它们之间边数表示。
 *
 * 输入：root = [1,2,3,4,5]
 * 输出：3
 * 解释：3 ，取路径 [4,2,1,3] 或 [5,2,1,3] 的长度。
 */
public class E_二叉树的直径 {
    int max =  1;
    public static void main(String[] args) {
        E_二叉树的直径 code = new E_二叉树的直径();
        TreeNode root = TreeNode.createBT(new Integer[]{1,2,3,4,5});
        int res = code.diameterOfBinaryTree(root);
        System.out.println(res);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return max - 1;
    }

    int dfs(TreeNode root){
        if (root == null){
            return 0;
        }
        int le = dfs(root.left);
        int ri = dfs(root.right);
        // max表示经过的节点的最大值
        max = Math.max(max, le + ri + 1);
        return Math.max(le,ri) + 1;
    }
}
