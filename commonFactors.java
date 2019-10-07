import java.util.*;
import java.io.*;

public class commonFactors {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        //PrintWriter pw = new PrintWriter("commonFactors.out");

        long a = sc.nextLong();
        long b = sc.nextLong();

        long gcf = gcf(a , b);
        long ans = 1;
        while(gcf%2 == 0){
            gcf/=2;
            ans++;
        }
        for(long i = 3; i<=gcf; i++){
            if(isPrime(i)){
                int count = 0;
                while(gcf % i == 0){
                    gcf/=i;
                    count++;
                }
                ans*=(count+1);
            }
        }
        System.out.println(ans);
    }

    public static long gcf(long a, long b){
        if(b == 0)
            return a;
        return gcf(b, a % b);
    }

    public static boolean isPrime(long l){
        if(l == 1)
            return false;
        if (l == 2)
            return true;
        for(int i = 3; i<=Math.sqrt(l); i++){
            if(l%i == 0)
                return false;
        }
        return true;
    }
}
