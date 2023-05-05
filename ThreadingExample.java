package ThreadingExample;

public class ThreadingExample {

    private static final StringBuffer STRING_BUFFER = new StringBuffer();



    public static void main(String[] args) {
        newThread(new String[]{ "The", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog" });
        newThread(new String[]{ "I", "scream,", "you", "scream,", "we", "all", "scream", "for", "ice", "cream" });
    }



    private static void newThread(String[] wordArray) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    slowStringBuffer(wordArray);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }).start();
    }



    /**
     * A perfect example of needing to synchronize code is when a shared resource or object is
     * being used. Here we will use a shared StringBuffer object. Without synchronization the
     * words get added to the shared StringBuffer at the same time and are all mixed by the time we
     * print it out. If we simply synchronize this method then the sentences are built one at a
     * time.
     *
     * @param wordArray
     */
    private static void slowStringBuffer(String[] wordArray) throws InterruptedException {
        
        // reset the length
        STRING_BUFFER.setLength(0);

        // add each word to the string buffer.  we will use a small delay to simulate the need 
        // for synchronization
        for (String word : wordArray) {
            if (0 != STRING_BUFFER.length()) STRING_BUFFER.append(" ");
            STRING_BUFFER.append(word);

            Thread.sleep(10);
        }

        // finally we add a period and print out our sentence
        STRING_BUFFER.append(".");
        System.out.println(STRING_BUFFER.toString());
    }

}

