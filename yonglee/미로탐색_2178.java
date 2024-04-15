/*
-> BFS : 한 좌표에서 모든 방향으로의 횟수를 계산해야 하기 때문에 DFS보다 BFS가 옳다
0,0에서 부터 m,n까지 깊이를 계산하여 A[n-1][m-1]의 값을 출력하였다.
*/

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class Main {

    static int[][] A;
    static boolean[][] visited;
    static int[] dr = {1, 0, -1, 0}; //상하좌우
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

        System.out.println(A[n - 1][m - 1]); // m-1,n-1의 좌표 출력
    }

    static void BFS(int x, int y) {

        Queue<int[]> queue = new LinkedList<>(); //queue사용

        queue.offer(new int[] {x,y}); //queue에 0,0 푸시

        while (!queue.isEmpty()) {
            int[] now = queue.poll(); //queue 팝

            for (int i = 0; i < 4; i++) {
                int dx = now[0] + dr[i]; //상하좌우 좌표
                int dy = now[1] + dc[i];

                if (dx >= 0 && dx < m && dy >= 0 && dy < n) {
                    if (!visited[dy][dx] && A[dy][dx] != 0) { //방문하지 않고 A[dy][dx]가 0이 아닐 시
                        visited[dy][dx] = true; //방문체크
                        A[dy][dx] = A[now[1]][now[0]]+1;//깊이+1
                        queue.offer(new int[] {dx,dy});//푸시
                        }
                    }
                }
            if (now[0] == m - 1 && now[1] == n - 1) { //m-1,n-1에 도달 시 리턴
                return;
            }
        }
    }



}
