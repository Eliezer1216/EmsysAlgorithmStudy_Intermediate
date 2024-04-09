/* 나의 풀이 -신효민
    풀이 방법 : 상하좌우 위 아래를 탐색하면서 일수를 업데이트 해준다.
    중요한 점 : 익은 토마토들에서 동시 다발적으로 상하좌우 위 아래가 탐색이 되어야 하므로 처음 값을 저장할때 익은 토마토의 좌표도 큐에 집어넣는다.
    자세한 풀이는 밑 주석 참고!!            
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int [][][] tomato; // 토마토 3차원 배열
    static int M,N,H; // M -> 가로 길이 , N -> 세로길이 , H -> 높이
    static Queue<int[]>queue;
    static int []dx={1,-1,0,0,0,0}; // 상하좌우 위 아래를 탐색하기 위한 배열
    static int []dy={0,0,1,-1,0,0}; // 상하좌우 위 아래를 탐색하기 위한 배열
    static int []dz={0,0,0,0,-1,1}; // 상하좌우 위 아래를 탐색하기 위한 배열
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        M=Integer.parseInt(st.nextToken());
        N=Integer.parseInt(st.nextToken());
        H=Integer.parseInt(st.nextToken());
        tomato=new int[H][N][M]; // 토마토 3차원 배열 생성
        queue=new LinkedList<>();
        for(int i=0;i<H;i++) // 값 집어넣기
        {
            for(int j=0;j<N;j++)
            {
                st=new StringTokenizer(br.readLine());
                for(int t=0;t<M;t++)
                {
                    tomato[i][j][t]=Integer.parseInt(st.nextToken());
                    if(tomato[i][j][t]==1) // 1일때 ( 익은 토마토일때 )
                    {
                        queue.add(new int[]{i,j,t}); // 큐에 집어넣는다.
                    }
                }
            }
        }
        while(!queue.isEmpty()) // 큐가 빌때까지
        {
            int []now=queue.poll(); // 하나를 꺼낸다.
            for(int i=0;i<6;i++) // 상하좌우 위 아래를 탐색
            {
                int x=now[1]+dx[i];
                int y=now[2]+dy[i];
                int z=now[0]+dz[i];
                if(x>=0&&y>=0&&z>=0&&x<N&&y<M&&z<H) // 좌표 범위 벗어나는지 확인
                {
                    if(tomato[z][x][y]==0) // 안익은 토마토일때
                    {
                        tomato[z][x][y]=tomato[now[0]][now[1]][now[2]]+1; //  tomato[z][x][y] 에 일 수 업데이트
                        queue.add(new int[]{z,x,y}); // 큐에 집어넣는다.
                    }
                }
            }
        }

        // 최소 일수 찾기 -> ( 배열 값에서 가장 큰 값 -1 )
        int max=0; 
        for(int i=0;i<H;i++)
        {
            for(int j=0;j<N;j++)
            {
                for(int t=0;t<M;t++)
                {
                    max=Math.max(max,tomato[i][j][t]); // 최소 일수를 구하기 위함.
                    if(tomato[i][j][t]==0) // 안 익은 토마토가 하나라도 있다면
                    {
                        System.out.println(-1); // -1 출력하고 종료
                        return;
                    }
                }
            }
        }

        System.out.println(max-1); // 맨 처음에 익은 토마토부터 시작했으므로 1을 마이너스 해줘야한다.
        // tomato[z][x][y]=tomato[now[0]][now[1]][now[2]]+1; ( 맨 처음에 익은 토마토부터 시작했으므로 )

    }
}
