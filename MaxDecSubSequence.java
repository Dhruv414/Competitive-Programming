import java.util.*;
import java.io.*;

public class MaxDecSubSequence {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("MaxDec.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] nums = new int[n];
        int[] ss = new int[n];
        Arrays.fill(ss,1); //Represents that longest subsequence of single number is 1

        for(int x = 0; x<n; x++){
            st = new StringTokenizer(br.readLine());
            nums[x] = Integer.parseInt(st.nextToken());
        }
        int max = Integer.MIN_VALUE;
        for(int x = 1; x<n; x++){ //Logic: Keeps a pointer from 1 -> end
            for(int y = 0; y<x; y++){ //moves pointer from 0 to x-1
                if(nums[x] < nums[y]){ //checks if this point is valid in the solution, then updates the largest ss at that pt
                    ss[x] = Math.max(ss[x],ss[y]+1);
                    max = Math.max(ss[x],max);
                }
            }
        }
        System.out.println(max);



    }
}
