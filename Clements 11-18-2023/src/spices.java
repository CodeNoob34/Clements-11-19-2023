import java.util.*;
import java.io.*;

public class spices {

    static HashMap<String, Integer> hash;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("spices.dat"));
        //Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        hash = new HashMap<>();
        hash.put("White", 1);
        hash.put("Red", 2);
        hash.put("Brown", 3);
        hash.put("Orange", 4);
        hash.put("Blue", 5);
        sc.nextLine();
        ArrayList<Spice> arr = new ArrayList<>();
        for (int i = 0; i < t; i++) {
            String s = sc.nextLine();
            Scanner sc2 = new Scanner(s);
            arr.add(new Spice(sc2.next(), Integer.parseInt(sc2.next()), Integer.parseInt(sc2.next()), sc2.next()));
        }
        Collections.sort(arr);
        for (int i = 0; i < t; i++) {
            System.out.println(arr.get(i).name);
        }
        sc.close();
    }

    static class Spice implements Comparable<Spice> {

        String name;
        int amt, use;
        String color;

        public Spice(String a, int b, int c, String d) {
            name = a;
            amt = b;
            use = c;
            color = d;
        }

        public int compareTo(Spice s) {
            if (use != s.use)
                return s.use - use;
            if (hash.getOrDefault(s.color, 6) != hash.getOrDefault(color, 6)) {
                return hash.getOrDefault(color, 6) - hash.getOrDefault(s.color, 6);
            }
            if (amt == s.amt) {
                return s.amt - amt;
            }
            return name.compareTo(s.name);
        }

    }

}