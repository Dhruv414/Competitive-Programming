import java.util.*;
import java.io.*;

public class LongestCommonSubstring {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String s1 = sc.nextLine();
        int[][] dp = new int[s.length()+1][s1.length()+1];
        for(int x = 1; x<s.length(); x++){
            for(int y = 1; y<s1.length(); y++){
                if(s.charAt(x) == s1.charAt(y))
                    dp[x][y] = dp[x-1][y-1] + 1;
                else
                    dp[x][y] = 0;
            }
        }

        for(int[] x : dp){
            for(int y : x){
                System.out.print(y + " ");
            }
            System.out.println();

        }
    }
}
