package leetcode100.贪心;

/**《买股票的最佳时机》（力扣121）
 *给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 */
public class LeetCode_1 {
    public static void main(String[] args) {
        int[] prices= new int[]{7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
    public static int maxProfit(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0; // 最大利润
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i]; // 记录最低点
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice; // 最大利润
            }
        }
        return maxprofit;
    }
}
