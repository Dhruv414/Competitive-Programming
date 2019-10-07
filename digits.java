import java.util.*;
import java.io.*;

public class digits {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        //PrintWriter pw = new PrintWriter("digits.out");

        boolean[] prime = new boolean[100000];
        Arrays.fill(prime, true);
        prime[1] = false;
        for(int i = 2; i*i<prime.length; i++){
            if(prime[i]){
                for(int j = i*i; j<prime.length; j+=i){
                    prime[j] = false;
                }
            }
        }

        long a = sc.nextLong();
        long b = sc.nextLong();
        long k = sc.nextLong();
        a = a + (k - a % k);
        long count = 0;
        for(; a<=b; a+=k){
            //System.out.println(a);
            int sumDigits = 0;
            long num = a;
            long oriNum = num;
            while(num != 0){
                sumDigits += num%10;
                num /= 10;
            }
            if(prime[sumDigits]) {
                count++;
                //System.out.println(oriNum);
            }
        }
        System.out.println(count);


    }
}
