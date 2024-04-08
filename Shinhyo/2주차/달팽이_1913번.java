/*
풀이방법 - 신효민
    1. 문제를 보니 아래쪽 -> 오른쪽 -> 위쪽 -> 왼쪽으로 반복 순환하는 구조 -> 상하좌우 탐색을 위한 dx,dy 배열 선언
    2. 좌표 범위를 벗어나지 않는 선에서 위 순환 구조대로 순환하면서 배열 값이 0이면 값을 집어넣는다.
 */
import java.util.Scanner;

public class Main {

    static int [][] snail; // 달팽이 배열
    static int a,b; // 좌표 값
    static int N; // 입력받는 자연수
    static int num; // 알아볼 수
    static int A; // A=N*N
    static int [] result; // 알아볼 수에 대한 결과 좌표
    static int []dx={0,1,0,-1}; // 상하좌우로 이동하기 위함
    static int []dy={1,0,-1,0}; // 상하좌우로 이동하기 위함
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        StringBuilder stringBuilder=new StringBuilder(); // System.out.print()함수를 쓰면 시간초과 나기 때문에 StringBuilder 사용
        result=new int[2]; // 결과 좌표 저장 배열
        N=sc.nextInt();
        num=sc.nextInt(); // 알아볼수 입력
        A=N*N;
        snail=new int[N][N]; // 달팽이 2차원 배열 생성
        a=0;
        b=0;
        snail[a][b]=A; // 처음에 값 넣어줌
        A--;
        while(A>=1) // 배열이 꽉 찰때까지
        {
            for(int i=0;i<4;i++) // 상하좌우로 이동 , 문제를 보니 아래쪽 -> 오른쪽 -> 위쪽 -> 왼쪽 계속 반복하는 구조
            {
                while(true)
                {
                    a+=dy[i]; // 좌표 업데이트
                    b+=dx[i]; // 좌표 업데이트
                    if(a>=0&&b>=0&&a<N&&b<N) // 좌표가 벗어나지 않으면
                    {
                        if(snail[a][b]==0) // 배열 값이 비어있으면
                        {
                            snail[a][b]=A; // 값 집어넣어줌
                            A--; // 업데이트
                        }
                        else // 배열 값이 비어있지 않으면 -> 0이 아니면
                        {
                            a=a-dy[i]; // 좌표 원래대로 돌림
                            b=b-dx[i]; // 좌표 원래대로 돌림
                            break; // 꼭 써줘야함. -> 무한루프 탈출
                        }
                    }
                    else // 좌표가 배열의 범위를 벗어나면
                    {
                        a=a-dy[i]; // 좌표 원래대로 돌림
                        b=b-dx[i]; // 좌표 원래대로 돌림
                        break; // 꼭 써줘야함. -> 무한루프 탈출
                    }
                }

            }
        }
        for(int i=0;i<N;i++) // 알아볼수 num에 대한 좌표값을 찾고 , 달팽이 배열을 출력한다.
        {
            for(int j=0;j<N;j++)
            {
                if(snail[i][j]==num) // 알아볼수가 발견되면
                {
                    // 알아볼수에 대한 좌표 저장
                    result[0]=i+1;
                    result[1]=j+1;
                }
                stringBuilder.append(snail[i][j]).append(" "); // StringBuilder로 시간 초과 방지 , System.out.print()를 쓰면 시간 초과 발생
            }
            stringBuilder.append("\n");
        }
        System.out.print(stringBuilder); // 달팽이 배열 출력
        System.out.print(result[0]+" "+result[1]); // 알아볼 수에 대한 결과 좌표 출력
    }

}
