package leetcode100.哈希;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class A_两数之和 {
    public static void main(String[] args) {
        A_两数之和 code = new A_两数之和();

        int[] res = code.twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(Arrays.toString(res));
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        int[] res = new int[2];
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(target - nums[i])){
                res[0] = map.get(target - nums[i]);
                res[1] = i;
                break;
            }
            map.put(nums[i],i);
        }
        return res;
    }
}
