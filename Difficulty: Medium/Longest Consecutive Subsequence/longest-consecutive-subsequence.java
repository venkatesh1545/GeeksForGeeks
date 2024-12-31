//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            // Read first array
            String input = br.readLine();
            String[] inputArray = input.split(" ");
            int[] arr = Arrays.stream(inputArray).mapToInt(Integer::parseInt).toArray();

            Solution ob = new Solution();
            int res = ob.longestConsecutive(arr);

            System.out.println(res);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {

    // Function to return length of longest subsequence of consecutive integers.
    public int longestConsecutive(int[] arr) {
        // code here
        if (arr == null || arr.length == 0) return 0;

        Arrays.sort(arr);
        int longest = 1; // To track the longest subsequence
        int currentStreak = 1; // To track the current streak
    
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) { // Ignore duplicates
                if (arr[i] == arr[i - 1] + 1) { // Consecutive
                    currentStreak++;
                } else { // Not consecutive
                    longest = Math.max(longest, currentStreak);
                    currentStreak = 1; // Reset the streak
                }
            }
        }
    
        return Math.max(longest, currentStreak); 
    }
}