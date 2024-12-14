package katas.exercises;

public class TimeMe {

    /**
     * Measures the time it takes to execute a given function.
     *
     * @param func the function to measure
     * @return the execution time in milliseconds
     */
    public static long measureExecutionTime(Runnable func) {
        //hint:  System.currentTimeMillis();
        long startTime= System.currentTimeMillis();
        func.run();
        long endTime=System.currentTimeMillis();



        return endTime-startTime;
    }

    public static void main(String[] args) {
        Runnable sampleFunction = () -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        long timeTaken = measureExecutionTime(sampleFunction);
        System.out.println("Time taken by sampleFunction: " + timeTaken + " ms");

        Runnable quickFunction = () -> System.out.println("Quick task done!");
        timeTaken = measureExecutionTime(quickFunction);
        System.out.println("Time taken by quickFunction: " + timeTaken + " ms");
    }
}
