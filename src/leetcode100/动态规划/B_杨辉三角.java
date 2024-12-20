package leetcode100.动态规划;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 *
 * 输入: numRows = 5
 * 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 */
public class B_杨辉三角 {
    public static void main(String[] args) {
        B_杨辉三角 code = new B_杨辉三角();
        List<List<Integer>> res = code.generate(5);
        System.out.println(res);
    }

    /** 递推公式：db[i][j] = db[i - 1][j - 1] + db[i - 1][j];
     * d[i][j]表示第i行第j列的杨辉三角的数字
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        int[][] db = new int[numRows][numRows];
        List<List<Integer>> result = new ArrayList<>();
        db[0][0] = 1;
        for (int i = 1; i < numRows; i++) {
            db[i][0] = 1;
            for (int j = 1; j < numRows; j++) {
                db[i][j] = db[i - 1][j - 1] + db[i - 1][j];
            }
        }
        // dp数组转结果集
        for (int[] row : db) {
            List<Integer> innerList = new ArrayList<>();
            for (int num : row) {
                if (num > 0) {
                    innerList.add(num);
                }
            }
            result.add(innerList);
        }
        return result;
    }
}
