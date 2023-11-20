import java.sql.Array;
import java.util.*;
import java.io.*;

public class gift {

    static boolean good = false;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("gift.dat"));
        //Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            good = false;
            HashMap<String, ArrayList<String>> hash = new HashMap<>();
            for (int i = 0; i < n; i++) {
                String a = sc.next();
                String b = sc.next();
                if (!hash.containsKey(a)) hash.put(a, new ArrayList<>());
                if (!hash.containsKey(b)) hash.put(b, new ArrayList<>());
                hash.get(a).add(b);
                hash.get(b).add(a);
            }
            HashMap<String, Boolean> visited = new HashMap<>();
            dfs(hash, "You", visited);
            if (good) {
                System.out.println("Happy Gifting.");
            }
            else {
                System.out.println("Not So Secret Santa.");
            }
        }
        sc.close();
    }

    public static void dfs(HashMap<String, ArrayList<String>> hash, String cur, HashMap<String, Boolean> visited) {
        if (visited.getOrDefault(cur, false)) return;
        visited.put(cur, true);
        if (cur.equals("Ramsey")) {
            good = true;
            return;
        }
        if (!hash.containsKey(cur)) return;
        for (String x : hash.get(cur)) {
            dfs(hash, x, visited);
        }
    }

}