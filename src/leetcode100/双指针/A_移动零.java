package leetcode100.双指针;

import java.util.Arrays;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 *
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 */
public class A_移动零 {
    public static void main(String[] args) {
        A_移动零 code = new A_移动零();
        int[] arr = new int[]{0,0};
        code.moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }


    /**
     * 思路：遇到0就直接那后面的数填充就好了。最后在处理应该变为0的数
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int p = 0;
        for(int i = 0 ;i<nums.length;i++){
            if(nums[i] != 0){
                nums[p] = nums[i];
                p++;
            }
        }
        for(;p<nums.length;p++){
            nums[p] = 0;
        }
    }
}
