import java.util.*;
import java.io.*;

public class chocolates {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        //PrintWriter pw = new PrintWriter("chocolates.out");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int d1 = sc.nextInt();
        int d2 = sc.nextInt();

        System.out.println((a*d2/d1) + b);
    }
}
