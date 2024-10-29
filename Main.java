import java.time.Duration;
import java.time.Instant;

public class Main {
    public static void main(String[] args) {
        String text = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        
        String bestCase = "";

        // Initialize startTime here
        Instant startTime = Instant.now();
        int index = match(text, bestCase);
        // Initialize endTime here
        Instant endTime = Instant.now();
        // Calculate elapsedTime here
        Duration elapsedTimeBestCase = Duration.between(startTime, endTime);
        long elapsedTimeBestCaseNanos = elapsedTimeBestCase.toNanos();
        
        if (index >= 0) {
            System.out.println("best-case input matched at index " + index);
        } else {
            System.out.println("best-case input unmatched"); 
        }
        System.out.println("Best-case elapsed time: " + elapsedTimeBestCaseNanos + " nanoseconds");

        String worstCase = "987654321ZYXWVUTSRQPONMLKJIHGFEDCBA";

        // Initialize startTime here
        startTime = Instant.now();
        index = match(text, worstCase);
        // Initialize endTime here
        endTime = Instant.now();
        // Calculate elapsedTime here
        Duration elapsedTimeWorstCase = Duration.between(startTime, endTime);
        long elapsedTimeWorstCaseNanos = elapsedTimeWorstCase.toNanos();
        
        if (index >= 0) {
            System.out.println("worst-case input matched at index " + index);
        } else {
            System.out.println("worst-case input unmatched"); 
        }
        System.out.println("Worst-case elapsed time: " + elapsedTimeWorstCaseNanos + " nanoseconds");
    }

    // Return the index of the first match. -1 otherwise.
    public static int match(String text, String pattern) {
        for (int i = 0; i < text.length() - pattern.length() + 1; i++) {
            if (isMatched(i, text, pattern))
                return i;
        }
        return -1;
    }
    
    // Test if pattern matches text starting at index i
    private static boolean isMatched(int i, String text, String pattern) {
        for (int k = 0; k < pattern.length(); k++) {
            if (pattern.charAt(k) != text.charAt(i + k)) {
                return false;
            }
        }
        return true;
    }
}
