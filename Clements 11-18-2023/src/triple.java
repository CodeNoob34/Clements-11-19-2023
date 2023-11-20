import java.util.*;
import java.io.*;

public class triple {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("triple.dat"));
        //Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int count = 0;
            int count2 = 0;
            for (int i = 1; i < n; i++) {
                for (int j = i + 1; i + j < n; j++) {
                    int k = i * i + j * j;
                    k = (int) Math.sqrt(k);
                    if (i + j + k > n) break;
                    if (i * i + j * j == k * k) {
                        if (gcd(i, j) == 1 && gcd(j, k) == 1 && gcd(i, k) == 1) count++;
                        else count2++;
                    }

                }
            }
            System.out.println(count2 + count + " triple(s), " + count + " primitive(s)");
        }
        sc.close();
    }

    public static int gcd(int a, int b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }

}