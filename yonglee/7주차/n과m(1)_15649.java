/*
-> 백트래킹, 순열
*/

import java.util.*;
import java.io.*;

public class java15649 {
    static int n, m;
    static boolean[] visited;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        n = sc.nextInt();
        m = sc.nextInt();

        visited = new boolean[n+1];
        arr = new int[m];

        DFS(0);

    }

    static void DFS(int cnt) {
        if (cnt == m) {
            for (int i = 0; i < cnt; i++) {
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= n; i++) { //1->n까지 순서대로 보니까 순열
            if (!visited[i]) { //방문했을 시 다시 안봄
                visited[i] = true;
                arr[cnt] = i;
                DFS(cnt + 1);
                visited[i] = false;
            }
        }
    }

}
