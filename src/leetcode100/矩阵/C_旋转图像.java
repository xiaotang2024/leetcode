package leetcode100.矩阵;

import java.util.Arrays;

public class C_旋转图像 {
    public static void main(String[] args) {
        C_旋转图像 code = new C_旋转图像();
        int[][] matrix = new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        code.rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    /**
     * 思路 用4个变量记录上下左右。用2个变量记录界限（n x n矩阵）
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int begin = 0;
        int end = n - 1;
        // n x n矩阵
        while (end > begin) {
            int[] top = Arrays.copyOfRange(matrix[begin],begin,end + 1); // 上
            int[] left = getList(matrix,begin,end,begin ); // 左
            int[] right = getList(matrix,begin,end,end); //  右
            int[] end2 = Arrays.copyOfRange(matrix[end],begin,end + 1); // 下
            // 转第一行
            for (int j = begin,i = 0; j <= end; j++) {
                matrix[begin][j] = left[i++];
            }
            // 转最后一列
            for (int j = begin,i = 0; j <= end; j++) {
                matrix[j][end] = top[i++];
            }
            // 转最后一行
            for (int j = begin,i = 0; j <= end; j++) {
                matrix[end][j] = right[i++];
            }
            // 转第一列
            for (int j = begin,i = 0; j <=end; j++) {
                matrix[j][begin] = end2[i++];
            }
            begin++;
            end--;
        }
    }

    int[] getList(int[][] matrix,int l,int r,int k){
        int[] res = new int[r - l + 1];
        for (int j = l,i = 0; j <= r;j++) {
            res[r - j] = matrix[j][k];
        }
        return res;
    }
}
