package leetcode100.二分查找;

import java.util.Arrays;

/**
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 *
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 */
public class C_在排序数组中查找元素的第一个和最后一个位置 {
    public static void main(String[] args) {
        int[] arr = new int[]{5,7,7,8,8,10};
        System.out.println(Arrays.toString(searchRange(arr, 8)));
    }

    /**
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1,-1};
        int left = 0;
        int right = nums.length - 1;
        while(right >= left){
            int middle = (right + left) / 2;
            if (nums[middle] < target) left = middle + 1;
            else if (nums[middle] > target) right = middle - 1;
            else {
                // 处理相等值情况
                int p = middle;
                int q = middle;
                while (p > 0 && target == nums[p - 1]) p--;
                while (q < nums.length - 1 && target == nums[q + 1]) q++;
                result[0] = p;
                result[1] = q;
                return result;
            }
        }
        return result;
    }
}
