package leetcode100.矩阵;


import java.util.*;

/**
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 */
public class B_螺旋矩阵 {
    public static void main(String[] args) {
        B_螺旋矩阵 code = new B_螺旋矩阵();
        int[][] matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        List<Integer> res = code.spiralOrder(matrix);
        System.out.println(res);
    }

    /**
     * 没遍历一次就缩一圈。用4个变量记录记录行的开头与结尾以及列的开头和结尾
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        int lineBegin = 0, lineEnd = matrix[0].length - 1; //记录行的开头与结尾
        int listBegin = 0, listEnd = matrix.length - 1; //记录列的开头与结尾
        while (true) {
            // 第一行
            for (int j = lineBegin; j <= lineEnd; j++) {
                res.add(matrix[lineBegin][j]);
            }
            if(++listBegin > listEnd) break;
            // 最后一列
            for (int j = listBegin; j <= listEnd; j++) {
                res.add(matrix[j][lineEnd]);
            }
            if(--lineEnd < lineBegin) break;
            // 最后一行
            for (int j = lineEnd; j >= lineBegin ; j--) {
                res.add(matrix[listEnd][j]);
            }
            if(--listEnd < listBegin) break;
            // 第一列
            for (int j = listEnd; j >=listBegin ; j--) {
                res.add(matrix[j][lineBegin]);
            }
            if(++lineBegin > lineEnd) break;
        }
        return res;
    }
}
