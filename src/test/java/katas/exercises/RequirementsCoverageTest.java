package katas.exercises;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class RequirementsCoverageTest {
    @Test
    public void testSelectMinimalTestCases() {
        // Test Case 1: Basic test case, multiple test cases, and minimal subset required
        List<List<Integer>> testCases1 = Arrays.asList(
                Arrays.asList(1, 2, 3),   // Test case 0 covers requirements 1, 2, 3
                Arrays.asList(1, 4),      // Test case 1 covers requirements 1, 4
                Arrays.asList(2, 3, 4),   // Test case 2 covers requirements 2, 3, 4
                Arrays.asList(1, 5),      // Test case 3 covers requirements 1, 5
                Arrays.asList(3, 5)       // Test case 4 covers requirements 3, 5
        );

        List<Integer> expected1 = Arrays.asList(2, 3); // This should cover all requirements
        List<Integer> result1 = RequirementsCoverage.selectMinimalTestCases(testCases1);
        assertEquals(expected1, result1);

        // Test Case 2: Only one test case covers all requirements
        List<List<Integer>> testCases2 = Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 5)
        );

        List<Integer> expected2 = Arrays.asList(0); // Only the first test case covers everything
        List<Integer> result2 = RequirementsCoverage.selectMinimalTestCases(testCases2);
        assertEquals(expected2, result2);



        // Test Case 4: Edge case with empty test cases
        List<List<Integer>> testCases4 = new ArrayList<>();

        List<Integer> expected4 = new ArrayList<>(); // No test cases
        List<Integer> result4 =RequirementsCoverage.selectMinimalTestCases(testCases4);
        assertEquals(expected4, result4);

        // Test Case 5: Test case where a requirement is covered by multiple test cases
        List<List<Integer>> testCases5 = Arrays.asList(
                Arrays.asList(1, 2), // Test case 0 covers requirements 1, 2
                Arrays.asList(2, 3), // Test case 1 covers requirements 2, 3
                Arrays.asList(1, 3)  // Test case 2 covers requirements 1, 3
        );

        List<Integer> expected5 = Arrays.asList(0, 1); // Test cases 0 and 1 cover all requirements
        List<Integer> result5 = RequirementsCoverage.selectMinimalTestCases(testCases5);
        assertEquals(expected5, result5);

        // Test Case 6: All test cases are subsets of each other
        List<List<Integer>> testCases6 = Arrays.asList(
                Arrays.asList(1, 2), // Test case 0 covers requirements 1, 2
                Arrays.asList(1),    // Test case 1 covers requirement 1
                Arrays.asList(2)     // Test case 2 covers requirement 2
        );

        List<Integer> expected6 = Arrays.asList(0); // The first test case covers everything
        List<Integer> result6 = RequirementsCoverage.selectMinimalTestCases(testCases6);
        assertEquals(expected6, result6);

        // Test Case 7: Large input
        List<List<Integer>> testCases7 = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            List<Integer> testCase = new ArrayList<>();
            for (int j = 1; j <= i; j++) {
                testCase.add(j);
            }
            testCases7.add(testCase);
        }

        // Test Case 7 expects a minimal set of test cases to cover requirements 1-20
        List<Integer> expected7 = Arrays.asList(19); // The last test case covers all the requirements
        List<Integer> result7 = RequirementsCoverage.selectMinimalTestCases(testCases7);
        assertEquals(expected7, result7);
    }
}
