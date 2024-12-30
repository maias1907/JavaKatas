package katas.exercises;

import java.util.*;

public class RequirementsCoverage {

    /**
     * Selects the minimal set of test cases that cover all requirements.
     *
     * @param testCases a list of test cases, where each test case is a list of requirements it covers
     * @return a list of indices of the minimal subset of test cases that covers all requirements, or an empty list if not possible
     */
    public static List<Integer> selectMinimalTestCases(List<List<Integer>> testCases) {
        int n = testCases.size();
        Set<Integer> allRequirements = new HashSet<>();

        // Step 1: Identify all requirements
        for (List<Integer> testCase : testCases) {
            allRequirements.addAll(testCase);
        }

        // Step 2: Check if all requirements can be covered
        Set<Integer> combinedRequirements = new HashSet<>();
        for (List<Integer> testCase : testCases) {
            combinedRequirements.addAll(testCase);
        }
        if (!combinedRequirements.containsAll(allRequirements)) {
            return new ArrayList<>(); // No subset can cover all requirements
        }

        // Step 3: Generate all possible subsets using bit masking
        int minSize = Integer.MAX_VALUE;
        List<Integer> bestSubset = new ArrayList<>();

        for (int mask = 1; mask < (1 << n); mask++) {
            Set<Integer> coveredRequirements = new HashSet<>();
            List<Integer> currentSubset = new ArrayList<>();

            // Add test cases to the current subset based on the bit mask
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    currentSubset.add(i);
                    coveredRequirements.addAll(testCases.get(i));
                }
            }

            // Step 4: Check if the current subset covers all requirements
            if (coveredRequirements.containsAll(allRequirements) && currentSubset.size() < minSize) {
                minSize = currentSubset.size();
                bestSubset = new ArrayList<>(currentSubset);
            }
        }

        return bestSubset;
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
