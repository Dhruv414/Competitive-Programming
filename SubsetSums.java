import java.util.*;
import java.io.*;

public class SubsetSums {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int x = 0; x<n; x++){
            arr[x] = sc.nextInt();
        }

        boolean[][] dp = new boolean[n][total+1];
        for(int x = 0; x<dp.length; x++){
            dp[x][0] = true;
        }

        for(int x = 0; x<dp.length; x++){
            for(int y = 0; y<dp[0].length; y++){
                if(x == 0){
                    if(arr[x] == y)
                        dp[x][y] = true;
                }
                else{
                    if(dp[x-1][y])
                        dp[x][y] = true;
                    else if(arr[x] > y)
                        dp[x][y] = dp[x-1][y];
                    else
                        dp[x][y] = dp[x-1][y-arr[x]];
                }
            }
        }
        System.out.println(dp[dp.length-1][dp[0].length-1]);
        for(boolean[] x : dp){
            for(boolean y : x){
                System.out.print(y + " ");
            }
            System.out.println();
        }


    }
}