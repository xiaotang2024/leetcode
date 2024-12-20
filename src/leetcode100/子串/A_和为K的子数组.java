package leetcode100.子串;

import java.util.HashMap;

/**
 *
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 * 子数组是数组中元素的连续非空序列。
 *
 * 输入：nums = [1,1,1], k = 2
 * 输出：2
 */
public class A_和为K的子数组 {

    public static void main(String[] args) {
        A_和为K的子数组 code = new A_和为K的子数组();
        int res = code.subarraySum2(new int[]{1,1,1}, 2);
        System.out.println(res);
    }


    /**
     * 暴力解法 (可能超时）
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; ++start) {
            int sum = 0;
            for (int end = start; end >= 0; --end) {
                sum += nums[end];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 优化：哈希 + 前缀和
     * 思路：i = 4的前缀和 减去 i = 2 的前缀和就是 i = [3,4]的和。利用这个思路，加上哈希就能解
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum2(int[] nums, int k) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        int[] prefixSum = new int[nums.length + 1]; // 记录前缀和
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        // 当前位置 i 的前缀和
        for (int currentSum : prefixSum) {
            // 如果map种存在前缀和pre1 - pre 2 = k的情况。就代表有子串
            if (map.containsKey(currentSum - k)) {
                count += map.get(currentSum - k);
            }
            map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
        }
        return count;
    }
}
