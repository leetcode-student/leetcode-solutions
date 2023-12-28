package solutions;

public class Problem162_FindPeakElement {
    public int findPeakElement(int[] nums) {
        return findPeakElement(nums, 0, nums.length - 1);
    }

    private int findPeakElement(int[] nums, int start, int end) {
        int mid = (start + end) / 2;
        //System.out.println(mid);

        if (nums.length == 1) {
            return mid;
        } else if (mid == 0) {
            if (nums[mid] > nums[mid + 1]) {
                return mid;
            } else {
                return findPeakElement(nums, mid + 1, end);
            }
        } else if (mid == nums.length - 1) {
            if (nums[mid] > nums[mid - 1]) {
                return mid;
            } else {
                return findPeakElement(nums, start, mid - 1);
            }
        } else {
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (nums[mid] > nums[mid - 1]) {
                return findPeakElement(nums, mid + 1, end);
            } else {
                return findPeakElement(nums, start, mid - 1);
            }
        }
    }
}
