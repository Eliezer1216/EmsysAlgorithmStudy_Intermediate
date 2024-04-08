/*나의 풀이 -신효민
    -각 단계를 거칠때마다 누적합을 만들어 비교한 후 작은 값을 저장한다.
    자세한 풀이는 밑 코드 주석 참고
    ( 정수삼각형 _1932번 문제랑 비슷한 유형 )
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int [][] RGB; // RGB dp 2차원 배열
    static int N; // 집 갯수
    public static void main(String[] args)throws IOException {
       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
       N=Integer.parseInt(br.readLine());
       RGB=new int [N][N]; // RGB dp 2차원 배열 생성
       for(int i=0;i<N;i++) // 값 집어넣기
       {
           StringTokenizer st=new StringTokenizer(br.readLine());
           for(int j=0;j<3;j++)
           {
               RGB[i][j]=Integer.parseInt(st.nextToken());
           }
       }

        for(int i=1;i<N;i++)
        {

            for(int j=0;j<3;j++)
            {
                if(j==0) // 현재 빨강일때 , 그 전 초록+현재 빨강과 그 전 파랑+현재 빨강 의 값들중 작은 값을 선택한다.
                {
                    RGB[i][j]=Math.min(RGB[i][j]+RGB[i-1][1],RGB[i][j]+RGB[i-1][2]);
                }
                else if(j==1) // 현재 초록일때 , 그 전 빨강+현재 초록과 그 전 파랑+현재 초록 의 값들중 작은 값을 선택한다.
                {
                    RGB[i][j]=Math.min(RGB[i][j]+RGB[i-1][0],RGB[i][j]+RGB[i-1][2]);
                }
                else if(j==2) // 현재 파랑일때 , 그 전 빨강+현재 파랑과 그 전 초록+현재 파랑 의 값들중 작은 값을 선택한다.
                {
                    RGB[i][j]=Math.min(RGB[i][j]+RGB[i-1][0],RGB[i][j]+RGB[i-1][1]);
                }
            }
        }
        System.out.println(Math.min(RGB[N-1][0],Math.min(RGB[N-1][1],RGB[N-1][2]))); // 마지막 단계에서 제일 작은 값을 출력한다.

    }

}
