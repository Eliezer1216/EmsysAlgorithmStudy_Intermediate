/*나의 풀이 - 신효민
    풀이방법 : BFS를 돌리면서 거리를 업데이트 해준다. -> 자세한 풀이는 밑 주석 참고
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int [][] miro; // 미로 2차원 배열
    static int []dx={-1,1,0,0}; // 상하좌우를 탐색하기 위한 배열
    static int []dy={0,0,1,-1}; // 상하좌우를 탐색하기 위한 배열
    static int N,M;
    static boolean [][]visited; // 방문배열
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        miro=new int[N][M]; // 미로 2차원 배열 생성
        visited=new boolean[N][M]; // 방문 2차원 배열 생성
        for(int i=0;i<N;i++) // 값 입력받기
        {
            String s=br.readLine();
            for(int j=0;j<M;j++)
            {
                miro[i][j]=Integer.parseInt(Character.toString(s.charAt(j)));
            }
        }
        BFS(0,0); // BFS 돌림
        System.out.println(miro[N-1][M-1]); // 결과출력
    }
    static void BFS(int a,int b) // BFS
    {
        Queue<int[]> queue=new LinkedList<>();
        queue.offer(new int[]{a,b});
        visited[a][b]=true;
        while(!queue.isEmpty())
        {
            int []now=queue.poll();
            for(int i=0;i<4;i++)
            {
                int x=now[0]+dx[i]; // 상하좌우 탐색
                int y=now[1]+dy[i]; // 상하좌우 탐색
                if(x>=0&&y>=0&&x<N&&y<M) // 좌표 범위가 벗어나지 않도록 함. 좌표 범위 검사
                {
                    if(!visited[x][y]&&miro[x][y]!=0) // 벽이 아니고 방문하지 않았다면
                    {
                        miro[x][y]=miro[now[0]][now[1]]+1; // 거리 업데이트
                        visited[x][y]=true; // 방문처리 해준다.
                        queue.add(new int[]{x,y}); // 현재 탐색한 곳에 가서 다시 상하좌우를 탐색해야하므로 큐에 추가해준다.
                    }
                }
            }
        }
    }
}

