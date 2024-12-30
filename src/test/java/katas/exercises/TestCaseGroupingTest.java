package katas.exercises;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class TestCaseGroupingTest {

    @Test
    public void testGroupTestCases() {
        // Test Case 1
        List<Integer> testCaseGroupSizes1 = List.of(1, 2, 3, 3, 3, 2);
        List<List<Integer>> expected1 = List.of(
                List.of(0),  // group of size 1
                List.of(1, 5),  // group of size 2
                List.of(2, 3, 4)  // group of size 3
        );
        List<List<Integer>> result1 = TestCaseGrouping.groupTestCases(testCaseGroupSizes1);
        assertEquals(expected1, result1);

        // Test Case 2: Empty List
        List<Integer> testCaseGroupSizes2 =List.of();
        List<List<Integer>> expected2 = List.of(List.of());  // Expecting an empty result
        List<List<Integer>> result2 = TestCaseGrouping.groupTestCases(testCaseGroupSizes2);

        assertEquals(expected2, result2);

        // Test Case 3: Single Element
        List<Integer> testCaseGroupSizes3 = List.of(1);
        List<List<Integer>> expected3 = List.of(List.of(0));  // Only one element, so it's its own group
        List<List<Integer>> result3 = TestCaseGrouping.groupTestCases(testCaseGroupSizes3);

        assertEquals(expected3, result3);

        // Test Case 4: All Same Group Sizes
        List<Integer> testCaseGroupSizes4 = List.of(2, 2, 2, 2);
        List<List<Integer>> expected4 = List.of(
                List.of(0, 1,2,3)

        );
        List<List<Integer>> result4 = TestCaseGrouping.groupTestCases(testCaseGroupSizes4);

        assertEquals(expected4, result4);

        // Test Case 5: Decreasing Group Sizes
        List<Integer> testCaseGroupSizes5 = List.of(3, 2, 2, 1);
        List<List<Integer>> expected5 = List.of(
                List.of(3),  // group of size 1
                List.of(1, 2),  // group of size 2
                List.of(0)  // group of size 3
        );
        List<List<Integer>> result5 = TestCaseGrouping.groupTestCases(testCaseGroupSizes5);

        assertEquals(expected5, result5);

        // Test Case 6: Mixed Sizes
        List<Integer> testCaseGroupSizes6 = List.of(2, 3, 1, 2, 3, 1, 1);
        List<List<Integer>> expected6 = List.of(
                List.of(2,5,6),
                List.of(0,3),
                List.of(1,4)

        );
        List<List<Integer>> result6 = TestCaseGrouping.groupTestCases(testCaseGroupSizes6);

        assertEquals(expected6, result6);
    }
}
