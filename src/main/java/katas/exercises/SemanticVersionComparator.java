package katas.exercises;

public class SemanticVersionComparator {

    /**
     * Compares two semantic version strings to determine their relative order.
     *
     * @param version1 the first version string (e.g., "MAJOR.MINOR.PATCH")
     * @param version2 the second version string (e.g., "MAJOR.MINOR.PATCH")
     * @return -1 if version1 < version2, 1 if version1 > version2, 0 if they are equal
     */
    public static int compareVersions(String version1, String version2) {

            String[] parts1 = version1.split("\\.");
            String[] parts2 = version2.split("\\.");

            int maxLength = Math.max(parts1.length, parts2.length);

            for (int i = 0; i < maxLength; i++) {
                int num1 = i < parts1.length ? Integer.parseInt(parts1[i]) : 0;
                int num2 = i < parts2.length ? Integer.parseInt(parts2[i]) : 0;

                if (num1 > num2) {
                    return 1; // version1 is greater
                } else if (num1 < num2) {
                    return -1; // version2 is greater
                }
            }

            return 0; // Both versions are equal
        }


    public static void main(String[] args) {
        System.out.println(compareVersions("1.0.0", "1.0.1")); // Expected: -1
        System.out.println(compareVersions("2.1.0", "1.9.9")); // Expected: 1
        System.out.println(compareVersions("1.2.3", "1.2.3")); // Expected: 0
    }
}
