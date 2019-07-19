import java.util.*;
import java.io.*;

public class Permutations {
    static TreeSet<String> perm = new TreeSet<String>();
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        perms(s, 0);
        System.out.println(perm);

    }

    public static void perms(String s, int ind){
        perm.add(s);
        for(int x = ind; x<s.length(); x++){
                char[] xd = s.toCharArray();
                char a = xd[ind];
                char b = xd[x];
                xd[x] = a;
                xd[ind] = b;
                perms(new String(xd), ind+1);
        }
    }
}