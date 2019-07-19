import java.util.*;
import java.io.*;

public class Mathematics {
    public static void main(String[] args){
    }

    public static boolean isPrime(int n){
        if(n<=1)
            return false;
        if(n==2)
            return true;
        if(n%2==0)
            return true;
        for(int x = 3; x<=Math.sqrt(n); x+=2){
            if(n%x==0)
                return false;
        }
        return true;
    }

    public static boolean[] primeEras(int n){
        boolean[] prime = new boolean[n+1];
        Arrays.fill(prime,true); //assume every number is prime
        prime[0] = false;
        prime[1] = false;

        for(int x = 2; x<=n; x++){
            if(prime[x]){
                for(int k = x*x; k<=n; k+=x)
                    prime[k] = false; //assumes first occurance of factor is prime, then every fact after isnt a prime
            }
        }

        return prime;
    }

    public static int gcd(int n, int m){
        if(m == 0)
            return n;
        return gcd(m,n%m);
    }

    public static int lcm(int n, int m){
        return m*n/gcd(n,m);
    }

    public static int lcm(int[] nums){ //lcm of a whole array of nums
        int n = lcm(nums[0],nums[1]);
        for(int x = 1; x<nums.length; x++){
            n = lcm(n, nums[x]);
        }
        return n;
    }



}
