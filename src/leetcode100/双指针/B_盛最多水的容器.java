package leetcode100.双指针;


/**
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 * 说明：你不能倾斜容器。
 *
 *
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 */
public class B_盛最多水的容器 {
    public static void main(String[] args) {
        B_盛最多水的容器 code = new B_盛最多水的容器();

        int res = code.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        System.out.println(res);
    }

    /** 双指针
     * 思路：搞清楚什么时候移动左指针，什么时候移动右指针
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int res = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right){
            int temp = Math.min(height[left],height[right]) * (right - left);
            res = Math.max(res,temp);
            if (height[left] > height[right]){
                right--;
            }else {
                left++;
            }
        }
        return res;
    }
}
