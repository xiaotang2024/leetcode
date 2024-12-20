package leetcode100.utils;

public class PrintUtils {

    // 打印方法结果和耗时的通用方法
    public static void printMethodResult(RunnableWithResult<?> runnable) {
        long startTime = System.nanoTime(); // 记录开始时间
        Object result = runnable.run(); // 执行方法
        long endTime = System.nanoTime(); // 记录结束时间

        long duration = endTime - startTime; // 计算耗时
        System.out.println("方法结果: " + result);
        System.out.println("耗时: " + duration / 1_000_000.0 + " 毫秒"); // 转换为毫秒并打印
    }

    // 定义一个函数式接口以便于传递计算方法
    @FunctionalInterface
    public interface RunnableWithResult<T> {
        T run();
    }

}
