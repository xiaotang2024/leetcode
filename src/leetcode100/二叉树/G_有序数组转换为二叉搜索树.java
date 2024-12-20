package leetcode100.二叉树;

import java.util.List;

/**
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵平衡二叉搜索树。
 *
 *
 * 输入：nums = [-10,-3,0,5,9]
 * 输出：[0,-3,9,-10,null,5]
 */
public class G_有序数组转换为二叉搜索树 {
    public static void main(String[] args) {
        G_有序数组转换为二叉搜索树 code = new G_有序数组转换为二叉搜索树();

        TreeNode root = code.sortedArrayToBST(new int[]{-10,-3,0,5,9});
        List<Integer> res = TreeNode.levelOrder(root);
        System.out.println(res);
    }


    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = traversal(nums, 0, nums.length - 1);
        return root;
    }

    // 左闭右闭区间[left, right]
    // 先序遍历构造
    private TreeNode traversal(int[] nums, int left, int right) {
        if (left > right) return null;

        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]); // 构造根节点
        root.left = traversal(nums, left, mid - 1); // 根节点的左子树
        root.right = traversal(nums, mid + 1, right); // 根节点的右子树
        return root;
    }
}
