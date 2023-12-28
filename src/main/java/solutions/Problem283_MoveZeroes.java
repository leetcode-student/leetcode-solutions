package solutions;

public class Problem283_MoveZeroes {
    public void moveZeroes(int[] nums) {
        int numZeroes = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                numZeroes++;
            }
        }

        int writePtr = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[writePtr] = nums[i];
                writePtr++;
            }
        }

        for (int i = nums.length - numZeroes; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
