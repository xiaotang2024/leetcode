package leetcode100.二叉树;

/**
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 *
 * 输入：root = [2,1,3]
 * 输出：true
 */
public class H_验证二叉搜索树 {

    long val = Long.MIN_VALUE;

    public static void main(String[] args) {
        H_验证二叉搜索树 code = new H_验证二叉搜索树();

        TreeNode root = TreeNode.createBT(new Integer[]{-2147483648});
        boolean res = code.isValidBST(root);
        System.out.println(res);
    }


    public boolean isValidBST(TreeNode root) {
        return dfs(root);
    }

    // 对于二叉搜索树，中序遍历就是有序的
    boolean dfs(TreeNode root){
        if (root == null){
            return true;
        }
        boolean L = dfs(root.left);
        // 每次都会更新这个值，没更新的话就不是二叉搜索树
        if (root.val > val){
            val = root.val;
        }else {
            return false;
        }
        boolean R = dfs(root.right);
        return L &&  R;
    }

}
