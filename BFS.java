import java.util.*;
import java.io.*;
//Using BFS to find the shortest length in a graph with edge weights of
//only 1 or 0
public class BFS {
    static class Node{
        int i;
        int dist;
        public Node(int i) {
            this.i = i;
            dist = Integer.MAX_VALUE;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //BufferedReader br = new BufferedReader(new FileWriter("BFS.in");
        //StringTokenizer st = new StringTokenizer(br.readLine());
        //PrintWriter pw = new PrintWriter("BFS.out");

        int nodes = sc.nextInt(); //number of nodes
        int edges = sc.nextInt(); //mumber of edges
        Node[] list = new Node[nodes];
        int[][] adj = new int[nodes][nodes];
        for(int x = 0; x<nodes; x++){
            list[x] = new Node(x);
        }

        for(int x = 0; x<edges; x++){
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            adj[n1][n2] = 1;
            adj[n2][n1] = 1; //This means the graph is bidirectional, not always the case
        }

        boolean[] visited = new boolean[nodes];
        Node source = list[0];
        source.dist = 0;
        Queue<Node> q = new LinkedList<Node>();
        q.add(source);
        while(!q.isEmpty()){
            Node p = q.poll();
            visited[p.i] = true;
            for(int x = 0; x<nodes; x++){
                if(adj[p.i][x] == 1 && !visited[x]){
                    q.add(list[x]);
                    list[x].dist = Math.min(list[x].dist, p.dist + adj[p.i][x]);
                }
            }
        }

        for(Node n : list){
            System.out.print(n.dist + " ");
        }

    }
}
