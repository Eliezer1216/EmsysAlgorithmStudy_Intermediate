/*나의 풀이 - 신효민
    풀이방법 : DFS 완전 탐색울 하면서 깊이가 4이면 문제에서 말하는 친구관계가 있는 것이다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

   static int N,M; // N -> 사람 명 수 , M-> 친구 관계 수
   static ArrayList<Integer>[]friend; // 친구 인접리스트 배열 선언
   static boolean [] visited; // 방문 배열 선언
   static boolean flag; // 문제에서 말하는 친구 관계가 있는지 판별하는 flag 값
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        friend=new ArrayList[N]; // 친구 인접리스트 배열 생성
        visited=new boolean[N]; // 방문 배열 생성
        flag=false; // flag 값 초기화
        for(int i=0;i<N;i++)
        {
            friend[i]=new ArrayList<>(); // 친구 인접리스트 배열 값에 리스트 넣기
        }
        for(int i=0;i<M;i++)
        {
            st=new StringTokenizer(br.readLine());
            int num=Integer.parseInt(st.nextToken());
            int num2=Integer.parseInt(st.nextToken());
            friend[num].add(num2); // 양쪽 방향으로 넣어줌
            friend[num2].add(num);
        }
        for(int i=0;i<N;i++)
        {
            int depth=0; // 깊이 초기화
            DFS(i,depth); // DFS 실행
            if(flag) // 문제에서 말하는 친구관계가 있다면 반복문을 빠져나간다.
                break;
        }
        if(flag) // 문제에서 말하는 친구관계가 있다면
        {
            System.out.println(1);
        }
        else { //문제에서 말하는 친구관계가 없다면
            System.out.println(0);
        }
    }
    static void DFS(int node,int depth) // 친구 관계 탐색
    {
        if(depth==4||flag==true) // 문제에서 말하는 친구관계가 있다면
        {
            flag=true;
            return;
        }
        visited[node]=true; // 방문 노드 방문 처리
        for(int k:friend[node])
        {
            if(!visited[k])
            {
                DFS(k,depth+1); // 깊이에 1을 더한채로 DFS 실행
            }
        }
        visited[node]=false; // 모든 친구 관계의 경우의 수를 생각하기 위해 방문 처리를 마지막에 false로 해야한다. -> 중요!!
    }

}
