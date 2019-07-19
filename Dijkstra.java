import java.util.*;
import java.io.*;

public class Dijkstra {
    static int[] dists;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //# of nodes
        int c = sc.nextInt(); //Connections
        Node[] list = new Node[n];
        int[][] adj = new int[n][n];
        TreeMap<Character, Integer> xd = new TreeMap<Character, Integer>();
        for(int x = 0; x<n; x++){
            list[x] = new Node((char)(x+65), x);
            xd.put((char)(x+65), x);
        }
        for(int x = 0; x<c; x++){
            char a = sc.next().charAt(0);
            char b = sc.next().charAt(0);
            int ed = sc.nextInt();
            adj[xd.get(a)][xd.get(b)] = ed;
            adj[xd.get(b)][xd.get(a)] = ed;
        }

        PriorityQueue<Node> q = new PriorityQueue<>();
        Node start = list[0];
        start.dist = 0;
        boolean[] visited = new boolean[n];
        q.add(start);

        while(!q.isEmpty()){
            Node nk = q.poll();
            visited[nk.ind] = true;
            for(int x = 0; x<n; x++){
                if(!visited[x] && adj[nk.ind][x] > 0 ){
                    if(list[x].dist > nk.dist + adj[nk.ind][x])
                        list[x].prev = nk.a;
                    list[x].dist = Math.min(list[x].dist, nk.dist + adj[nk.ind][x]);
                    q.add(list[x]);
                }
            }
        }

        //System.out.println(list[1].prev);
        Node k = list[n-1];
        //System.out.println(list[n-1].prev);
        StringBuilder br = new StringBuilder("");
        while(k.dist != 0){
            br.append(k.a + " ");
            //System.out.println("key : " + xd.get(k.prev));
            k = list[xd.get(k.prev)];
        }
        br.append(list[0].a);
        System.out.println(br.reverse().toString().trim() + " " + list[n-1].dist);

        int sum = 0;
        for(Node l : list)
            System.out.println(l.ind+1 + " " + l.dist + " " + (sum+=l.dist*(l.ind+1)) + " ");
        System.out.println("\n"+sum);
        /*for(Node no : list){
            System.out.println(no.dist);
        }*/




    }

    static class Node implements Comparable<Node>{
        char a;
        int ind;
        int dist;
        ArrayList<Node> next;
        char prev;
        Node(char a, int ind){
            this.a = a;
            this.ind = ind;
            next = new ArrayList<Node>();
            dist = Integer.MAX_VALUE;
            prev = 'X';
        }


        public int compareTo(Node n){
            //System.out.println("heres the compare" + dists[this.ind] + " " + dists[n.ind]);
            return this.dist - n.dist;
        }
        public String toString(){
            return String.valueOf(this.a);
        }
    }
}