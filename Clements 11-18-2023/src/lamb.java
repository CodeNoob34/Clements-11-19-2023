import java.util.*;
import java.io.*;

public class lamb {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("lamb.dat"));
        //Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String s = sc.nextLine();
            s = s.toLowerCase();
            s = s.replaceAll("[.?!, @#$%^&*()-_=+'\"]", "");
            if (s.contains("lamb")) System.out.println("Lamb location confirmed.");
            else System.out.println("Where's the lamb sauce?!?");
        }
        sc.close();
    }

}