package leetcode100.图;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 *
 *
 * 输入：numCourses = 2, prerequisites = [[1,0]]
 * 输出：true
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
 */
public class C_课程表 {
    public static void main(String[] args) {
        C_课程表 code = new C_课程表();
        boolean result = code.canFinish(3, new int[][]{{0,2},{1,2},{2,0}});
        System.out.println(result);
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 构建图的邻接表
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>()); // 初始化图
        }

        int[] indegree = new int[numCourses]; // 入度数组

        // 填充图和入度信息
        for (int[] pair : prerequisites) {
            int course = pair[0]; // 课程
            int preCourse = pair[1]; // 前置课程
            graph.get(preCourse).add(course); // preCourse -> course
            indegree[course]++; // 增加 course 的入度
        }

        // 队列用于 BFS
        Queue<Integer> queue = new LinkedList<>();

        // 将所有入度为 0 的课程加入队列（入度为0表示没有前置课程）
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        // 计数已完成的课程
        int count = 0;

        // BFS
        while (!queue.isEmpty()) {
            int course = queue.poll(); // 取出课程
            count++; // 记录已完成的课程

            // 减少相邻课程的入度
            for (int nextCourse : graph.get(course)) {
                indegree[nextCourse]--;
                if (indegree[nextCourse] == 0) {
                    queue.offer(nextCourse); // 如果入度变为 0，加入队列
                }
            }
        }

        // 判断是否完成所有课程
        return count == numCourses;
    }

}
