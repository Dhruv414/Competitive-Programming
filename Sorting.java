import java.util.*;
import java.io.*;

public class Sorting {
    public static void main(String[] args){
        int[] num = {4,2,6,1,2,7,9};
        System.out.println(Arrays.toString(num));
        bubbleSort(num);
        System.out.println(Arrays.toString(num));
    }

    public static void bubbleSort(int[] num){
        for(int x = 0; x<num.length; x++){
            for(int y = 0; y<num.length-1; y++){
                if(num[y] > num[y+1]){ // if the next number is not greater than the previous(like its supposed to be, increasing order)
                    //then swap them so that it is! smart moove
                    int temp = num[y];
                    num[y] = num[y+1];
                    num[y+1] = temp;
                    System.out.println(Arrays.toString(num));
                }
            }
        }
    }
}
