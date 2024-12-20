package leetcode100.双指针;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 */
public class D_接雨水 {
    public static void main(String[] args) {
        D_接雨水 code = new D_接雨水();
        int res = code.trap(new int[]{4,2,0,3,2,5});
        int res2 = code.trap2(new int[]{4,2,0,3,2,5});
        System.out.println(res);
        System.out.println(res2);
    }

    /** 暴力解法（力扣提交超时）
     * 思路：按照列来计算。每一列雨水的高度，取决于，该列 左侧最高的柱子和右侧最高的柱子中最矮的那个柱子的高度。
     * 时间复杂度为O（n^2）力扣超时。下面介绍双指针优化
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int res = 0;

        for (int i = 0; i < height.length; i++) {
            // 第一个柱子和最后一个柱子不接雨水
            if (i == 0 || i == height.length - 1){
                continue;
            }
            int leftH = height[i]; // 记录左边柱子的最高高度
            int rightH = height[i];  // 记录右边柱子的最高高度
            // 遍历获取左边柱子的最高高度
            for (int l = 0; l < i; l++){
                if (height[l] > leftH){
                    leftH = height[l];
                }
            }
            // 遍历获取右边柱子的最高高度
            for (int r = i; r < height.length; r++){
                if (height[r] > rightH){
                    rightH = height[r];
                }
            }
            int h = Math.min(leftH,rightH) - height[i];
            if (h > 0){
                res += h;
            }
        }
        return res;
    }


    /** 双指针优化
     * 思路：根据上一题的思路。我们把每一列的左边最高柱子和右边最高柱子分别记录在数组maxLeft、maxRight
     * @param height
     * @return
     */
    public int trap2(int[] height) {
        int res = 0;
        int len = height.length;
        int[] maxLeft = new int[len];
        int[] maxRight = new int[len];
        // 初始值
        maxLeft[0] = height[0];
        for (int i = 1; i < len; i++) {
            // 这里就有点类似于动态规划了
            maxLeft[i] = Math.max(maxLeft[i - 1],height[i]);
        }
        maxRight[len - 1] = height[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1],height[i]);
        }
        for (int i = 0; i < len; i++) {
            // 第一个柱子和最后一个柱子不接雨水
            if (i == 0 || i == len - 1){
                continue;
            }
            int leftH = maxLeft[i]; // 记录左边柱子的最高高度
            int rightH = maxRight[i];  // 记录右边柱子的最高高度

            int h = Math.min(leftH,rightH) - height[i];
            if (h > 0){
                res += h;
            }
        }
        return res;
    }
}
