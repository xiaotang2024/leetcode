package leetcode100.栈;

import java.util.Arrays;
import java.util.Stack;

/**
 * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，
 * 下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 *
 *
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出: [1,1,4,2,1,1,0,0]
 */
public class D_每日温度 {

    public static void main(String[] args) {
        D_每日温度 code = new D_每日温度();
        int[] res = code.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        System.out.println(Arrays.toString(res));
    }

    /**
     * 单调栈（升序）
     * 思路：由于栈是升序的，所以如果加入的元素大于栈顶的元素，就要把栈顶的元素弹出栈。对于栈顶的元素来说，就找到了第一个比自身大的元素也就是当前要加入的元素。
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < temperatures.length; i++){
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                Integer temp = stack.pop();
                res[temp] = i - temp;
            }
            stack.add(i);
        }
        // 栈中剩余的元素不用管。因为数组的默认值就是0
        return res;
    }
}
