import java.util.*;
import java.io.*;

public class TwoDRangeSum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //BufferedReader br = new BufferedReader(new FileWriter("TwoDRangeSum.in");
        //StringTokenizer st = new StringTokenizer(br.readLine());
        //PrintWriter pw = new PrintWriter("TwoDRangeSum.out");

        int n = sc.nextInt(); //For an n*n grid with n*n numbers within the grid, be able to output the answer to range queries of (x1, y1) to (x2, y2)
        int q = sc.nextInt();

        int[][] grid = new int[n][n];

        for(int x = 0; x<n; x++){
            for(int y = 0; y<n; y++){
                grid[x][y] = sc.nextInt();
            }
        }

        int[][] sums = new int[n][n]; //will precompute the sums of a grid from the corner to a pt x2, y2 on the grid

        sums[0][0] = grid[0][0];
        for(int y = 1; y<n; y++){ //precompute the sums of the first row
            sums[0][y] = sums[0][y-1] + grid[0][y];
        }

        for(int x = 1; x<n; x++){
            sums[x][0] = sums[x-1][0] + grid[x][0];
        }

        for(int x = 1; x<n; x++){ //precomputes the rest of the grid
            for(int y = 1; y<n; y++){
                sums[x][y] = sums[x-1][y] + sums[x][y-1] + grid[x][y] - sums[x-1][y-1];
            }
        }
        for(int x = 0; x<n; x++){
            System.out.println(Arrays.toString(sums[x]));
        }
        for(int i = 0; i<q; q++){
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt(); //will not work if input has a 0 in it, just check for this case

            int topLeftX = Math.min(x1, x2);
            int topRightX = Math.max(x1, x2);
            int topRightY = Math.min(y1, y2);
            int topLeftY = topRightY;

            int botLeftX = topLeftX;
            int botRightX = topRightX;
            int botLeftY = Math.max(y1, y2);
            int botRightY = Math.max(y1, y2);

            System.out.println(x1 + " " + y1 + " " + x2 + " " + y2);
            int sum = 0;
            /*if() {
                if (x1 == 0)
                    sum = sums[botRightX][botRightY] - sums[botLeftX - 1][botLeftY] - sums[topRightX][topRightY - 1] + sums[topLeftX - 1][topLeftY - 1];
            }*/
            sum = sums[botRightX][botRightY] - sums[botLeftX - 1][botLeftY] - sums[topRightX][topRightY - 1] + sums[topLeftX - 1][topLeftY - 1];

            System.out.println(sum);
        }



    }
}
