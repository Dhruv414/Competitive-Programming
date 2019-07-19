import java.util.*;
import java.io.*;

public class LongestIncSubseq {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in); //pointer at j up to i, check if # at pointer < i b/c then that makes # at i adds to that subsequence
        int n = sc.nextInt();
        int[] num = new int[n];
        for(int x = 0; x<n; x++){
            num[x] = sc.nextInt();
        }

        int[] dp = new int[n];
        int max = -1;
        for(int x = 1; x<n; x++){
            dp[x] = 1; // because the max subsequence not counting anything (for a single element) is 1
            for(int y = 0; y<x; y++){
                if(num[x] > num[y]) { // means adds to the subseq
                    dp[x] = Math.max(dp[x], dp[y] + 1); // subseq at y + 1 (because you're adding to that subseq)
                    max = Math.max(dp[x],max);
                }

            }
        }

        System.out.println(max);

    }
}