package leetcode100.栈;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 */
public class A_有效的括号 {
    public static void main(String[] args) {
        String s = new String("[{()}]");
        A_有效的括号 code = new A_有效的括号();
        System.out.println(code.isValid(s));
    }

    // 遇到左括号，就把对应的右括号加入到栈
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char ch : chars) {
            if (ch == '('){
                stack.push(')');
            }else if (ch == '{'){
                stack.push('}');
            }else if (ch == '['){
                stack.push(']');
            }else if (stack.isEmpty() || stack.peek() != ch){ // 不匹配或者栈为空(右括号没有对应的左括号栈就会为空)
                return false;
            }else {
                stack.pop(); // 匹配，弹出栈顶元素
            }
        }
        return stack.isEmpty();
    }
}
