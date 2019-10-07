import java.util.*;
import java.io.*;

public class recycle {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        //PrintWriter pw = new PrintWriter("recycle.out");

        int t = sc.nextInt();
        for(int x = 0; x<t; x++){
            long n = sc.nextLong();
            long k = sc.nextLong();
            long count = 0;

            while(n/k != 0){
                long left = n%k;
                count += n/k;
                n/=k;
                n+=left;
            }
            System.out.println(count);
        }
    }
}
