package katas.exercises;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Instant;

import java.util.List;


public class GitHubRepoActivityIntensity {
    /**
     * Analyze the activity level of a specific GitHub repository.
     *
     * Calculate the average time (in hours) between commits in a given GitHub repository.
     *
     * Use the GitHub API to:
     *
     *     - Fetch commit timestamps for a given repository (paginate to fetch ALL commits!!!)
     *     - Calculate the average time (in hours) between consecutive commits.
     *
     * Use the GitHub REST API to fetch commit data for a repository.
     * The API endpoint is: GET https://api.github.com/repos/{owner}/{repo}/commits
     *
     *
     * Note: the unittest for this kata is partially implemented under `GitHubRepoActivityIntensityTest`.
     */

    private static final String GITHUB_API_BASE_URL = "https://api.github.com/repos";

    /**
     * Fetches commit timestamps for the specified repository using the GitHub API.
     *
     * @param owner the owner of the repository
     * @param repo the name of the repository
     * @return a list of commit timestamps as Instant objects
     * @throws Exception if there is an error fetching or parsing the data
     */
    public static List<Instant> fetchCommitTimestamps(String owner, String repo) throws Exception {
        // example:
        URL url = new URL("...");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/vnd.github+json");
    }

    /**
     * Calculates the average time between consecutive commits.
     *
     * @param timestamps a list of commit timestamps
     * @return the average time in hours
     */
    public static double calculateAverageTimeBetweenCommits(List<Instant> timestamps) {

    }

    public static void main(String[] args) {
        try {
            List<Instant> timestamps = fetchCommitTimestamps("torvalds", "linux");
            double avgTime = calculateAverageTimeBetweenCommits(timestamps);

            System.out.printf("The average time between commits in the repository is %.2f hours.%n", avgTime);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}


