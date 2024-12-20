package leetcode100.哈希;

import java.util.Arrays;

/**
 *
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 */
public class C_最长连续序列 {

    public static void main(String[] args) {
        C_最长连续序列 code = new C_最长连续序列();
        int res = code.longestConsecutive(new int[]{100,4,200,1,3,2});
        System.out.println(res);
    }


    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int num = 1;
        int x = num;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] + 1 == nums[i + 1]) {
                num++;
                x = Math.max(num, x);
            } else if (nums[i] == nums[i + 1]) {
                continue;
            } else {
                num = 1;
            }
        }
        return x;
    }
}
