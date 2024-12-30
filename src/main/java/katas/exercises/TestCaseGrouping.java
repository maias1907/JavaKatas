package katas.exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class TestCaseGrouping {

    /**
     * In software testing, a traceability matrix is used to map requirements to test cases, ensuring that all requirements are covered by corresponding test cases.
     *
     * You are given a list of group SIZES of each test case. For example:
     *
     * testCaseGroupSizes = [1, 2, 3, 3, 3, 2]
     *
     * - Test case num 0 belongs to a group of 1 test cases
     * - Test case num 1 belongs to a group of 2 test cases
     * - Test case num 2 belongs to a group of 3 test cases
     * - Test case num 3 belongs to a group of 3 test cases
     * - etc...
     *
     * Your task is to return a list of groups such that each test case i is in a group of size testCaseGroupSizes[i]:
     *
     * testCasesGroups = [[0], [1, 5], [2, 3, 4]]
     *
     * @param testCaseGroupSizes a list of integers, where each integer represents the size of the group for the corresponding test case
     * @return a list of groups, where each group contains the indices of test cases covering the same set of requirements
     */
    public static List<List<Integer>> groupTestCases(List<Integer> testCaseGroupSizes) {
        // Step 1: Create a list of indices
        List<List<Integer>> result = new ArrayList<>();
        Integer[] indices = new Integer[testCaseGroupSizes.size()];
        for (int i = 0; i < testCaseGroupSizes.size(); i++) {
            indices[i] = i; // Store the position (index) of each number
        }

        // Step 2: Sort the indices based on the group sizes
        Arrays.sort(indices, Comparator.comparingInt(i -> testCaseGroupSizes.get(i)));


        // Step 3: Group the indices based on sizes
        List<Integer> group = new ArrayList<>();
        for (int i = 0; i < indices.length; i++) {
            ;// Add the current index to the group

            // Check if the group is complete
            if (i!=0&&testCaseGroupSizes.get(indices[i-1]) != testCaseGroupSizes.get(indices[i])) {
                result.add(new ArrayList<>(group));

// Add the group to the result
                group.clear(); // Clear the group for the next set
            }
            group.add(indices[i]);


        }
        result.add(new ArrayList<>(group));//last group


        return result;
    }

    public static void main(String[] args) {
        List<Integer> testCaseGroupSizes1 = List.of(1, 2, 3, 3, 3, 2);
        List<List<Integer>> testCaseGroups1 = groupTestCases(testCaseGroupSizes1);
        System.out.println(testCaseGroups1);
    }
}
