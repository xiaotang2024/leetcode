package leetcode100.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** N皇后（力扣51）
 *
 *按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 * 输入：n = 4
 * 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * 解释：如上图所示，4 皇后问题存在两个不同的解法。
 */
public class H_N皇后 {
    List<List<String>> res = new ArrayList<>();
    public static void main(String[] args) {
        H_N皇后 leetCode_8 = new H_N皇后();
        List<List<String>> result = leetCode_8.solveNQueens(4);
        for (List<String> list : result) {
            System.out.println(list);
        }
    }

    public List<List<String>> solveNQueens(int n) {
        char[][] chessboard = new char[n][n];
        for (char[] c : chessboard) {
            Arrays.fill(c, '.');
        }
        backTrack(n, 0, chessboard);
        return res;
    }


    /**
     *
     * @param n n x n棋盘
     * @param row 记录遍历到第几行
     * @param chessboard 棋盘
     */
    public void backTrack(int n, int row, char[][] chessboard) {
        if (row == n) {
            res.add(Array2List(chessboard));
            return;
        }

        for (int col = 0;col < n; ++col) {
            if (isValid (row, col, n, chessboard)) { // 是否符合规则
                chessboard[row][col] = 'Q';
                // 递归row + 1行
                backTrack(n, row+1, chessboard);
                // 回溯
                chessboard[row][col] = '.';
            }
        }

    }


    // 棋盘转为list
    public List Array2List(char[][] chessboard) {
        List<String> list = new ArrayList<>();

        for (char[] c : chessboard) {
            list.add(String.copyValueOf(c));
        }
        return list;
    }

    /**
     *  检查当前位置是否合法
     * @param row 当前行
     * @param col 当前列
     * @param n 棋盘大小
     * @param chessboard 棋盘
     * @return
     */
    public boolean isValid(int row, int col, int n, char[][] chessboard) {
        // 检查列
        for (int i=0; i<row; ++i) { // 相当于剪枝
            if (chessboard[i][col] == 'Q') {
                return false;
            }
        }

        // 检查45度对角线（只检查上边就可以了）
        for (int i=row-1, j=col-1; i>=0 && j>=0; i--, j--) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }

        // 检查135度对角线（只检查上边就可以了）
        for (int i=row-1, j=col+1; i>=0 && j<=n-1; i--, j++) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

}
