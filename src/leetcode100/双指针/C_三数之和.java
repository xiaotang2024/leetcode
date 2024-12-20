package leetcode100.双指针;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * 《三数之和》
 *
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，
 * 同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 */
public class C_三数之和 {
    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
    }


    /**
     * 时间复杂的：O(n^2)
     * 空间复杂度 O(1)
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            int x = nums[i];
            if (i > 0 && x == nums[i-1]) continue; // 跳过重复元素
            int left = i + 1;
            int right = len - 1;
            while (right > left){
                int s = x + nums[left] + nums[right];
                if (s < 0) left++;
                else if (s > 0) right--;
                else {
                    // 找到答案了
                    result.add(Arrays.asList(x,nums[left],nums[right]));
                    // 跳过重复元素
                    while (right > left && nums[left] == nums[left + 1]) left++;
                    while (right > left && nums[right] == nums[right - 1]) right--;
                    left++; // 继续寻找下一个
                    right--;
                }
            }
        }
        return result;
    }
}
