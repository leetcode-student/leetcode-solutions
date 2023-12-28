package solutions;

public class Problem33_SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        return search(nums, 0, nums.length - 1, target);
    }

    private int search(int[] nums, int start, int end, int target) {
        if (start > end) {
            return -1;
        }

        int mid = (start + end) / 2;
        //System.out.println(mid);

        if (nums[mid] == target) {
            return mid;
        } else if (target < nums[mid]) {
            if (nums[start] <= target || nums[start] > nums[mid]) {
                return search(nums, start, mid - 1, target);
            } else {
                return search(nums, mid + 1, end, target);
            }
        } else {
            if (target <= nums[end] || nums[end] < nums[mid]) {
                return search(nums, mid + 1, end, target);
            } else {
                return search(nums, start, mid - 1, target);
            }
        }
    }
}
