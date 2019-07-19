import java.util.*;
import java.io.*;

public class Combinations {
    static TreeSet<String> combs = new TreeSet<String>();
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        comb("",0,s);
        System.out.println(combs);

    }

    public static void comb(String s, int ind, String or){
        if(ind == or.length()){
            combs.add(s);
            return;
        }
        else{
            comb(s+String.valueOf(or.charAt(ind)), ind+1, or);
            comb(s,ind+1,or);
        }
    }
}