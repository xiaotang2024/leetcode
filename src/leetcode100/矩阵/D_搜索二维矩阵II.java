package leetcode100.矩阵;


/**
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 *
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 *
 * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
 * 输出：true
 */
public class D_搜索二维矩阵II {
    public static void main(String[] args) {

        D_搜索二维矩阵II code = new D_搜索二维矩阵II();
        boolean res = code.searchMatrix(new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}}, 5);
        System.out.println(res);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            if (target >= matrix[i][0] && target <= matrix[i][matrix[i].length - 1]){
                // 二分查找
                boolean ans = binarySearch(matrix[i], target);
                if (ans){
                    return true;
                }
            }
        }
        return false;
    }

    boolean binarySearch(int[] arr, int target){
        int left = 0;
        int right = arr.length - 1;
        while (right >= left){
            int mid = (right + left) / 2;
            if (arr[mid] > target){
                right = mid - 1;
            }else if (arr[mid] < target){
                left = mid + 1;
            }else {
                return true;
            }
        }
        return false;
    }

}
