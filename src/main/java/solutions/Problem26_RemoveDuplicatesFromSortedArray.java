package solutions;

public class Problem26_RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int writePtr = 0;

        for (int readPtr = 0; readPtr < nums.length; readPtr++) {
            if (readPtr == 0 || nums[readPtr] != nums[readPtr - 1]) {
                nums[writePtr] = nums[readPtr];
                writePtr++;
            }
        }

        return writePtr;
    }
}
