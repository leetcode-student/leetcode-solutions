package solutions;

import java.util.*;

public class Problem46_Permutations {
    public List<List<Integer>> permute(int[] nums) {
        return permute(nums, 0, nums.length - 1);
    }

    public List<List<Integer>> permute(int[] nums, int start, int end) {
        List<List<Integer>> permutations = new ArrayList<>();
        if (start == end) {
            List<Integer> permutation = new ArrayList<>();
            permutation.add(nums[start]);
            permutations.add(permutation);
            return permutations;
        }

        List<List<Integer>> subPermutations = permute(nums, start + 1, end);
        for (List<Integer> subPermutation : subPermutations) {
            for (int i = 0; i < subPermutation.size() + 1; i++) {
                List<Integer> mergedPermutation = new ArrayList<>();
                for (int left = 0; left < i; left++) {
                    mergedPermutation.add(subPermutation.get(left));
                }
                mergedPermutation.add(nums[start]);
                for (int right = i; right < subPermutation.size(); right++) {
                    mergedPermutation.add(subPermutation.get(right));
                }
                permutations.add(mergedPermutation);
            }
        }

        return permutations;
    }
}
