package leetcode100.图;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *
 * 在给定的 m x n 网格 grid 中，每个单元格可以有以下三个值之一：
 *
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 * 每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。
 *
 * 返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。
 *
 *
 *
 * 输入：grid = [[2,1,1],[1,1,0],[0,1,1]]
 * 输出：4
 */
public class B_腐烂的橘子 {
    public static void main(String[] args) {
        B_腐烂的橘子 code = new B_腐烂的橘子();

        int[][] grid = new int[][]{{2,1,1},{1,1,1},{0,1,2}};

        int res = code.orangesRotting(grid);
        System.out.println(res);
    }

    public int orangesRotting(int[][] grid) {
        // 统计新鲜橙子
        int freshNum = 0;
        // 统计腐烂橘子
        Deque<Pair> queue = new ArrayDeque<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2){
                    queue.add(new Pair(i,j));
                }
                if (grid[i][j] == 1){
                    freshNum++;
                }
            }
        }
        return bfs(grid,queue,freshNum);
    }

    int bfs(int[][] grid,Deque<Pair> queue,int freshNum){
        int minutes = 0;
        while (!queue.isEmpty()){
            if (freshNum == 0) {
                // 没有新鲜橙子了
                return minutes;
            }
            // 过去1分钟，周围开始腐烂
            minutes++;
            int size = queue.size(); // 这一步很重要，for循环前拿到size
            for (int i = 0; i < size; i++) {
                Pair pair = queue.poll();
                int currX = pair.x;
                int currY = pair.y;
                freshNum -= roting(grid, currX - 1, currY, queue); // 左
                freshNum -= roting(grid, currX + 1, currY, queue); // 右
                freshNum -= roting(grid, currX, currY - 1, queue); // 下
                freshNum -= roting(grid, currX, currY + 1, queue); // 上
            }
        }
        return freshNum > 0 ? -1 : minutes;
    }
    private int roting(int[][] grid, int x, int y, Deque<Pair> queue) {
        if (x < 0 || y < 0 || x > grid.length - 1 || y > grid[0].length - 1 || grid[x][y] != 1) {
            return 0;
        }
        grid[x][y] = 2; // 标记为腐烂
        queue.offer(new Pair(x, y));
        return 1;
    }
}


