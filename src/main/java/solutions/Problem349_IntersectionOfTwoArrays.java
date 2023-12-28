package solutions;

import java.util.*;

public class Problem349_IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> nums1Cache = new HashMap<>();
        Set<Integer> intersection = new HashSet<>();

        for (int i = 0; i < nums1.length; i++) {
            nums1Cache.put(nums1[i], nums1Cache.getOrDefault(nums1[i], 0) + 1);
        }

        for (int i = 0; i < nums2.length; i++) {
            if (nums1Cache.containsKey(nums2[i]) && nums1Cache.get(nums2[i]) > 0) {
                intersection.add(nums2[i]);
                nums1Cache.put(nums2[i], nums1Cache.get(nums2[i]) - 1);
            }
        }

        int[] solution = new int[intersection.size()];
        List<Integer> intersectionList = new ArrayList<>(intersection);
        for (int i = 0; i < intersectionList.size(); i++) {
            solution[i] = intersectionList.get(i);
        }
        return solution;
    }
}
