import java.util.*;
import java.io.*;

public class Main {

    static ArrayList<Integer> A[];
    static boolean[] visited;
    static boolean counted;


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        A = new ArrayList[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            A[s].add(e);
            A[e].add(s);
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                DFS(i,0);
                if (counted) {
                    break;
                }
            }
        }
        if (counted) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }

    }

    static void DFS(int n, int cnt) {
        if (cnt == 4) {
            counted = true;
            return;
        }
        if (visited[n]) {
            return;
        }
        visited[n] = true;
        for(int i :A[n]){
            if (!visited[i]) {
                DFS(i,cnt+1);
            }
        }
        visited[n] = false;
    }
}
