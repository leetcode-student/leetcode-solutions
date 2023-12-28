package solutions;

import java.util.*;

public class Problem78_Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        return subsets(nums, 0);
    }

    private List<List<Integer>> subsets(int[] nums, int start) {
        List<List<Integer>> subsets = new ArrayList<>();

        if (start == nums.length) {
            subsets.add(new ArrayList<>());
            return subsets;
        }

        List<List<Integer>> subSubsets = subsets(nums, start + 1);
        subsets.addAll(subSubsets);

        for (List<Integer> subSubset : subSubsets) {
            List<Integer> subsetWith = new ArrayList<>(subSubset);
            subsetWith.add(nums[start]);
            subsets.add(subsetWith);
        }

        return subsets;
    }
}
