package 每日一题;

/**
 * leetcode: 3274
 */
public class A_检查棋盘方格颜色是否相同 {
    public static void main(String[] args) {
        A_检查棋盘方格颜色是否相同 code = new A_检查棋盘方格颜色是否相同();
        boolean res = code.checkTwoChessboards("a1", "c3");
        System.out.println(res);
    }


    public boolean checkTwoChessboards(String coordinate1, String coordinate2) {
        char[] ch1 = coordinate1.toCharArray();
        char[] ch2 = coordinate2.toCharArray();
        // 奇数 + 奇数 = 偶数；奇数 + 偶数 = 奇数
        return ((ch1[0] - 'a' + 1) + (ch1[1] - '0' + 1)) % 2 == ((ch2[0] - 'a' + 1) + (ch2[1] - '0' + 1)) % 2;
    }
}
