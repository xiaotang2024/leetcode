package leetcode100.动态规划;

import java.util.Arrays;

/**
 * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 *
 * 输入：n = 12
 * 输出：3
 * 解释：12 = 4 + 4 + 4
 */
public class F_完全平方数 {
    public static void main(String[] args) {
        F_完全平方数 code = new F_完全平方数();
        int res = code.numSquares(12);
        System.out.println(res);
    }
    public int numSquares(int n) {

        int[] dp = new int[n + 1];
        // 初始化
        Arrays.fill(dp, Integer.MAX_VALUE);
        //当和为0时，组合的个数为0
        dp[0] = 0;
        // 遍历物品
        for (int i = 1; i * i <= n; i++) {
            // 遍历背包
            for (int j = i * i; j <= n ; j++) {
                // 每个物品的价值看作都为1，体积为 i*i
                dp[j] = Math.min(dp[j],dp[j - i*i] + 1);
            }
        }
        return dp[n];
    }
}
