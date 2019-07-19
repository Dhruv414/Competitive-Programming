import java.util.*;
import java.io.*;

public class Knapsack {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //# of items
        int m = sc.nextInt(); //max weight
        TreeMap<Integer, Integer> items = new TreeMap<Integer, Integer>(); //map val to wt
        int[][] dp = new int[n][m+1];
        int[] list = new int[n];

        for(int x = 0; x<n; x++){
            int val = sc.nextInt(); //val of item
            int wt = sc.nextInt(); //wt of item
            items.put(val,wt);
            list[x] = val;
        }

        for(int r = 0; r<n; r++){
            for(int c = 0; c<m+1; c++){
                if(items.get(list[r]) <= c){
                    if(r != 0)
                        dp[r][c] = Math.max(list[r] + dp[r-1][c-items.get(list[r])], dp[r-1][c]);
                    else
                        dp[r][c] = list[r];
                }
                else{
                    if(r!=0)
                        dp[r][c] = dp[r-1][c];
                }
            }
        }

        int c = m;
        int r = n-1;
        //int max = 45;
        while(c > 0){ //finding out what goes into the sack
            //System.out.println("PT IS: " + r + " " + c);
            if(r == 0){
                if(dp[r][c] != dp[r][c-1]){
                    System.out.println(list[r]);
                    c-=items.get(list[r]);
                }
            }
            else {
                //System.out.println("xd" + r);
                if (dp[r][c] != dp[r - 1][c]) {
                    //System.out.println(list[r] + " " + r + " " + c);
                    System.out.print(list[r] + " ");
                    c -= items.get(list[r]); //order matters! cant do r-- first
                    r--;
                } else {
                    r--;
                }
            }
        }

        /*for(int[] x : dp){
            for(int y : x){
                System.out.print(y + " ");
            }
            System.out.println();
        }*/
        System.out.println(dp[n-1][m] + " ");
        //System.out.println(Arrays.toString(list));

    }
}