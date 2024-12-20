package leetcode100.动态规划;

import leetcode100.utils.PrintUtils;

/**
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 输入：n = 2
 * 输出：2
 * 解释：有两种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶
 * 2. 2 阶
 */
public class A_爬楼梯 {

    public static void main(String[] args) {
        A_爬楼梯 code = new A_爬楼梯();
        PrintUtils.printMethodResult(()-> code.climbStairs(1000000000));
        PrintUtils.printMethodResult(()-> code.dfs(45));

    }

    /** 递推公式：dp[n] = dp[i - 2] + dp[ i - 1]
     * 理解：第n阶台阶，不是从n - 1阶迈上来的就是从n - 2阶迈上来的。dp数组的含义是到第n阶有几种方法，不是迈了几步到第n阶，所有不需要+1的。
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        // 1. 确定dp数组的含义。dp[n]表示到达n阶梯有dp[n]种方法
        int[] dp = new int[n + 3];
        // 2. 递推公式：dp[n] = dp[i - 2] + dp[ i - 1]

        // 3. dp数组初始化
        dp[1] = 1;
        dp[2] = 2;
        // 4. 遍历
        for (int i = 3; i <= n ; i++) {
            dp[i] = dp[i - 2] + dp[ i - 1];
        }
        return dp[n];
    }

    /**
     * 递归版本。力扣提交直接超时了
     * @param n
     * @return
     */
    public int dfs(int n){
        if (n == 0 || n == 1 || n == 2){
            return n;
        }
        return dfs(n - 2) + dfs(n - 1);
    }
}
