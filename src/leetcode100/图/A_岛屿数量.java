package leetcode100.图;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 *给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 *
 * 输入：grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * 输出：1
 */
public class A_岛屿数量 {

    Queue<Pair> queue = new LinkedList<>();
    Map<Integer,Integer> map = new HashMap<Integer,Integer>(){{
        put(0,-1); //上
        put(1,-1); //左
        put(2,1); // 下
        put(3,1);// 右
    }};
    public static void main(String[] args) {
        A_岛屿数量 code = new A_岛屿数量();
        char[][] grid1 = new char[][]{
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'},
        };
        char[][] grid2 = new char[][]{
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'},
        };
        // 方法一：深度优先遍历
        int dfs = code.numIslandsByDfs(grid1);
        // 方法二：广度优先遍历
        int bfs = code.numIslandsByBfs(grid2);
        System.out.println("DFS结果："+dfs);
        System.out.println("BFS结果："+bfs);

    }

    /** 方法一：DFS
     *  思路很简单，遍历二维数组，每次遇到1，就递归，把能遇到的1合并在一起形成一个岛屿。标记遍历到的节点
     *  遇到一个没有遍历过的节点陆地，计数器就加一，然后把该节点陆地所能遍历到的陆地都标记上。
     * @param grid
     * @return
     */
    public int numIslandsByDfs(char[][] grid) {
        int res = 0;
        for(int i = 0; i < grid.length ;i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == '1'){
                    dfs(grid,i,j);
                    res++;
                }
            }
        }
        return res;
    }
    void dfs(char[][] grid,int x,int y){
        if(x < 0 || y < 0|| x > grid.length - 1 || y > grid[x].length - 1 || grid[x][y] != '1'){
            return;
        }
        if(grid[x][y] == '1'){
            // 标记访问过的节点
            grid[x][y] = '2';
        }
        dfs(grid,x + 1,y); // 下
        dfs(grid,x,y - 1);  // 左
        dfs(grid,x - 1,y); // 上
        dfs(grid,x,y + 1); // 右
    }

    /** 方法二 BFS
     *
     * @param grid
     * @return
     */
    public int numIslandsByBfs(char[][] grid) {
        int res = 0;
        for(int i = 0; i < grid.length ;i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == '1'){
                    bfs(grid,i,j);
                    res++;
                }
            }
        }
        return res;
    }
    void bfs(char[][] grid,int x,int y){
        queue.offer(new Pair(x,y));
        while (!queue.isEmpty()){
            int curX = queue.peek().x;
            int curY = queue.poll().y; // 当前节点弹出队列
            for (int i = 0; i < 4; i++) {
                int nextX = 0,nextY = 0;
                if ( i == 0){// 上
                    nextX = curX;
                    nextY = curY - 1;
                }
                if ( i == 1){// 左
                    nextX = curX - 1;
                    nextY = curY;
                }
                if ( i == 2){// 下
                    nextX = curX;
                    nextY = curY + 1;
                }
                if ( i == 3){// 右
                    nextX = curX + 1;
                    nextY = curY;
                }
                if(nextX < 0 || nextY < 0|| nextX > grid.length - 1 || nextY > grid[nextX].length - 1 || grid[nextX][nextY] != '1'){
                    continue;
                }
                grid[nextX][nextY] = '2'; // 标记遍历到的节点
                queue.offer(new Pair(nextX,nextY)); // 把能遍历到的节点加入到队列，准备下一次遍历
            }
        }
    }

}

