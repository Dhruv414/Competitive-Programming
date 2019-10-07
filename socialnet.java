import java.util.*;
import java.io.*;

public class socialnet {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        //PrintWriter pw = new PrintWriter("socialnet.out");

        LinkedList<Integer> list = new LinkedList<Integer>();
        HashSet<Integer> container = new HashSet<Integer>();
        int n = sc.nextInt();
        int k = sc.nextInt();

        for(int x = 0; x<n; x++){
            int convo = sc.nextInt();
            //System.out.println(list);
            //System.out.println(container);
            //System.out.println();
            if(container.contains(convo)){
                continue;
            }
            else{
                if(list.size() < k){
                    list.addLast(convo);
                    container.add(convo);
                }
                else{
                    int removed = list.getFirst();
                    list.removeFirst();
                    container.remove((Integer)removed);
                    list.addLast(convo);
                    container.add(convo);
                }
            }
        }
        Collections.reverse(list);
        System.out.println(list.size());
        for(int l : list){
            System.out.print(l + " ");
        }
        //System.out.println();
    }
}
