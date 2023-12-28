package solutions;

public class Problem34_FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        return searchRange(nums, target, 0, nums.length - 1);
    }

    private int[] searchRange(int[] nums, int target, int left, int right) {
        if (left < 0 || right >= nums.length || left > right) {
            return new int[] {-1, -1};
        }

        int mid = (left + right) / 2;

        int[] leftSearch = new int[] {-1, -1};
        int[] rightSearch = new int[] {-1, -1};

        if (nums[mid] >= target) {
            leftSearch = searchRange(nums, target, left, mid - 1);
        }

        if (nums[mid] <= target) {
            rightSearch = searchRange(nums, target, mid + 1, right);
        }

        int leftBoundary = -1;
        if (nums[mid] == target) {
            leftBoundary = mid;
        }
        if (leftBoundary == -1 || (leftSearch[0] != -1 && leftSearch[0] < leftBoundary)) {
            leftBoundary = leftSearch[0];
        }
        if (leftBoundary == -1 || (rightSearch[0] != -1 && rightSearch[0] < leftBoundary)) {
            leftBoundary = rightSearch[0];
        }

        int rightBoundary = -1;
        if (nums[mid] == target) {
            rightBoundary = mid;
        }
        if (rightBoundary == -1 || (leftSearch[1] != -1 && leftSearch[1] > rightBoundary)) {
            rightBoundary = leftSearch[1];
        }
        if (rightBoundary == -1 || (rightSearch[1] != -1 && rightSearch[1] > rightBoundary)) {
            rightBoundary = rightSearch[1];
        }

        //System.out.println("mid=" + mid);
        //System.out.println("left_right=" + left + "_" + right);
        //System.out.println("-> " + leftBoundary + "_" + rightBoundary);

        return new int[] {leftBoundary, rightBoundary};
    }
}
