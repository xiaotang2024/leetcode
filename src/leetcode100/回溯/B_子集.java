package leetcode100.回溯;

import java.util.ArrayList;
import java.util.List;

/** 子集
 *
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 */
public class B_子集 {
    public static void main(String[] args) {
        B_子集 code = new B_子集();
        List<List<Integer>> result = code.subsets(new int[]{1, 2, 3});
        System.out.println(result);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtracking(0,nums,result,new ArrayList<>());
        return result;
    }
    void backtracking(int start,int[] nums,List<List<Integer>> res,List<Integer> arr){
        res.add(new ArrayList<>(arr));

        for(int i = start; i < nums.length; i++){
            // 1.处理节点
            arr.add(nums[i]);
            // 2.递归
            backtracking(i+1,nums,res,arr);
            // 3.回溯
            arr.remove(arr.size() - 1);
        }
    }
}
