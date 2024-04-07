/*나의 풀이 -신효민
    알고리즘 : 다이내믹 프로그래밍
    헤맸던 이유 : Bottom-up 방식도 있는데 너무 Top-down 방식만을 생각해서 헤맸다.
    풀이방법 : 밑에서 2개씩 짝지어 2개중에  큰 값을 골라 바로 윗 줄의 수와 더해서 저장한다. -> 반복
 */

import java.util.Scanner;

public class Main {

    static int n; // 삼각형이 몇줄로 되어있는지 저장하는 변수
    static int [][] triangle; // 삼각형 2차원 배열
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        triangle=new int[n][n]; // 삼각형 2차원 배열 생성
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<i+1;j++)
            {
                int num=sc.nextInt();
                triangle[i][j]=num; // 삼각형 2차원 배열에 값넣기
            }
        }
        for(int i=n-1;i>=0;i--) // Bottom-up 방식이다.
        {
            for(int j=0;j<i;j++)
            {
                // 두개씩 짝지어 2개중 큰 수를 고르고 바로 윗줄에 있는 수와 더해서 저장한다. -> 반복
                triangle[i-1][j]= Math.max(triangle[i][j],triangle[i][j+1])+triangle[i-1][j];
            }
        }
        System.out.println(triangle[0][0]); // 제일 위에 있는 값이 최댓값이다.
    }
}




