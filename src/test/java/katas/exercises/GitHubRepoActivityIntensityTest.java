package katas.exercises;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.net.HttpURLConnection;
import java.time.Instant;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class GitHubRepoActivityIntensityTest {

    @Test
    void testCalculateAverageTimeBetweenCommits() throws Exception {
        List<Instant> mockTimestamps = List.of(
                Instant.parse("2023-12-01T12:00:00Z"),
                Instant.parse("2023-12-01T14:00:00Z"),
                Instant.parse("2023-12-01T18:00:00Z"),
                Instant.parse("2023-12-02T06:00:00Z")
        );

        double averageTime = GitHubRepoActivityIntensity.calculateAverageTimeBetweenCommits(mockTimestamps);
    }

    @Test
    void testFetchCommitTimestamps() throws Exception {
        HttpURLConnection mockConnection = mock(HttpURLConnection.class);
        URL url = new URL("https://api.github.com/repos/mockOwner/mockRepo/commits");

        when(mockConnection.getResponseCode()).thenReturn(200);

        // continue....
    }
}
