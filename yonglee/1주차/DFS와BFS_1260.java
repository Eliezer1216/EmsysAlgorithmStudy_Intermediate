/*
-> 그래프(DFS, BFS)
  1. DFS : 스택과 비슷한 방식으로 재귀함수를 이용해
           연결되어 있는 노드 먼저 선택함.?
  2. BFS : 큐를 이용해 가까운 것들을 모두 큐에 푸시 팝함.
*/

import java.io.*;
import java.util.*;

public class baek1260 {

    static ArrayList<Integer>[] A; //그래프 저장 인접리스트
    static boolean[] visitedD; // DFS 체크
    static boolean[] visitedB; // BFS 체크

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //버퍼리더
        StringTokenizer st = new StringTokenizer(br.readLine()); 

        int n = Integer.parseInt(st.nextToken()); //정점의 개수
        int m = Integer.parseInt(st.nextToken()); //간선의 개수
        int start = Integer.parseInt(st.nextToken()); //시작점

        A = new ArrayList[n + 1]; //ArrayList 초기화
        visitedD = new boolean[n + 1]; //초기화
        visitedB = new boolean[n + 1]; //초기화

        for (int i = 1; i < n + 1; i++) {
            A[i] = new ArrayList<>(); //초기화
        }

        for (int i = 0; i < m; i++) { //간선 개수만큼
            st = new StringTokenizer(br.readLine()); 
            int s = Integer.parseInt(st.nextToken()); //시작점
            int e = Integer.parseInt(st.nextToken()); //끝점

            A[s].add(e);// 양방향 그래프라서
            A[e].add(s);

        }
        for (int i = 1; i < n + 1; i++) {
            Collections.sort(A[i]); //오름차순으로 정렬
        }
        if (!visitedD[start]) {
            DFS(start); //start에서 DFS
        }
        System.out.println();
        if (!visitedB[start]) {
            BFS(start); // start에서 BFS
        }
    }

    static void DFS(int v) {
        if (visitedD[v]) {
            return; //방문했을 시 return
        }
        System.out.print(v+ " ");
        visitedD[v] = true; //방문했다고 체크
        for (int i : A[v]) { 
            if (!visitedD[i]) {
                DFS(i); // 방문하지 않았을 때 dfs
            }
        }
    }

    static void BFS(int v) {
        Queue<Integer> queue = new LinkedList<>(); //bfs하기 위해 queue 선언
        queue.add(v); // queue에 추가
        visitedB[v] = true; //방문했으므로 true

        while (!queue.isEmpty()) { //queue가 비지 않을 때 까지
            int now = queue.poll(); //pop
            System.out.print(now+ " ");
            for (int i : A[now]) { //리스트에 있는 값들을 모두 push
                if (!visitedB[i]) {
                    visitedB[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}
