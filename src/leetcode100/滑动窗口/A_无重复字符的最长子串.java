package leetcode100.滑动窗口;


import java.util.HashSet;
import java.util.Set;

public class A_无重复字符的最长子串 {
    public static void main(String[] args) {
        A_无重复字符的最长子串 code = new A_无重复字符的最长子串();

        int result = code.lengthOfLongestSubstring("abcdbd");

        System.out.println(result);
    }

    /**
     * 外层循环扩展右边界，内层循环扩展左边界
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();//去重
        int res = 0;//结果
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            //set中有ch，则缩短左边界，同时移除set集合中重复元素前的所有元素
            while(set.contains(ch)) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));//别忘。将当前元素加入。
            res = Math.max(res, right - left + 1);//计算当前不重复子串的长度。
        }
        return res;
    }
}
