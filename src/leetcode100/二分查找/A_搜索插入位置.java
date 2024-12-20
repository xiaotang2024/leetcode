package leetcode100.二分查找;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 请必须使用时间复杂度为 O(log n) 的算法。
 *
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 */
public class A_搜索插入位置 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,5,6};
        int target = 7;
        System.out.println(searchInsert(arr,target));
    }

    /**
     * 时间复杂度：O(log n)
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while (right >= left){ // 为什么要加等号？因为这是左开右开的区间，左指针等于右指针是有意义的：[1]
             int mon = (left + right) / 2;
            if (target == nums[mon]){
                return mon;
            }
            if (target > nums[mon]){
                left = mon + 1; // 为什么要加1？因为 nums[mon]的地方已经搜索过了，所以要跳过。下面同理
            }
            if (target < nums[mon]){
                right = mon - 1;
            }
        }
        return left; // 如果没有匹配的元素返回左指针，他返回的是应该插入的位置
    }
}
