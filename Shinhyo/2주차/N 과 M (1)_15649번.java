/* 나의 풀이 -신효민 
   풀이과정 : DFS 완전 탐색으로 모든 경우의 수를 탐색 , M개를 뽑아야하므로 탐색 깊이가 M일때 누적했던 문자열 출력후 return시킨다.
   주의해야할 점 : 모든 경우의 수를 탐색하는 것이므로 DFS 함수 내에서 마지막에 방문 처리를 false로 처리해줘야한다. 그래야 모든 경우의 수를 탐색가능!!
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

   static int N,M; // N -> 자연수  , M -> 몇개 뽑을건지
   static boolean []visited; // 방문 배열 선언
   static ArrayList<Integer>[] list; // 인접리스트
   static int depth; // 깊이 , M개만 뽑기 위해서
   static String s; // 출력을 위한 문자열
    public static void main(String[] args)throws IOException {
       BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st=new StringTokenizer(br.readLine());
       N=Integer.parseInt(st.nextToken());
       M=Integer.parseInt(st.nextToken());
       list=new ArrayList[N+1]; // 인접리스트 선언
       visited=new boolean[N+1]; // 방문배열 선언
       for(int i=1;i<=N;i++) // 인접리스트 내에 리스트 선언
       {
           list[i]=new ArrayList<>();
       }

       for(int i=1;i<=N;i++) // 인접리스트에 값 넣기
       {
           for(int j=1;j<=N;j++)
           {
               if(i==j)
               {
                   continue;
               }
               list[i].add(j);

           }
       }

       for(int i=1;i<=N;i++) 
       {
           depth=1; // 탐색을 시작하는 순간부터 깊이가 1이니 1로 초기화
           //visited=new boolean[N+1]; // 방문배열 초기화
           s=""; // 문자열 초기화
           DFS(i,depth,s); // 탐색 시작
       }

    }
    static void DFS(int node,int depth,String s)
    {
        s+=node+" ";
        if(depth==M) // 깊이가 M이면 
        {
            System.out.println(s); // 문자열 출력
            return;
        }
        visited[node]=true; // 방문처리
        for(int k:list[node])
        {
            if(!visited[k])
            {
                DFS(k,depth+1,s); // 탐색
            }
        }
        visited[node]=false; // 이 부분 중요 -> 모든 경우의 수를 탐색하기 위해 이 코드가 중요하다!!
    }
}
