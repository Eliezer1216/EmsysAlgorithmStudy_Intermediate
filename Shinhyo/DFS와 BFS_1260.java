/* 나의 풀이 -신효민
    풀이과정 : 1. 인접리스트로 그래프를 만든다.
             2. DFS 실행하면서 방문한 정점 출력
             3. BFS 실행하면서 방문한 정점 출력
 */
import java.io.IOException;
import java.util.*;

public class Main {

    static int N,M,V; // N-> 정점의 갯수 , M -> 간선의 갯수 , V -> 시작 위치
    static ArrayList<Integer>[]graph; //인접리스트 배열 선언
    static boolean []dfs_visited; // DFS시 방문배열
    static boolean []bfs_visited; // BFS시 방문배열
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt(); // 정점의 갯수 입력
        int M=sc.nextInt(); // 간선의 갯수 입력
        int V=sc.nextInt(); // 시작 위치 입력
        graph=new ArrayList[N+1]; // 인접리스트 배열 생성
        dfs_visited=new boolean[N+1]; // DFS 방문배열 생성
        bfs_visited=new boolean[N+1]; // BFS 방문배열 생성
        for(int i=1;i<graph.length;i++)
        {
            graph[i]=new ArrayList<Integer>(); // 인접리스트 배열의 각 요소에 ArrayList선언
        }
        for(int i=0;i<M;i++)
        {
            int num1=sc.nextInt();
            int num2=sc.nextInt();
            // 간선이 양방향이므로 양쪽 정점에 서로 추가
            graph[num1].add(num2);
            graph[num2].add(num1);
        }
        for(int i=1;i<graph.length;i++) 
        {
            Collections.sort(graph[i]); // 방문할때 정점의 번호가 낮은것부터 방문해야하므로 정렬
        }
        DFS(V); // DFS 실행
        System.out.println();
        BFS(V); // BFS 실행

    }
    static void DFS(int node)
    {
        if(dfs_visited[node]) // node가 방문한 정점이라면 바로 종료
        {
            return;
        }
        dfs_visited[node]=true; // 방문한 정점을 방문 처리 해준다.
        System.out.print(node+" ");
        for(int k:graph[node])
        {
            if(!dfs_visited[k]) // 그 node와 연결되어 있는 정점이 방문하지 않았다면
            {
                DFS(k); // DFS 탐색
            }
        }
    }
    static void BFS(int node)
    {
        Queue<Integer> queue=new LinkedList<Integer>(); // BFS를 위한 큐 선언
        queue.offer(node); // 큐에 시작 node를 집어넣는다.
        bfs_visited[node]=true; // 시작 node를 방문처리
        while(!queue.isEmpty()) // 큐가 빌때까지
        {
            int now=queue.poll(); // 큐에서 한개를 꺼낸다.
            System.out.print(now+" ");
            for(int k:graph[now])
            {
                if(!bfs_visited[k]) // 큐에서 꺼낸 노드와 연결되어 있는 정점들이 방문하지 않았다면
                {
                    bfs_visited[k]=true; // 방문 처리후
                    queue.add(k); // 큐에 추가
                }
            }
        }
    }
}


