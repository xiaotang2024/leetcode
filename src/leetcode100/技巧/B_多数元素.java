package leetcode100.技巧;


import java.util.Arrays;

/**
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 输入：nums = [2,2,1,1,1,2,2]
 * 输出：2
 */
public class B_多数元素 {
    public static void main(String[] args) {
        B_多数元素 code = new B_多数元素();
        int res = code.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2});
        System.out.println(res);
    }

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
