package leetcode100.回溯;

import java.util.ArrayList;
import java.util.List;

/**分割回文串
 *
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文串。返回 s 所有可能的分割方案。
 *
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 */
public class G_分割回文串 {
    public static void main(String[] args) {
        G_分割回文串 code = new G_分割回文串();
        List<List<String>> res = code.partition("aab");
        System.out.println(res);
    }

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        dfs(res,s,new ArrayList<>(),0);
        return res;
    }

    void dfs(List<List<String>> res,String s,List<String> path,int startIndex){
        if (startIndex >= s.length()){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < s.length(); i++){
            // 1、处理节点
            // 判断 [startIndex,i] 这个区间里的字符串是否为回文串
            String sub = s.substring(startIndex, i + 1);
            if (isPalindrome(sub)){
                path.add(sub);
            }else continue;
            // 2、递归
            dfs(res,s,path,i+1);
            // 3、回溯
            path.remove(path.size() - 1);
        }
    }

    // 是否是回文串
    boolean isPalindrome(String str){
        for (int i = 0,j = str.length() - 1; i < j; i++,j-- ){
            if (str.charAt(i) != str.charAt(j)){
                return false;
            }
        }
        return true;
    }
}
