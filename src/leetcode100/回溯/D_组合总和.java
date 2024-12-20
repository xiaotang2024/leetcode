package leetcode100.回溯;


import java.util.ArrayList;
import java.util.List;

/** 组合总和
 *
 *给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 *
 * 输入：candidates = [2,3,6,7], target = 7
 * 输出：[[2,2,3],[7]]
 */
public class D_组合总和 {
    public static void main(String[] args) {
        D_组合总和 code = new D_组合总和();
        List<List<Integer>> result_1 = code.combinationSum(new int[]{2,3,6,7}, 7);
        List<List<Integer>> result_2 = code.combinationSum(new int[]{8,7,4,3}, 11);
        System.out.println(result_1);
        System.out.println(result_2);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtracking(candidates,target,res,new ArrayList<>(),0,0);
        return res;
    }

    void backtracking(int[] candidates, int target,List<List<Integer>> res,List<Integer> arr,int startIndex,int sum){
        if (target == sum){
            res.add(new ArrayList<>(arr));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++){
            if (sum > target) return;
            arr.add(candidates[i]);
            // startIndex传i，每次遍历从自己开始，允许重复
            backtracking(candidates,target,res,arr,i,sum + candidates[i]);
            // 回溯
            arr.remove(arr.size() - 1);
        }
    }
}
