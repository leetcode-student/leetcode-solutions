package solutions;

import java.util.*;

public class Problem56_Merge_Intervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new IntervalComparator());

        List<int[]> mergedIntervals = new ArrayList<>();
        mergedIntervals.add(new int[] {intervals[0][0], intervals[0][1]});

        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= end) {
                if (intervals[i][1] > end) {
                    mergedIntervals.get(mergedIntervals.size() - 1)[1] = intervals[i][1];
                    end = intervals[i][1];
                }
            } else {
                mergedIntervals.add(new int[] {intervals[i][0], intervals[i][1]});
                end = intervals[i][1];
            }
        }

        int[][] solution = new int[mergedIntervals.size()][2];
        for (int i = 0; i < mergedIntervals.size(); i++) {
            solution[i][0] = mergedIntervals.get(i)[0];
            solution[i][1] = mergedIntervals.get(i)[1];
        }

        return solution;
    }

    private static class IntervalComparator implements Comparator<int[]> {
        public int compare(int[] a, int[] b) {
            return a[0] - b[0];
        }
    }
}
