package leetcode100.滑动窗口;

public class 模板 {

    static  int n = 10;
    public static void main(String[] args) {
        //外层循环扩展右边界，内层循环扩展左边界
        for (int l = 0, r = 0 ; r < n ; r++) {
            //当前考虑的元素
            while (l <= r && check()) {//区间[left,right]不符合题意
                //扩展左边界
            }
            //区间[left,right]符合题意，统计相关信息
        }
    }

    static boolean check(){return true;}
}
