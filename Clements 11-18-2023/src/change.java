import java.util.*;
import java.io.*;

public class change {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("change.dat"));
        //Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0){
            int n = sc.nextInt();
            int x = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
            boolean[] dp = new boolean[x + 1];
            dp[0] = true;
            for (int i = 0; i < n; i++) {
                for (int j = x; j >= 0; j--) {
                    if (dp[j] && j + arr[i] <= x) dp[j + arr[i]] = true;
                }
            }
            if (dp[x]) System.out.println("Very good chef.");
            else System.out.println("Idiot sandwich.");
        }

        sc.close();
    }

}