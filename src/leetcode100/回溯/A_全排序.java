package leetcode100.回溯;

import java.util.ArrayList;
import java.util.List;

/** 全排序
 *
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */
public class A_全排序 {
    public static void main(String[] args) {
        List<List<Integer>> list = permute(new int[]{1,2,3});
        System.out.println(list);
    }


    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtracking(result,nums,new ArrayList<>(), new boolean[nums.length]);
        return result;
    }


    static void backtracking(List<List<Integer>> res, int[] nums,List<Integer> arr,boolean[] used){
        if ( nums.length == arr.size() ){
            res.add(new ArrayList<>(arr));
            return;
        }
        for (int i = 0; i < nums.length; i++){ // 全排序问题，这里每次都是要从0开始的
            // 1. 处理节点
            if (used[i]) continue;
            used[i] = true; //标记
            arr.add(nums[i]);
            // 2. 递归
            backtracking(res,nums,arr,used);
            // 3. 回溯
            arr.remove(arr.size() - 1);
            used[i] = false; // 恢复标记
        }
    }

}
