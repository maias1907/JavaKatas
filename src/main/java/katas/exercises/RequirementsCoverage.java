package katas.exercises;

import java.util.*;

public class RequirementsCoverage {

    /**
     * In software testing, it's often required to select a minimal set of test cases that cover all the requirements.
     * You are given a set of test cases and their associated covered requirements.
     * Your task is to select the minimal subset of test cases such that all requirements are covered.
     * <p>
     * For example, you have the following test cases and requirements they cover:
     * <p>
     * testCases = [
     * [1, 2, 3],   // Test case 0 covers requirements 1, 2, 3
     * [1, 4],      // Test case 1 covers requirements 1, 4
     * [2, 3, 4],   // Test case 2 covers requirements 2, 3, 4
     * [1, 5],      // Test case 3 covers requirements 1, 5
     * [3, 5]       // Test case 4 covers requirements 3, 5
     * ]
     *
     * @param testCases a list of test cases, where each test case is a list of requirements it covers
     * @return a list of indices of the minimal subset of test cases that covers all requirements
     */
    public static List<Integer> selectMinimalTestCases(List<List<Integer>> testCases){
        // Collect all unique requirements
        Set<Integer> allRequirements = new HashSet<>();
        for (List<Integer> testCase : testCases) {
            allRequirements.addAll(testCase);
        }

        // To track the remaining uncovered requirements
        Set<Integer> uncoveredRequirements = new HashSet<>(allRequirements);
        // To store indices of selected test cases
        List<Integer> selectedTests = new ArrayList<>();

        // Create a map for easier lookup of test cases
        Map<Integer, Set<Integer>> testCaseMap = new HashMap<>();
        for (int i = 0; i < testCases.size(); i++) {
            testCaseMap.put(i, new HashSet<>(testCases.get(i)));
        }

        // Greedy selection of test cases
        while (!uncoveredRequirements.isEmpty()) {
            int bestTestCase = -1;
            int maxCoverage = 0;

            // Find the test case that covers the most uncovered requirements
            for (Map.Entry<Integer, Set<Integer>> entry : testCaseMap.entrySet()) {
                int testCaseIndex = entry.getKey();
                Set<Integer> requirements = entry.getValue();

                // Calculate the intersection of uncovered requirements
                Set<Integer> uncovered = new HashSet<>(requirements);
                uncovered.retainAll(uncoveredRequirements);

                if (uncovered.size() > maxCoverage) {
                    maxCoverage = uncovered.size();
                    bestTestCase = testCaseIndex;
                }
            }

            // Add the best test case to the result
            if (bestTestCase != -1) {
                selectedTests.add(bestTestCase);
                uncoveredRequirements.removeAll(testCaseMap.get(bestTestCase));
                testCaseMap.remove(bestTestCase); // Remove from consideration
            } else {
                throw new IllegalStateException("Not all requirements can be covered with the provided test cases.");
            }
        }

        return selectedTests;

    }


    public static void main(String[] args) {
        List<List<Integer>> testCases = List.of(
                List.of(1, 2, 3),
                List.of(1, 4),
                List.of(2, 3, 4),
                List.of(1, 5),
                List.of(3, 5)
        );

        List<Integer> result = selectMinimalTestCases(testCases);
        System.out.println(result); // Expected output: [2, 3]
    }
}

