import java.util.*;
import java.io.*;

public class LCS {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String s1 = sc.nextLine();

        char[] top = s.toCharArray();
        char[] side = s1.toCharArray();

        int[][]dp = new int[side.length+1][top.length+1];

        for(int x = 1; x<dp.length; x++){
            for(int y = 1; y<dp[0].length; y++){
                if(top[y-1] == side[x-1]){
                    dp[x][y] = dp[x-1][y-1] + 1;
                }
                else
                    dp[x][y] = Math.max(dp[x-1][y],dp[x][y-1]);
            }
        }

        int r = dp.length-1;
        int c = dp[0].length-1;
        StringBuilder lcs = new StringBuilder("");
        while(c != 0 && r != 0){
            if(dp[r-1][c] == dp[r][c]){
                r--;
            }
            else if(dp[r][c-1] == dp[r][c]){
                c--;
            }
            else{
                lcs.append(top[c-1]);
                r--;
                c--;
            }
        }
        lcs = lcs.reverse(); //from line 26-41 is finding the string that is the lcs

        for(int[] ar : dp){
            for(int a : ar){
                System.out.print(a + " ");
            }
            System.out.println();
        }
        System.out.println(lcs.toString());
    }
}
