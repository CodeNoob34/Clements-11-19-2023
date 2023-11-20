import java.util.*;
import java.io.*;

public class dryrun {

    public static void main(String[] args) throws IOException {
        //Scanner sc = new Scanner(new File("dryrun.in"));
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
            boolean[] dp = new boolean[n];
            for (int i = 0; i < n; i++) {
                for (int j = n - 1; j >= 0; j--) {
                    if (dp[j] && j + arr[i] < n) dp[j + arr[i]] = true;
                }
            }
            if (dp[n - 1]) System.out.println("YES");
            else System.out.println("NO");
        }

        sc.close();
    }

}