import java.util.*;
import java.io.*;

public class route {

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("route.dat"));
        //Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] arr = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            int ans = 1;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int[][] visited = new int[n][m];
                    Queue<Node> q = new LinkedList<>();
                    int max = 1;
                    q.add(new Node(i, j, 1));
                    while (!q.isEmpty()) {
                        Node p = q.poll();
                        if (p.dist <= visited[p.i][p.j]) continue;
                        visited[p.i][p.j] = p.dist;
                        max = Math.max(max, p.dist);
                        for (int k = 0; k < 4; k++) {
                            int ni = dx[k] + p.i;
                            int nj = dy[k] + p.j;
                            if (inRange(ni, nj, n, m) && arr[ni][nj] > arr[p.i][p.j]) {
                                q.add(new Node(ni, nj, p.dist + 1));
                            }
                        }
                    }
                    ans = Math.max(ans, max);
                }
            }
            System.out.println(ans);
        }
        sc.close();
    }

    public static boolean inRange(int i, int j, int n, int m) {
        return i >= 0 && j >= 0 && i < n && j < m;
    }

    static class Node {
        int i, j, dist;

        public Node(int a, int b, int c) {
            i = a;
            j = b;
            dist = c;
        }
    }

}