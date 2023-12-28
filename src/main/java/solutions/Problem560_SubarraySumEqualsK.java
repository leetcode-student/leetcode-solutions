package solutions;

public class Problem560_SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int diff = sum[j] - sum[i] + nums[i];
                //System.out.println("i=" + i + ", j=" + j + ", diff=" + diff);
                if (diff == k) {
                    count++;
                }
            }
        }

        return count;
    }
}
