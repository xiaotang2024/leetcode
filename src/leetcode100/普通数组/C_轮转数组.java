package leetcode100.普通数组;

import java.util.Arrays;

public class C_轮转数组 {

    public static void main(String[] args) {
        C_轮转数组 code = new C_轮转数组();
        int[] arr = new int[]{1,2,3,4,5,6,7};
        code.rotate2(arr,3);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 暴力解法
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int[] temp = new int[nums.length];
        for(int i = nums.length - k,j = 0; i < nums.length; i++,j++){
            temp[j] = nums[i];
        }
        for (int i = 0,j = k; i < nums.length - k; i++,j++){
            temp[j] = nums[i];
        }
        // 将结果拷贝到nums数组
        System.arraycopy(temp, 0, nums, 0, temp.length);
    }

    /**
     *  思路2：数组翻转
     * @param nums
     * @param k
     */
    public void rotate2(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }
}
