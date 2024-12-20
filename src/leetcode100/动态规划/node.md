动规五部曲
1. dp数组以及下际的含义
2. 递推公式
3. dp数组如何初始化
4. 遍历顺序
5. 打印dp数组

拿斐波那契来举例：1 1 2 3 5 8
1. 确认dp数组的含义

dp[i]表示第i个斐波那契数
2. 递推公式

dp[i] = dp[i - 1] + dp[i - 2]

3. dp数组初始化

dp[0] = 1; dp[1] = 1

4. 遍历顺序

从前向后

5. 打印dp数组验证正确性


```java
class Solution {
    public static int fib(int n) {
        if (n <= 1) return n;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int index = 2; index <= n; index++){
            dp[index] = dp[index - 1] + dp[index - 2];
        }
        // 第n个斐波那契数
        return dp[n - 1];
    }
}
```
