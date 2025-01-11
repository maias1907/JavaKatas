package katas.exercises;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QueueWithFailoverTest {

    private QueueWithFailover queue;

    @BeforeEach
    public void setUp() {
        // Initialize the queue with a timeout of 3 seconds (for testing purposes)
        queue = new QueueWithFailover(3);
    }

    @Test
    public void testSendJob() {
        queue.sendJob("Job 1");
        queue.sendJob("Job 2");
        queue.sendJob("Job 3");

        // The queue should contain 3 jobs
        assertEquals(3, queue.size(), "The queue size should be 3 after adding 3 jobs");
    }

    @Test
    public void testGetJob() {
        queue.sendJob("Job 1");

        String job = queue.getJob();

        // The job should be the one at the front of the queue (Job 1)
        assertEquals("Job 1", job, "The job retrieved should be 'Job 1'");
    }

    @Test
    public void testJobDone() {
        queue.sendJob("Job 1");
        String job = queue.getJob();

        // Mark the job as done
        queue.jobDone(job);

        // The hidden jobs map should no longer contain the job
        assertTrue(queue.inFlightSize() == 0, "The hidden jobs should be empty after job is done");
    }

    @Test
    public void testJobTimeout() throws InterruptedException {
        queue.sendJob("Job 1");

        String job = queue.getJob();

        // Simulate job timeout by sleeping longer than jobTimeout
        Thread.sleep(4000); // Wait for 4 seconds to exceed the timeout of 3 seconds

        // Return expired jobs to the queue
        queue.returnExpiredJobsToQueue();

        // The job should be returned to the queue
        assertEquals(1, queue.size(), "The expired job should be returned to the queue");
    }

    @Test
    public void testJobNotFoundAfterTimeout() throws InterruptedException {
        queue.sendJob("Job 1");

        String job = queue.getJob();

        // Simulate job timeout
        Thread.sleep(4000); // Wait for 4 seconds to exceed the timeout

        // Return expired jobs to the queue
        queue.returnExpiredJobsToQueue();

        // Try to complete the expired job
        try {
            queue.jobDone(job);
            fail("Should have thrown an IllegalArgumentException for expired job");
        } catch (IllegalArgumentException e) {
            assertEquals("j" +
                    "ob is not found in the hidden jobs", e.getMessage(), "Exception message should indicate job was not found");
        }
    }

    @Test
    public void testQueueIsEmpty() {
        assertTrue(queue.isEmpty(), "The queue should be empty initially");

        queue.sendJob("Job 1");

        assertFalse(queue.isEmpty(), "The queue should not be empty after adding a job");
    }

    @Test
    public void testQueueSizeLimit() {
        // Send jobs to the queue
        queue.sendJob("Job 1");
        queue.sendJob("Job 2");
        queue.sendJob("Job 3");

        // Try sending a fourth job (which should fail as the queue size limit is reached)
        queue.sendJob("Job 4");

        // The queue size should still be 3, as the fourth job should not have been added
        assertEquals(3, queue.size(), "The queue size should be 3 after trying to add a fourth job");
    }
}
