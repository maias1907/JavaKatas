package ArraysAndStringsTest;

import ArraysAndStrings.TwoSum;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TwoSumTest {

    @Test
    void testTwoSumBasic() {
        TwoSum ts = new TwoSum();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = ts.twoSum(nums, target);
        assertEquals(target, nums[result[0]] + nums[result[1]]);
    }

    @Test
    void testTwoSumNegativeNumbers() {
        TwoSum ts = new TwoSum();
        int[] nums = {-3, 4, 3, 90};
        int target = 0;
        int[] result = ts.twoSum(nums, target);
        assertEquals(target, nums[result[0]] + nums[result[1]]);
    }



    @Test
    void testTwoSumUnorderedInput() {
        TwoSum ts = new TwoSum();
        int[] nums = {1, 4, 5, 6, 2};
        int target = 7;
        int[] result = ts.twoSum(nums, target);
        assertEquals(target, nums[result[0]] + nums[result[1]]);
    }

    @Test
    void testTwoSumNoSolutionReturnsDefault() {
        TwoSum ts = new TwoSum();
        int[] nums = {1, 2, 3};
        int target = 100;
        int[] result = ts.twoSum(nums, target);
        assertArrayEquals(new int[]{-1, -1}, result);
    }
}
