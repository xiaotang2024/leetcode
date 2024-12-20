package leetcode100.动态规划;

public class J_乘积最大子数组 {
    public static void main(String[] args) {
        J_乘积最大子数组 code = new J_乘积最大子数组();
        int res = code.maxProduct(new int[]{0, 2});
        System.out.println(res);
    }

    public int maxProduct(int[] nums) {
        int maxProduct = nums[0];
        int minProduct = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                // 如果当前值为负，则交换最大和最小乘积
                int temp = maxProduct;
                maxProduct = minProduct;
                minProduct = temp;
            }

            // 更新最大和最小乘积
            maxProduct = Math.max(nums[i], maxProduct * nums[i]);
            minProduct = Math.min(nums[i], minProduct * nums[i]);

            // 更新结果
            result = Math.max(result, maxProduct);
        }

        return result;
    }
}
