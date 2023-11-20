import java.util.*;
import java.io.*;

public class chef {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("chef.dat"));
        //Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        while (T-- > 0) {
            int N = sc.nextInt();
            ArrayList<String> bad = new ArrayList<>();
            boolean ok = true;
            for (int i = 0; i < N; i++) {
                String name = sc.next();
                String val = sc.next();
                if (name.equals("Asparagus") || name.equals("Broccoli")) {
                    if (!val.equals("Green") && name.equals("Asparagus")) {
                        bad.add("Asparagus");
                        ok = false;
                    }
                    if (!val.equals("Green") && name.equals("Broccoli")) {
                        bad.add("Broccoli");
                        ok = false;
                    }
                } else if (name.equals("Potatoes")) {
                    if (!val.equals("Golden-Brown")) {
                        ok = false;
                        bad.add("Potatoes");
                    }
                } else if (name.equals("Carrots")) {
                    if (!val.equals("Light-Orange")) {
                        bad.add("Carrots");
                        ok = false;
                    }
                } else {
                    int n = Integer.parseInt(val);
                    if (name.equals("Steak") && (n < 165 || n > 175)) {
                        bad.add("Steak");
                        ok = false;
                    }
                    if (name.equals("Roast-Chicken") && (n < 165 || n > 180)) {
                        bad.add("Roast-Chicken");
                        ok = false;
                    }
                    if (name.equals("Pork-Chops") && (n < 150 || n > 165)) {
                        bad.add("Pork-Chops");
                        ok = false;
                    }
                }

            }
            if (!ok) {
                System.out.println("You're Fired.");
                for (int i = 0; i < bad.size(); i++) {
                    System.out.print(bad.get(i));
                    if (i != bad.size() - 1) System.out.print(",");
                }
            } else {
                System.out.print("Very Good Chef.");
            }
            System.out.println();

        }
        sc.close();
    }

}