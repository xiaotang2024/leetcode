package leetcode100.动态规划;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 有n件物品和一个最多能背重量为w 的背包。第i件物品的重量是weight[i]，得到的价值是value[i] 。每件物品只能用一次，求解将哪些物品装入背包里物品价值总和最大。
 *
 * 例题：
 *      重量  价值
 * 物品0  1    15
 * 物品1  3    20
 * 物品2  4    30
 *
 * 输入：3 4 1 3 4 15 20 30
 */
public class D_01背包问题 {

    public static void main(String[] args) {
        D_01背包问题 code = new D_01背包问题();
        code.test2();
//        code.test3();
    }

    /** 方法一：二维dp数组
     * dp[i][j] i 来表示物品、j表示背包容量。表示从0到i之间物品任取，放在容量为j的背包的最大价值
     * 不放物品i：dp[i - 1][j]
     * 放物品i：dp[i - 1][j - weight[i]] + value[i]
     * 所以递推公式：dp[i][j] = max(dp[i - 1][j],dp[i - 1][j - weight[i]] + value[i])
     */
    public void test1(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 物品数量
        int bagWeight = scanner.nextInt(); // 背包容量

        int[] weight = new int[n]; // 体积
        int[] value = new int[n]; // 价值

        for (int i = 0; i < n; ++i) {
            weight[i] = scanner.nextInt();
        }
        for (int j = 0; j < n; ++j) {
            value[j] = scanner.nextInt();
        }

        int[][] dp = new int[n][bagWeight + 1];

        // 给初始值
        for (int j = weight[0]; j <= bagWeight; j++) {
            dp[0][j] = value[0];
        }
        // 先遍历物品，再遍历背包（可调换顺序）
        for (int i = 1; i < n; i++) { // 遍历物品
            for (int j = 0; j <= bagWeight; j++) { // 遍历背包
                if (j >= weight[i]){
                    // 递推公式
                    // 比较规则：当前物品下和上一次背包容量下的价值相比较，如果加上本次物品i后的价值超过了上一次容量的价值就更新当前容量的最大价值
                    dp[i][j] = Math.max(dp[i - 1][j],dp[i - 1][j - weight[i]] + value[i]);
                }else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        // 先遍历背包，再遍历物品
//        for (int j = 1; j <= bagWeight ; j++) {
//            for (int i = 1; i < n; i++) {
//                if (j >= weight[i]){
//                    // 递推公式
//                    dp[i][j] = Math.max(dp[i - 1][j],dp[i - 1][j - weight[i]] + value[i]);
//                }else {
//                    dp[i][j] = dp[i - 1][j];
//                }
//            }
//        }
        System.out.println(Arrays.deepToString(dp)); // 打印dp数组
        System.out.println("最大价值：" + dp[n - 1][bagWeight]); // 打印结果
    }

    /** 方法二：一维dp数组（不好理解）
     * dp[j] 容量为j的背包的最大价值。
     * 用了滚动数组的思想，其实就是覆盖上一个物品的价值。
     */
    public void test2(){
        Scanner scanner = new Scanner(System.in);

        // 读取 M 和 N
        int M = scanner.nextInt();  // 物品数量
        int N = scanner.nextInt();  // 背包容量

        int[] weight = new int[M];   // 体积
        int[] values = new int[M];  // 价值

        // 输入每种材料的空间占用
        for (int i = 0; i < M; i++) {
            weight[i] = scanner.nextInt();
        }

        // 输入每种材料的价值
        for (int j = 0; j < M; j++) {
            values[j] = scanner.nextInt();
        }

        // 创建一个动态规划数组 dp，初始值为 0
        int[] dp = new int[N + 1];

        // 先遍历物品，再遍历背包（不能调换顺序）
        for (int i = 0; i < M; i++) {  // 先遍历物品。
            for (int j = N; j >= weight[i]; j--) { // 再遍历背包。顺序不能颠倒，背包也必须倒序遍历
                // 如果本次可选择的物品的价值比上一次的大，就覆盖调上一次的。
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + values[i]);
            }
            System.out.println(Arrays.toString(dp));
        }

        // 输出 dp[N]，即在给定 N 行李空间可以携带的研究材料的最大价值
        System.out.println(dp[N]);

        scanner.close();
    }

    public void test3(){
        Scanner scanner = new Scanner(System.in);

        // 读取 M 和 N
        int M = scanner.nextInt();  // 物品数量
        int N = scanner.nextInt();  // 背包容量

        int[] weight = new int[M];   // 体积
        int[] values = new int[M];  // 价值

        // 输入每种材料的空间占用
        for (int i = 0; i < M; i++) {
            weight[i] = scanner.nextInt();
        }

        // 输入每种材料的价值
        for (int j = 0; j < M; j++) {
            values[j] = scanner.nextInt();
        }

        // 创建一个动态规划数组 dp，初始值为 0
        int[] dp = new int[N + 1];

        for (int i = 0; i < M; i++) {  // 先遍历物品。
            for (int j = weight[i]; j <= N; j++) { // 再遍历背包。顺序不能颠倒，背包也必须倒序遍历
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + values[i]);
            }
            System.out.println(Arrays.toString(dp));
        }

        // 输出 dp[N]，即在给定 N 行李空间可以携带的研究材料的最大价值
        System.out.println(dp[N]);

        scanner.close();
    }
}
