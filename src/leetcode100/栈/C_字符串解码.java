package leetcode100.栈;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class C_字符串解码 {
    public static void main(String[] args) {
        C_字符串解码 code = new C_字符串解码();
        String s = code.decodeString("3[a2[c]]");
        System.out.println(s);
    }

    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>(); // 存储数字
        Stack<StringBuilder> strStack = new Stack<>(); // 存储 StringBuilder
        StringBuilder currStr = new StringBuilder(); // 当前解码字符串
        int k = 0; // 当前的倍数

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = k * 10 + (ch - '0'); // 处理多位数
            } else if (ch == '[') {
                // 遇到 '['，将当前的字符串和数字推入各自的栈
                countStack.push(k);
                strStack.push(currStr);
                currStr = new StringBuilder(); // 重置当前字符串
                k = 0; // 重置倍数
            } else if (ch == ']') {
                // 遇到 ']'，解码
                StringBuilder temp = strStack.pop(); // 从栈中弹出先前的字符串
                int repeatTimes = countStack.pop(); // 弹出重复次数
                for (int i = 0; i < repeatTimes; i++) {
                    temp.append(currStr); // 重复当前字符串并拼接到 temp
                }
                currStr = temp; // 更新当前字符串
            } else {
                // 如果是字母，直接添加到当前字符串
                currStr.append(ch);
            }
        }
        return currStr.toString(); // 返回最终字符串
    }
}
