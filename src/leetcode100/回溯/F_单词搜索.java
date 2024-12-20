package leetcode100.回溯;

/** 单词搜索
 *
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 */
public class F_单词搜索 {

    public static void main(String[] args) {
        F_单词搜索 code = new F_单词搜索();
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};
        boolean res = code.exist(board, "ABCCED");
        System.out.println(res); // 输出应该为 true
    }

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, i, j, 0)) { // 把每个元素都当作起点尝试一下
                    return true; // 找到字符串
                }
            }
        }
        return false; // 没有找到字符串
    }

    private boolean dfs(char[][] board, String word, int i, int j, int index) {
        // 如果索引和单词长度相等，说明已成功匹配
        if (index == word.length()) {
            return true;
        }

        // 边界检查，当前字符是否匹配
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)) {
            return false; // 超出边界或字母不匹配
        }

        char temp = board[i][j];  // 暂存当前字符
        board[i][j] = '#'; // 标记为已访问

        // 进行上下左右的搜索
        boolean found = dfs(board, word, i + 1, j, index + 1) ||  // 下
                dfs(board, word, i - 1, j, index + 1) ||  // 上
                dfs(board, word, i, j + 1, index + 1) ||  // 右
                dfs(board, word, i, j - 1, index + 1);    // 左

        board[i][j] = temp; // 恢复字符状态
        return found; // 返回搜索结果
    }
}
