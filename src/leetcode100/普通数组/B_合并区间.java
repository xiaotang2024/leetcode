package leetcode100.普通数组;

import java.util.*;

/**
 *以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 *
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 */
public class B_合并区间 {

    public static void main(String[] args) {
        B_合并区间 code = new B_合并区间();
        int[][] res = code.merge(new int[][]{{1,3},{2,6},{8,10},{15,18}});
        System.out.println(Arrays.deepToString(res));
    }

    /**
     *
     * 思路：将列表中的区间按照左端点升序排序。然后我们将第一个区间加入 merged 数组中，并按顺序依次考虑之后的每个区间：
     *    1、如果当前区间的左端点在数组 merged 中最后一个区间的右端点之后，那么它们不会重合，我们可以直接将这个区间加入数组 merged 的末尾；
     *    2、否则，它们重合，我们需要用当前区间的右端点更新数组 merged 中最后一个区间的右端点，将其置为二者的较大值。
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        // 根据左区间排序，从小到大排序
        Arrays.sort(intervals, (interval1, interval2) -> interval1[0] - interval2[0]);
        List<int[]> merged = new ArrayList<>();
        merged.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int L = intervals[i][0], R = intervals[i][1];
            if (merged.get(merged.size() - 1)[1] < L){
                // 区间无需合并，添加到结果集
                merged.add(new int[]{L,R});
            }else {
                // 这种就是需要合并的情况了，处理右区间，左区间不需要处理，因为已经排序过了。
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1],intervals[i][1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
