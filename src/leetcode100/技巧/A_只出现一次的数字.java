package leetcode100.技巧;


/**
 * 给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。
 *
 * 输入：nums = [2,2,1]
 * 输出：1
 */
public class A_只出现一次的数字 {
    public static void main(String[] args) {
        A_只出现一次的数字 code = new A_只出现一次的数字();
        int res = code.singleNumber(new int[]{2, 2, 1});
        System.out.println(res);
    }

    /**
     * 思路：异或运算。（同0异1）
     * 1、相同元素异或得0
     * 2、0与其他数异或得其他数
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int len = nums.length;
        int res = 0;
        for(int i = 0; i < len; i++){
            res ^= nums[i];
        }
        return res;
    }
}
