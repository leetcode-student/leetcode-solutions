package solutions;

public class Problem88_Merge_Sorted_Array {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int nums1Ptr = m - 1;
        int nums2Ptr = n - 1;

        for (int writePtr = m + n - 1; writePtr >= 0; writePtr--) {
            if (nums2Ptr < 0 || (nums1Ptr >= 0 && nums1[nums1Ptr] >= nums2[nums2Ptr])) {
                nums1[writePtr] = nums1[nums1Ptr];
                nums1Ptr--;
            } else {
                nums1[writePtr] = nums2[nums2Ptr];
                nums2Ptr--;
            }
        }
    }
}
