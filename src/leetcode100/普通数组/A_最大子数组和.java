package leetcode100.普通数组;

/**
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。子数组是数组中的一个连续部分。
 *
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 */
public class A_最大子数组和 {

    public static void main(String[] args) {
        A_最大子数组和 code = new A_最大子数组和();
        int res = code.maxSubArray(new int[]{-1,-1,-1,1,2});
        System.out.println(res);
    }

    /**
     * 基于了动态规划的思想
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int pre = 0; // 记录遍历到的位置的最大和
        int maxAns = nums[0]; // 记录全局的最大和
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }
}
