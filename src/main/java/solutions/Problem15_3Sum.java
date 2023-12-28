package solutions;

import java.util.*;

public class Problem15_3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> threeSums = new ArrayList<>();

        int i = 0;
        while (i < nums.length) {
            int j = i + 1;
            int k = nums.length - 1;
            int iValue = nums[i];
            while (j < k) {
                int jValue = nums[j];
                int kValue = nums[k];

                int sum = iValue + jValue + kValue;
                if (sum == 0) {
                    List<Integer> threeSum = new ArrayList<>(Arrays.asList(iValue, jValue, kValue));
                    threeSums.add(threeSum);
                }

                if (sum <= 0) {
                    while (j < nums.length && nums[j] == jValue) {
                        j++;
                    }
                } else {
                    while (k >= 0 && nums[k] == kValue) {
                        k--;
                    }
                }
            }
            while (i < nums.length && nums[i] == iValue) {
                i++;
            }
        }

        return threeSums;
    }
}
