package leetcode100.动态规划;


import java.util.Arrays;

/**
 *
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * 你可以认为每种硬币的数量是无限的。
 *
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 */
public class G_零钱兑换 {

    public static void main(String[] args) {
        G_零钱兑换 code = new G_零钱兑换();
        int res = code.coinChange(new int[]{2,5,10,1}, 27);
        System.out.println(res);
    }

    /**
     * 类比完全背包问题。物品价值都当作 1
     * @param coins 类比物品体积
     * @param amount 类比背包容量
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int n = coins.length; // 物品数量
        int[] dp = new int[amount + 1];
        // 初始化
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                //只有dp[j-coins[i]]不是初始最大值时，该位才有选择的必要
                if (dp[j - coins[i]] != Integer.MAX_VALUE) {
                    //选择硬币数目最小的情况
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
