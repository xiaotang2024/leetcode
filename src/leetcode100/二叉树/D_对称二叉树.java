package leetcode100.二叉树;

/**
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 *
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 */
public class D_对称二叉树 {

    public static void main(String[] args) {
        D_对称二叉树 code = new D_对称二叉树();

        TreeNode root = TreeNode.createBT(new Integer[]{1,2,2,null,3,null,3});
        boolean result = code.isSymmetric(root);
        System.out.println(result);
    }

    public boolean isSymmetric(TreeNode root) {
        return dfs(root.left,root.right);
    }

    /**
     * 递归
     * @param left 左子树
     * @param right 右子树
     * @return
     */
    boolean dfs(TreeNode left,TreeNode right){
        if (left == null && right != null) { // 一边未空，一遍不为空肯定不行
            return false;
        }
        if (left != null && right == null) { // 一边未空，一遍不为空肯定不行
            return false;
        }
        if (left == null && right == null) {
            return true;
        }
        if (left.val != right.val) {
            return false;
        }
        boolean le = dfs(left.left, right.right); // 比较外层，左子树的左节点和右子树的右节点比较
        boolean ri = dfs(left.right, right.left); // 比较内层，左子树的右节点和右子树的左节点比较

        return le && ri;
    }
}
