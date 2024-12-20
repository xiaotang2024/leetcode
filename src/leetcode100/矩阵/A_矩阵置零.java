package leetcode100.矩阵;

import java.util.*;

/**
 *给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 *
 * 输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * 输出：[[1,0,1],[0,0,0],[1,0,1]]
 */
public class A_矩阵置零 {
    public static void main(String[] args) {
        A_矩阵置零 code = new A_矩阵置零();
        int[][] matrix = new int[][]{{1,1,1},{1,0,1},{1,1,1}};
        code.setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    /** 方法一
     * 暴力解法
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = col[j] = true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    /**方法二
     * 减少空间复杂度
     * 1. 首先检查并标记第一行和第一列是否需要置为零（rowFlag 和 colFlag）。
     * 2. 然后遍历剩余的元素，如果为零，则将其所在的行和列的开头元素置为零。
     * @param matrix
     */
    public void setZeroes2(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean rowFlag = false; // 标记第一行是否需要置零
        boolean colFlag = false; // 标记第一列是否需要置零

        // 检查第一行和第一列
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) {
                colFlag = true; // 第一列需要置零
                break;
            }
        }

        for (int j = 0; j < cols; j++) {
            if (matrix[0][j] == 0) {
                rowFlag = true; // 第一行需要置零
                break;
            }
        }

        // 使用第一行和第一列来标记零
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0; // 标记当前行
                    matrix[0][j] = 0; // 标记当前列
                }
            }
        }

        // 将标记的行和列置零
        for (int i = 1; i < rows; i++) {
            if (matrix[i][0] == 0) {
                Arrays.fill(matrix[i], 0); // 行置零
            }
        }

        for (int j = 1; j < cols; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 0; i < rows; i++) {
                    matrix[i][j] = 0; // 列置零
                }
            }
        }

        // 根据第一行和第一列的标记置零
        if (rowFlag) {
            Arrays.fill(matrix[0], 0); // 第一行置零
        }
        if (colFlag) {
            for (int i = 0; i < rows; i++) {
                matrix[i][0] = 0; // 第一列置零
            }
        }
    }

}
