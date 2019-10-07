import java.util.*;
import java.io.*;

public class ZAlg {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        //PrintWriter pw = new PrintWriter("ZAlg.out");
        String s = sc.nextLine();

        int[] zfunc = new int[s.length()];
        int n = s.length();
        int l = 0;
        int r = 0;

        for(int i = 1; i<n; i++){
            if(i <= r) { //if within a previously found prefix, we "calculated" part of it
                zfunc[i] = Math.min(r-i+1, zfunc[i-l]);
            }
            while(i + zfunc[i] < n && s.charAt(zfunc[i]) == s.charAt(i + zfunc[i]))
                ++zfunc[i];
            if(i + zfunc[i] - l > r){
                l = i;
                r = i+zfunc[i] - l;
            }
        }

        System.out.println(Arrays.toString(zfunc));
    }
}
