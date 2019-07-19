import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class TestDate {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int y1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();
        int y2 = sc.nextInt();

        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();

        c1.set(y1,m1-1,d1);
        c2.set(y2,m2-1,d2);

        Date da = c1.getTime();
        Date db = c2.getTime();

        System.out.println((db.getTime() - da.getTime())/(1000*60*60*24));
        System.out.println(db);

    }
}
