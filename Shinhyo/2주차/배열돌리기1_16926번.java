/*나의 풀이
    풀이 방법 : 배열 돌리기 함수를 만들어서 재귀 호출한다.
    자세한 풀이는 밑 코드 주석 참고!!

    예를 들어 8*6 배열이다.
    8*6 배열 -> 시작점 ( 0, 0 ) 부터 시작해서 아래쪽-> 오른쪽 -> 위쪽 -> 왼쪽 으로 돌리기
    그 다음
    6*4 배열 -> 시작점 ( 1 , 1) 부터 시작해서 아래쪽  -> 오른쪽 -> 위쪽 -> 왼쪽으로 돌리기
    그 다음
    4*2 배열 -> 시작점 ( 2 , 2 ) 부터 시작해서 아래쪽 -> 오른쪽 -> 위쪽 -> 왼쪽으로 돌리기
    그 다음은
    2*0 배열인데 -> 돌리기 불가능
    2*1 배열이어도 -> 돌리기 불가능

    예를 들어 6*8 배열이다.
    6*8 배열 -> 시작점 ( 0, 0 ) 부터 시작해서 아래쪽-> 오른쪽 -> 위쪽 -> 왼쪽 으로 돌리기
    그 다음
    4*6 배열 -> 시작점 ( 1 , 1) 부터 시작해서 아래쪽  -> 오른쪽 -> 위쪽 -> 왼쪽으로 돌리기
    그 다음
    2*4 배열 -> 시작점 ( 2 , 2 ) 부터 시작해서 아래쪽 -> 오른쪽 -> 위쪽 -> 왼쪽으로 돌리기
    그 다음은
    0*2 배열인데 -> 돌리기 불가능
    1*2 배열이어도 -> 돌리기 불가능
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N,M;
    static int R; // 돌리는 횟수
    static int [][]map; //  2차원 배열
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        R=Integer.parseInt(st.nextToken());
        map=new int[N][M]; // 2차원 배열 생성
        for(int i=0;i<N;i++) // 값 집어넣기
        {
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++)
            {
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<R;i++) // 배열 돌리는 횟수만큼 돌리기
        {
            spin_map(N,M,0,0); // 배열 돌리기 함수 호출
        }

        for(int i=0;i<N;i++) // 횟수만큼 돌린 후의 2차원 배열 출력
        {
            for(int j=0;j<M;j++)
            {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }


    }

    //배열 돌리기
    static void spin_map(int n,int m,int x,int y)
    {

        if(m<2||n<2) // m이 2 미만이거나 n이 2 미만이면
        {
            return;
        }
        int temp=map[x][y];
        int temp2;
        for(int i=0;i<n-1;i++) // 아래쪽으로 돌리기
        {
            temp2=map[x+1][y];
            map[x+1][y]=temp;
            x=x+1;
            temp=temp2;
        }

        for(int i=0;i<m-1;i++) // 오른쪽으로 돌리기
        {
            temp2=map[x][y+1];
            map[x][y+1]=temp;
            y=y+1;
            temp=temp2;
        }
        for(int i=0;i<n-1;i++) // 위쪽으로 돌리기
        {
            temp2=map[x-1][y];
            map[x-1][y]=temp;
            x=x-1;
            temp=temp2;
        }
        for(int i=0;i<m-1;i++) // 왼쪽으로 돌리기
        {
            temp2=map[x][y-1];
            map[x][y-1]=temp;
            y=y-1;
            temp=temp2;
        }
        spin_map(n-2,m-2,x+1,y+1); // 시작점 새로 설정 후 배열 돌리기 함수 호출
    }
}
