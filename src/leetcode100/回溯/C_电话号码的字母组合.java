package leetcode100.回溯;

import java.util.ArrayList;
import java.util.List;

/** 电话号码的字母组合
 *
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 */
public class C_电话号码的字母组合 {

    public static void main(String[] args) {
        List<String> result = letterCombinations("23");
        System.out.println(result);
    }

    public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.isEmpty()) return res;
        String[] arrMap = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        backtracking(res,arrMap,digits,new StringBuffer(),0);
        return res;
    }

    static void backtracking(List<String> res, String[] arrMap, String digits, StringBuffer sub, int index){
        if(digits.length() == sub.length()){
            res.add(sub.toString());
            return;
        }
        int at = digits.charAt(index) - '0';
        char[] ch = arrMap[at].toCharArray();
        for(int i = 0;i < ch.length ; i++){
            sub.append(ch[i]);
            backtracking(res,arrMap,digits,sub,index+1);
            sub.deleteCharAt(sub.length() - 1);
        }
    }

}
