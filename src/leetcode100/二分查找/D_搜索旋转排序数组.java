package leetcode100.二分查找;

/**
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * <p>
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 * <p>
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 * <p>
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 *
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 */
public class D_搜索旋转排序数组 {

    public static void main(String[] args) {
        int[] arr = new int[]{4,5,6,7,0,1,2};
        System.out.println(search(arr,0));
    }

    /**
     * 每次二分都会至少存在一个顺序区间。
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {
        int len = nums.length;
        int left = 0, right = len - 1;
        if (len == 0) {
            return -1;
        }
        if (len == 1) {
            return nums[0] == target ? 0 : -1;
        }
        while(right >= left){
            int mid = (right + left) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] >= nums[0]) {
                // 有序的一边，按正常的二分查找
                if (nums[0] <= target && nums[mid] > target){
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }else {
                // 无序的一边
                if (target > nums[mid] && target <= nums[len - 1]){
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
