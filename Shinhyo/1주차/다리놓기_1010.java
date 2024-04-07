/*나의 풀이 - 신효민
 -> 조합 사용 -> 다이내믹 프로그래밍 사용
 */
import java.util.Scanner;

public class Main {

    static int N,M;  
    static int test_case; // 테스트 케이스 갯수
    static int [][]result; // 다이내믹 프로그래밍을 위한 2차원 배열 선언
    public static void main(String[] args)  {
       Scanner sc=new Scanner(System.in);
       test_case=sc.nextInt(); // 테스트 케이스 갯수 입력 받기
       for(int t=0;t<test_case;t++) // 다이내믹 프로그래밍을 위해서 전처리 과정 필요
       {
           N=sc.nextInt(); 
           M=sc.nextInt();
           result=new int[M+1][M+1]; // 다이내믹 프로그래밍 2차원 배열 생성
           for(int i=0;i<=M;i++) // 다이내믹 프로그래밍을 위해서 전처리 과정 필요 -> 안 그러면 모든 값들이 0이 되는 상황이 발생해서 전처리 과정이 필요하다. 
           {
               result[i][0]=1; // ex) 2C0 -> 1
               result[i][i]=1; // ex) 2C2 -> 1
               result[i][1]=i; // ex) 2C1 -> 2
           }
           for(int i=2;i<=M;i++)
           {
               for(int j=1;j<i;j++) // i는 무조건 j보다 크거나 같아야 한다. -> 3C4는 불가능!!
               {
                   result[i][j]=result[i-1][j-1]+result[i-1][j]; // 점화식 사용 -> ex) 5C3라고 가정했을때 5C3은 4C3의 경우수 + 4C2의 경우수와 같다.
                                                                 // 5개중에서 3개를 선택하는 경우의 수는 4개중에서 3개를 선택하고 나머지 한개를 선택 안하는 경우의 수와 
                                                                //  4개중에서 2개를 선택하고 나머지 1개를 무조건 선택하는 경우의 수를 합친 것과 같다.
               }
           }
           System.out.println(result[M][N]); // 결과 출력
       }
    }
}

