/*
->DFS탐색
*/

import java.io.*;
import java.util.*;

public class java14218 {
    static int n, m, T;
    static List<Integer>[] A;
    static int[] ans;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        A = new ArrayList[n + 1]; //ArrayList 배열 초기화
        visited = new boolean[n + 1]; //방문체크
        ans = new int[n + 1]; //정답배열
        for (int i = 1; i < n + 1; i++) {
            A[i] = new ArrayList<>();
        }
        for (int i = 2; i < n + 1; i++) {
            ans[i]=Integer.MAX_VALUE; //가장 큰값으로 초기화
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            A[s].add(e); //추가
            A[e].add(s); //축
        }

        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            A[s].add(e); //추가
            A[e].add(s); //추가

            for (int j = 2; j <= n; j++){
                DFS(1, j,0);
                for (int p = 1; p <= n; p++) {
                    visited[p] = false; //DFS후 초기화
                }
            }

            for (int j = 1; j <= n; j++) {
                System.out.print(ans[j]+" ");
            }
            System.out.println();
        }

    }

    static void DFS(int st, int en, int cnt) {
        if (st == en) {
            ans[en] = Math.min(cnt,ans[en]); // 목표노드 도달시 가장 작은 값으로 추가
            return;
        }
        if (visited[st]) { //이미 방문했던 노드 방문할시
            if (ans[en] == Integer.MAX_VALUE) { //목표노드를 방문하지 않았을시
                ans[en] = -1;  
            }
            return;
        }
        visited[st] = true; //방문체크
        for (int now : A[st]) {
            if (!visited[now]) { //dfs
                DFS(now, en, cnt + 1);
            }
        }

    }
}
