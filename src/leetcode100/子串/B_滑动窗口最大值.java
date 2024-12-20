package leetcode100.子串;


import java.util.Deque;
import java.util.LinkedList;

/**
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回 滑动窗口中的最大值 。
 *
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 */
public class B_滑动窗口最大值 {
    public static void main(String[] args) {

    }


    /** 方法一
     * 脑力解法直接超时
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int[] res = new int[len - k + 1];
        int l = 0, r = k - 1, i = 0;
        while (r < len) {
            res[i++] = max(nums, l, r);
            l++;
            r++;
        }
        return res;
    }
    /**
     * 单调队列的思想（单调递减）
     * 移动窗口：如果前一个元素在队首就要删除，并且新加元素后保证队列是单调的，那么此时的队首元素就是当前窗口的最大值
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums.length == 0 || k == 0)
            return new int[0];
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        // 未形成窗口(0,k)
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && deque.peekLast() < nums[i])
                deque.removeLast();
            deque.addLast(nums[i]);
        }
        res[0] = deque.peekFirst();
        // 形成窗口后(k,n)
        for (int i = k; i < nums.length; i++) {
            // 上一个左边元素在队首，要去掉
            if (deque.peekFirst() == nums[i - k])
                deque.removeFirst();
            // 新加元素的话要保证队列单调
            while (!deque.isEmpty() && deque.peekLast() < nums[i])
                deque.removeLast();
            deque.addLast(nums[i]);
            // 队首元素及最大值
            res[i - k + 1] = deque.peekFirst();
        }
        return res;
    }

    int max(int[] nums,int l,int r){
        int max = Integer.MIN_VALUE;
        for(int i = l; i <= r; i++){
            max = Math.max(max,nums[i]);
        }
        return max;
    }
}
