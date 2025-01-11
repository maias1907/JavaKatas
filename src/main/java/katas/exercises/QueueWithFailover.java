package katas.exercises;

import java.util.*;

public class QueueWithFailover {
    /**
     * A job queue data structure with failover support.
     *
     * A job queue is a messaging system used to manage the flow of work between components or applications.
     * In this system, jobs (or messages) are sent to the queue by PRODUCERS and retrieved by CONSUMERS for processing.
     *
     * When a job is consumed by a consumer, they have `jobTimeout` seconds to finish the job.
     * The job is not permanently deleted from the queue; instead, it is temporarily hidden.
     * If the consumer completes processing the job within the allocated time, they mark the job as done (jobDone()),
     * and the job should be permanently deleted.
     * Otherwise, if they fail to process the job and the job processing times out, the job should be returned
     * to the end of the queue (by the returnExpiredJobsToQueue()), allowing it to be consumed again.
     */

    private int jobTimeout;
    private Queue<String> jobs;
    private Map<String, Long> hiddenJobs;

    public QueueWithFailover(int jobTimeout) {
        /**
         * Initialize an empty job queue.
         */
        this.jobTimeout = jobTimeout;
        this.jobs = new LinkedList<>();
        this.hiddenJobs = new HashMap<>();
    }

    public boolean isEmpty() {
        /**V
         * Check if the job queue is empty.
         *
         * @return boolean: True if the job queue is empty, False otherwise.
         */
       if(this.jobs.size()==0)
       {
           return true;
       }
       return false;
    }

    public void sendJob(String job) {
        /**V
         * Send a job to the job queue.
         *
         * @param job The job to be added to the queue.
         */
        if(this.jobs.size()<this.jobTimeout)
        {
            this.jobs.add(job);
        }
        else{
            System.out.println("the Queue is full");
        }


    }

    public String getJob() throws EmptyQueueException {
        /**V
         * Retrieve and return a job from the front of the job queue.
         *
         * @return String: The job at the front of the queue.
         * @throws EmptyQueueException: If the job queue is empty.
         */
        if(isEmpty()){
            throw new EmptyQueueException("there is no jobs");
        }
       else{
           String frontJob=this.jobs.poll();
            this.hiddenJobs.put(frontJob,System.currentTimeMillis());
            return frontJob;
        }

    }

    public void jobDone(String job) {
        /**
         * This function is called when a consumer completes a consumed job.
         * The job should be deleted permanently (from the hidden).
         *
         * @param job The job to be deleted permanently from the queue.
         * @throws IllegalArgumentException: If the job is not found in the hidden jobs.
         */
        if (this.hiddenJobs.containsKey(job)) {
            hiddenJobs.remove(job);
        } else {
            throw new IllegalArgumentException("job is not found in the hidden jobs");
        }
    }

    public int size() {
        /**V
         * Return the number of jobs in the job queue.
         *
         * @return int: The number of jobs in the queue.
         */
        return this.jobs.size();
    }

    public int inFlightSize() {
        /**V
         * Return the number of hidden jobs.
         *
         * @return int: The number of hidden jobs in the queue.
         */
       return this.hiddenJobs.size();
    }

    public void returnExpiredJobsToQueue() {
        /**V
         *
         * Return hidden jobs that were retrieved more than `jobTimeout` seconds ago back to the job queue.
         */
       long  currentTime=System.currentTimeMillis();
        List<String> expiredJobs=new ArrayList<>();
        for (Map.Entry<String, Long> entry : hiddenJobs.entrySet()) {
            long jobStartTime = entry.getValue();
            if (currentTime - jobStartTime > jobTimeout * 1000) {
                expiredJobs.add(entry.getKey());
            }
        }
        for(String job:expiredJobs)
        {
            hiddenJobs.remove(job);
            this.sendJob(job);
        }
    }

    public static void main(String[] args) {
        QueueWithFailover jobQueue = new QueueWithFailover(3);

        jobQueue.sendJob("Job 1");
        jobQueue.sendJob("Job 2");
        jobQueue.sendJob("Job 3");

        System.out.println("Job Queue Size: " + jobQueue.size());

        String currentJob = jobQueue.getJob();
        jobQueue.jobDone(currentJob);

        currentJob = jobQueue.getJob();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        jobQueue.returnExpiredJobsToQueue();

        try {
            jobQueue.jobDone(currentJob);
        } catch (IllegalArgumentException e) {
            System.out.println("Job not found as it was expired and returned to the main queue");
        }
    }

    static class EmptyQueueException extends RuntimeException {
        public EmptyQueueException(String message) {
            super(message);
        }
    }
}
