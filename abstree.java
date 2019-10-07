import java.util.*;
import java.io.*;

public class abstree {

    static class Node{
        int a;
        int k;
        int i;
        ArrayList<Integer> adj;

        public Node(int ai, int i){
            a = ai;
            this.i = i;
            adj = new ArrayList<>();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        //PrintWriter pw = new PrintWriter("abstree.out");

        int n = sc.nextInt();
        Node[] list = new Node[n+1];
        for(int i = 1; i <= n; i++){
            int a = sc.nextInt();
            list[i] = new Node(a, i);
        }

        for(int i = 1; i <= n; i++){
            list[i].k = sc.nextInt();
        }

        for(int i = 0; i<n-1; i++){
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            list[n1].adj.add(n2);
        }
    }
}
