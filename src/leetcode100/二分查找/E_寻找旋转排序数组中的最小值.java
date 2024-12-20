package leetcode100.二分查找;

public class E_寻找旋转排序数组中的最小值 {
    public static void main(String[] args) {
        E_寻找旋转排序数组中的最小值 code = new E_寻找旋转排序数组中的最小值();
        int res = code.findMin(new int[]{3, 4, 5, 1, 2});
        System.out.println(res);
    }

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int res = 0;
        while(right >= left){
            // 只剩两个节点，选小的那个
            if(right - left == 1){
                res = Math.min(nums[left],nums[right]);
                break;
            }
            int mid = (left + right) / 2;
            if(nums[mid] > nums[left] && nums[mid] > nums[right]){
                // 左边是有序的，右边是旋转了的。移动右指针
                left = mid;
            }else if(nums[mid] < nums[right] && nums[mid] < nums[left]){
                // 右边是有序的，左边是旋转了的，移动左指针
                right = mid;
            }else {
                // 数组是有序的，直接返回第一个元素
                res = nums[0];
                break;
            }
        }
        return res;
    }
}
