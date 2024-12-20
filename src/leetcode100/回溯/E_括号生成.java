package leetcode100.回溯;

import java.util.ArrayList;
import java.util.List;

/** 括号生成（没理解）
 *
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 */
public class E_括号生成 {
    public static void main(String[] args) {
        E_括号生成 code = new E_括号生成();
        List<String> res = code.generateParenthesis(3);
        System.out.println(res);
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs(result,new StringBuilder(),n,0,0);
        return result;
    }

    // 递归
    void dfs(List<String> res, StringBuilder str,int n,int left,int right){
        if (str.length() == n*2){
            res.add(str.toString());
        }
        // 先加左括号
        if (left < n){
            str.append("(");
            dfs(res,str,n,left+1,right);
            // 回溯 尝试走下面去加右括号
            str.deleteCharAt(str.length() - 1);
        }
        // 加右括号
        if (left > right){
            str.append(")");
            dfs(res,str,n,left,right+1);
            str.deleteCharAt(str.length() - 1);
        }
    }
}
