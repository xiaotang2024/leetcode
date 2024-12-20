package leetcode100.贪心;

/** 跳跃游戏
 *
 * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
 *
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 */
public class LeetCode_2 {
    public static void main(String[] args) {
        LeetCode_2 code = new LeetCode_2();
        boolean res = code.canJump(new int[]{2});
        System.out.println(res);
    }

    public boolean canJump(int[] nums) {
        int cover = 0; // 覆盖范围
        for (int i = 0; i <= cover; i++){ // i <= cover的意思是，只能跳到覆盖范围内
            cover = Math.max(i + nums[i],cover); // 更新覆盖范围
            if (cover >= nums.length - 1){
                return true;
            }
        }
        return false;
    }
}
