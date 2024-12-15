package katas.exercises;



public class WordCounter {

    /**
     * Counts the number of words in a given sentence.
     *
     * @param sentence the input string (a sentence)
     * @return the number of words in the sentence
     */
    public static int countWords(String sentence)  {
        int i,counternumbers=0,counterWords=0;
         String[] words;
        if(sentence==null || sentence.length()==0)
        {
            return 0;
        }
        words=sentence.split("\\s+");
        counterWords=words.length;

        return counterWords;





    }

    public static void main(String[] args) {
        String sentence = "This is a sample sentence for counting words.";
        int wordCount = countWords(sentence);
        System.out.println(wordCount);
    }
}

