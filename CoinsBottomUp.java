import java.util.*;
import java.io.*;

public class CoinsBottomUp {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int n = sc.nextInt();
        int[] coins = new int[n];
        for(int x = 0; x<n; x++){
            coins[x] = sc.nextInt();
        }

        int[] dp = new int[t+1];
        int[] first = new int[t+1];

        for(int x = 1; x<t+1; x++){ //total
            dp[x] = Integer.MAX_VALUE-1;
            for(int y : coins){
                if(x-y >= 0 && dp[x-y]+1 < dp[x]){ //if coin can be subtracted
                    dp[x] = dp[x-y] + 1;
                    first[x] = y;
                }
            }
        }
        ArrayList<Integer> sol = new ArrayList<Integer>();
        while(t > 0){
            sol.add(first[t]);
            t-=first[t]; //logic behind code is that first holds the coin that starts that min coin (the coin added), so subtract it and u get another coin
        }

        System.out.println(sol);

    }
}