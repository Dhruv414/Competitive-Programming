import java.util.*;
import java.io.*;

public class Graphs {
    static boolean visited[];
    static class Node{
        int value;
        int ind;
        public Node(int n, int in){
            value = n;
            ind = in;
        }
    }
    public static void main(String[] args){
        visited = new boolean[10];
    }
}
