import java.awt.*;
import java.util.*;
import java.io.*;

public class Kitchen {

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("kitchen.dat"));
        //Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            sc.nextLine();
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                grid[i] = sc.nextLine().toCharArray();
            }
            int starti = -1;
            int startj = -1;
            ArrayList<Node> g = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == 'S') {
                        starti = i;
                        startj = j;
                    }
                    if (grid[i][j] == 'G') {
                        g.add(new Node(i, j));
                    }
                }
            }
            Queue<Node> q = new LinkedList<>();
            q.add(new Node(starti, startj));
            boolean[][] visited = new boolean[n][m];
            boolean good = false;
            while (!q.isEmpty()) {
                Node p = q.poll();
                if (!inRange(p.i, p.j, n, m)) continue;
                if (visited[p.i][p.j]) continue;
                boolean bad = false;
                for (Node i : g) {
                    if (dist(i.i, i.j, p.i, p.j) <= 2) {
                        bad = true;
                    }
                }
                if (bad) continue;
                visited[p.i][p.j] = true;
                if (grid[p.i][p.j] == 'O') {
                    good = true;
                    break;
                }
                for (int a = 0; a < 4; a++) {
                    int ni = p.i + dx[a];
                    int nj = p.j + dy[a];
                    if (inRange(ni, nj, n, m) && grid[ni][nj] != '#') {
                        q.add(new Node(ni, nj));
                    }
                }
            }
            if (good) System.out.println("Very good chef.");
            else System.out.println("Don't bother showing up.");
        }
        sc.close();
    }

    public static int dist(int i, int j, int a, int b) {
        return Math.max(Math.abs(i - a), Math.abs(j - b));
    }

    public static boolean inRange(int i, int j, int n, int m) {
        return i >= 0 && j >= 0 && i < n && j < m;
    }

    static class Node {
        int i, j;
        public Node(int a, int b) {
            i = a;
            j = b;
        }
    }

}