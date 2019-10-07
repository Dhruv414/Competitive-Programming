
import java.util.*;
import java.io.*;

public class DistCharSeqTwo {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //PrintWriter pw = new PrintWriter("DistCharSeqTwo.out");

        String s = st.nextToken();
        StringBuilder sb = new StringBuilder(s);
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        ArrayList<TreeSet<Integer>> set = new ArrayList<TreeSet<Integer>>();
        for(int x = 0; x<26; x++){
            set.add(new TreeSet<Integer>());
        }
        for(int x = 0; x<s.length(); x++){
            char add = sb.charAt(x);
            set.get(add-97).add(x);
        }
        for(int x = 0 ; x<n; x++){
            st = new StringTokenizer(br.readLine());
            int q = Integer.parseInt(st.nextToken());
            if(q == 1){
                int index = Integer.parseInt(st.nextToken());
                char toAdd = st.nextToken().charAt(0);
                char originalChar = sb.charAt(index-1);
                sb.setCharAt(index-1, toAdd);
                //System.out.println(originalChar + " " + set.get(originalChar-97) + " " + originalChar + " new char " + toAdd + " " + (index-1));
                set.get(originalChar-97).remove(new Integer(index-1));
                //System.out.println(originalChar + " " + set.get(originalChar-97));
                set.get(toAdd-97).add(index-1);
                //System.out.println(toAdd + " " + set.get(toAdd-97));
            }
            if(q == 2){
                int i = Integer.parseInt(st.nextToken());
                int j = Integer.parseInt(st.nextToken());
                int count = 0;
                for(int tset = 0; tset < 26; tset++){
                    if(set.get(tset).ceiling(i-1) != null && set.get(tset).ceiling(i-1) <= j-1){
                        count++;
                    }
                }
                System.out.println(count);
            }
        }

    }
}
