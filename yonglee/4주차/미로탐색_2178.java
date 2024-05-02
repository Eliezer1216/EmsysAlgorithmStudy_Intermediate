import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class Main {

    static int[][] A;
    static boolean[][] visited;
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int m, n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        A = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split("");
            A[i] = Stream.of(split).mapToInt(Integer::parseInt).toArray();
        }

        BFS(0,0);

        System.out.println(A[n - 1][m - 1]);
    }

    static void BFS(int x, int y) {

        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[] {x,y});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int dx = now[0] + dr[i];
                int dy = now[1] + dc[i];

                if (dx >= 0 && dx < m && dy >= 0 && dy < n) {
                    if (!visited[dy][dx] && A[dy][dx] != 0) {
                        visited[dy][dx] = true;
                        A[dy][dx] = A[now[1]][now[0]]+1;
                        queue.offer(new int[] {dx,dy});
                        }
                    }
                }
            if (now[0] == m - 1 && now[1] == n - 1) {
                return;
            }
            }
        }



}
