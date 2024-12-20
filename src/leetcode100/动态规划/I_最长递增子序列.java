package leetcode100.动态规划;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 *
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的
 * 子序列
 * 。
 *
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 */
public class I_最长递增子序列 {
    public static void main(String[] args) {
        I_最长递增子序列 code = new I_最长递增子序列();
        int res = code.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18});
        System.out.println(res);
    }

    /**
     * dp[i] 以nums[i]为尾的最长子序列长度
     *
     * dp[i] = Math.max(dp[j] + 1, dp[i]);
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        int res = 1;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
                res = Math.max(res,dp[i]);
            }
        }
        return res;
    }
}
