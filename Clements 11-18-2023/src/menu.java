import java.util.*;
import java.io.*;

public class menu {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("menu.dat"));
        //Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- >0) {
            int W = sc.nextInt();
            int H = sc.nextInt();
            sc.nextLine();
            String[] arr = sc.nextLine().split(" ");
            for (int i = 0; i < W; i++) System.out.print("-");
            System.out.println();
            int j = 0;
            for (int i = 0; i < H - 2 && j < arr.length; i++ ){
                String line = arr[j];
                j++;
                while (j < arr.length && line.length() + arr[j].length() + 1 <= W - 2) {
                    line += " " + arr[j];
                    j++;
                }
                int space = W - 2 - line.length();
                System.out.println("|" + line + " ".repeat(space) + "|");
            }
            for (int i = 0; i < W; i++) System.out.print("-");
            System.out.println();
        }
        sc.close();
    }

}