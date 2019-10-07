import java.util.*;
import java.io.*;

public class Pipes {
    static int[] row1;
    static int[] row2;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //PrintWriter pw = new PrintWriter("Pipes.out");

        int q = Integer.parseInt(st.nextToken());

        for(int x = 0; x<q; x++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            String row1String = st.nextToken();
            st = new StringTokenizer(br.readLine());
            String row2String = st.nextToken();
            row1 = new int[n];
            row2 = new int[n];
            visited = new boolean[2][n];

            for(int i = 0; i<n; i++){
                row1[i] = Integer.parseInt(String.valueOf(row1String.charAt(i)));
                row2[i] = Integer.parseInt(String.valueOf(row2String.charAt(i)));
            }
            boolean ans = possible(0, 0);
            //System.out.println("TESTING WITH" + row1String);
            if(ans)
                System.out.println("YES");
            else{
                System.out.println("NO");
            }
            /*for(boolean[] k : visited){
                for(boolean b : k){
                    System.out.print(b + " ");
                }
                System.out.println();
            }*/
        }
    }

    public static boolean possible(int i, int j){
        //System.out.println(i + " " + j);
        visited[i][j] = true;
        if(i == 1 && j == row1.length-1){
            if(row2[j] == 1 || row2[j] == 2) {
                if (visited[1][j - 1])
                    return true;
                return false;
            }
            else{
                if(visited[0][j]){
                    return true;
                }
                return false;
            }
        }
        if(i == 0 && j == row1.length - 1){
            if(row1[j] == 1 || row1[j] == 2){
                return false;
            }
            if(!opposite(row1[j], row2[j]))
                return true;
            return false;
        }
        /*if(j == row1.length - 2){
            if(i == 0)
                if(!(row1[j] == 1 || row1[j] == 2)){
                    if(!opposite(row1[j], row2[j]) && !opposite(row1[j], row2[j+1]))
                        return false;
                }
            if(i == 1){
                if(row2[j] == 1 || row2[j] == 2){
                    if(opposite(row2[j], row2[j+1]))
                        return false;
                }
            }
        }*/
        if(i == 0){
            if(row1[j] == 1 || row1[j] == 2){
                return possible(i, j+1);
            }
            if(opposite(row1[j], row2[j])){
                return false;
            }
            visited[1][j] = true;
            return possible(1, j+1);
        }
        else{
            if(row2[j] == 1 || row2[j] == 2){
                return possible(i, j+1);
            }
            if(opposite(row1[j], row2[j])){
                return false;
            }
            visited[0][j] = true;
            return possible(0, j+1);
        }
    }

    /*public static boolean possible(int i, int j){
        System.out.println(i + " " + j);
        if(j < 0)
            return false;
        if(i == 0 && j == 0){
            return true;
        }
        if(i == 1 && j == 0){
            if(row2[j] == 3 || row2[j] == 4 || row2[j] == 5 || row2[j] == 6) {
                if (opposite(row1[j], row2[j]))
                    return false;
                return true;
            }
            else{
                return false;
            }
        }
        if(i == 0){ //If on the first row
            if(row1[j] == 1 || row1[j] == 2){
                return possible(i, j-1);
            }
            else{
                if(opposite(row1[j], row2[j])){
                    return false;
                }
                return possible(1, j-1);
            }
        }
        if(i == 1){
            if(row2[j] == 1 || row2[j] == 2){
                return possible(i, j-1);
            }
            else{
                if(opposite(row1[j], row2[j])){
                    return false;
                }
                return possible(0, j-1);
            }
        }
        return false;
    }*/

    public static boolean opposite(int i, int j){
        if(i == 3 || i == 4 || i == 5 || i== 6){
            if(j == 1 || j == 2){
                return true;
            }
        }
        else if(i == 1 || i == 2){
            if(j == 3 || j == 4 || j == 5 || j == 6)
                return true;
        }
        return false;
    }


}
