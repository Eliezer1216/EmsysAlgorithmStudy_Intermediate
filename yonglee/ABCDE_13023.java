/*
-> DFS문제, 특정 깊이에 도달하면 정답
*/

import java.util.*;
import java.io.*;

public class Main {

    static ArrayList<Integer> A[];
    static boolean[] visited; //도착했는지
    static boolean counted; //정답인지


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
            if (!visited[i]) {//여기까지 똑같은 DFS
                DFS(i,0);  //깊이를 통해 정답을 추론해야 하기때문에 깊이 매개변수 추가
                if (counted) { //만약 counted가 충족한다면 break
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
        if (cnt == 4) { //깊이에 도달한다면 return
            counted = true;
            return;
        }
        if (visited[n]) {
            return;
        }
        visited[n] = true; //방문했는지 체크
        for(int i :A[n]){
            if (!visited[i]) {
                DFS(i,cnt+1);
            }
        }
        visited[n] = false;// 방문한 곳 다시 되돌리기
    }
}
