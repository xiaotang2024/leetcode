package leetcode100.多维动态规划;

public class A_不同路径 {
    public static void main(String[] args) {
        A_不同路径 code = new A_不同路径();
        code.uniquePaths(3,7);
    }

    /**
     * 思路：当前位置的路径条数 = 上边位置路径条数 + 左边位置路径条数
     * 递推公式：dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
