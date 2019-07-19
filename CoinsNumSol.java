import java.util.*;
import java.io.*;

public class CoinsNumSol {
    static final int m = 1000000007;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int n = sc.nextInt();
        int[] coins = new int[n];
        for(int x = 0; x<n; x++){
            coins[x] = sc.nextInt();
        }
        System.out.println(Arrays.toString(coins));

        int[] dp = new int[t+1];
        dp[0] = 1; //1 way to make 0
        for(int x = 1; x<t+1; x++){
            for(int y : coins){
                if(x - y >=0){
                    dp[x] += dp[x-y];
                    //dp[x]%= m;
                }
            }
            System.out.println(Arrays.toString(dp));
        }

        System.out.println(dp[t]);




    }
}