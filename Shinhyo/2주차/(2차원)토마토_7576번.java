/*
 나의 풀이-신효민
  풀이 방법 : 상하좌우를 탐색하면서 일수를 업데이트 해준다.
  중요한 점 : 익은 토마토들에서 동시 다발적으로 상하좌우가 탐색이 되어야 하므로 처음 값을 저장할때 익은 토마토의 좌표도 큐에 집어넣는다.
  자세한 풀이는 밑 주석 참고!!          
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

   static int [][]tomato; // 토마토 2차원 배열
   static int M,N; // M -> 가로 길이 ,  N -> 세로 길이
   static Queue<int[]> queue;
   static int []dx={-1,1,0,0}; // 상하좌우를 탐색하기 위한 배열
   static int []dy={0,0,-1,1}; // 상하좌우를 탐색하기 위한 배열
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        M=Integer.parseInt(st.nextToken());
        N=Integer.parseInt(st.nextToken());
        tomato=new int[N][M]; // 토마토 2차원 배열 생성
        queue=new LinkedList<>();
        for(int i=0;i<N;i++) // 값 집어넣기
        {
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++)
            {
                int num=Integer.parseInt(st.nextToken());
                if(num==1) // 익은 토마토이면
                {
                    queue.add(new int[]{i,j}); // 큐에 집어넣는다.
                }
                tomato[i][j]=num;
            }
        }

        while(!queue.isEmpty()) // 큐가 빌때까지
        {
            int []now=queue.poll(); // 큐에서 하나를 꺼낸다.
            for(int i=0;i<4;i++) // 상하좌우 탐색
            {
                int x=now[0]+dx[i];
                int y=now[1]+dy[i];
                if(x>=0&&y>=0&&x<N&&y<M) // 좌표 검사
                {
                    if(tomato[x][y]==0) // 안 익은 토마토라면
                    {
                        tomato[x][y]=tomato[now[0]][now[1]]+1; // tomato[x][y]에 일수를 업데이트해준다.
                        queue.add(new int[]{x,y}); // 큐에 집어넣는다.
                    }
                }
            }
        }

        // 최소 일수 구하기 -> ( 배열에 있는 최댓값 -1 )
        int max=0;
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<M;j++)
            {
                max=Math.max(max,tomato[i][j]);
                if(tomato[i][j]==0) // 안 익은 토마토가 있다면
                {
                    System.out.println(-1);
                    return;
                }
            }
        }
        // 맨 처음에 익은 토마토에서부터 일수를 업데이트해주므로 배열에 있는 최댓값에 -1 해줘야한다.
        System.out.println(max-1);

    }
}
