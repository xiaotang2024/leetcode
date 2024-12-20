package leetcode100.二分查找;

/**
 * 给你一个满足下述两条属性的 m x n 整数矩阵：
 *
 * 每行中的整数从左到右按非严格递增顺序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false 。
 *
 *
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * 输出：true
 */
public class B_搜索二维矩阵 {
    public static void main(String[] args) {
        B_搜索二维矩阵 code = new B_搜索二维矩阵();
        boolean res = code.searchMatrix(new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}}, 5);
        System.out.println(res);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i =0;i < matrix.length; i++){
            if(matrix[i][0] == target || matrix[i][matrix[i].length - 1]==target) return true;
            if(target > matrix[i][0] && target < matrix[i][matrix[i].length - 1]){
                return search(matrix[i],target);
            }
        }
        return false;
    }

    boolean search( int[] arr,int target){
        int left = 0;
        int rigth = arr.length - 1;
        while(rigth >= left){
            int modie = (rigth + left)/2;
            if(arr[modie] > target){
                rigth = modie - 1;
            }else if(arr[modie] < target){
                left = modie + 1;
            }else{
                return true;
            }
        }
        return false;
    }
}
