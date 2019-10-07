import java.util.*;
import java.io.*;

public class TrainPassengers {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //BufferedReader br = new BufferedReader(new FileWriter("TrainPassengers.in");
        //StringTokenizer st = new StringTokenizer(br.readLine());
        //PrintWriter pw = new PrintWriter("TrainPassengers.out");

        int c = sc.nextInt();
        int n = sc.nextInt();

        int currCap = 0;
        boolean possible = true;
        loop: for(int x = 0; x<n; x++){
            int left = sc.nextInt();
            int enter = sc.nextInt();
            int wait = sc.nextInt();

            currCap -= left;
            if(currCap < 0) {
                possible = false;
                break loop;
            }
            currCap += enter;
            if(currCap > c){
                possible = false;
                break loop;
            }
            if(c - currCap > 0 && wait > 0){
                possible = false;
                break loop;
            }
        }

        if(currCap == 0 && possible)
            System.out.println("possible");
        else
            System.out.println("impossible");
    }
}
