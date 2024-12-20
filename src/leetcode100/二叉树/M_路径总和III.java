package leetcode100.二叉树;

/**
 * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 *
 * 输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
 * 输出：3
 * 解释：和等于 8 的路径有 3 条，如图所示。
 */
public class M_路径总和III {


    public static void main(String[] args) {
        M_路径总和III code = new M_路径总和III();
        TreeNode root = TreeNode.createBT(new Integer[]{10,5,-3,3,2,null,11,3,-2,null,1});
        int result = code.pathSum(root, 8);

        System.out.println(result);
    }

    /**
     * 把书中的每个节点都当作起点尝试
     * @param root
     * @param targetSum
     * @return
     */
    public int pathSum(TreeNode root, long targetSum) {
        if (root == null) {
            return 0;
        }
        int ret = rootSum(root, targetSum);
        ret += pathSum(root.left, targetSum);
        ret += pathSum(root.right, targetSum);
        return ret;
    }

    /**
     * 以节点 root 为起点向下且满足路径总和为 val 的路径数目
     * @param root
     * @param targetSum
     * @return
     */
    public int rootSum(TreeNode root, long targetSum) {
        int ret = 0;

        if (root == null) {
            return 0;
        }
        int val = root.val;
        if (val == targetSum) {
            ret++;
        }

        ret += rootSum(root.left, targetSum - val);
        ret += rootSum(root.right, targetSum - val);
        return ret;
    }

}
