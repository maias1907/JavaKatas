package katas.exercises;

public class TrueCounter {

    /**
     * Counts the number of true values in the given boolean array.
     *
     * @param array the boolean array to check
     * @return the count of true values in the array
     */
    public static int countTrueValues(boolean[] array) {
        int trueCounter=0,i;
        if(array==null||array.length==0)
        {
            return 0;
        }
        for(i=0;i<array.length;i++)
        {
            if(array[i])
            {
                trueCounter++;
            }
        }


        return trueCounter;
    }

    public static void main(String[] args) {
        boolean[] sampleArray = {true, false, true, true, false};
        int trueCount = countTrueValues(sampleArray);
        System.out.println(trueCount);
    }
}
