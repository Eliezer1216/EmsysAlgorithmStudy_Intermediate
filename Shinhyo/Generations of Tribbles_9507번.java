/*나의 풀이 - 신효민
    시간초과 발생 -> 재귀 함수를 이용했더니 시간초과 발생 -> 값이 크게 나오면 dp를 생각해보자
    풀이방법 : 점화식이 나와있으니 다이내믹 프로그래밍을 사용하여 답을 구하자.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    
    static int test_case; // 테스트 케이스 갯수 
    static long []dp; // dp 배열 -> 값이 크게 나오므로 long 타입으로 선언
    public static void main(String args[])throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        test_case=Integer.parseInt(br.readLine()); // 테스트 케이스 입력
        dp=new long[68]; //최소범위가 0 , 최대범위가 67까지이므로 68을 크기로 선언
        // 문제 조건에 따라 dp 배열에 입력
        dp[0]=1;
        dp[1]=1;
        dp[2]=2;
        dp[3]=4;
        
        for(int i=0;i<test_case;i++)
        {
            int num=Integer.parseInt(br.readLine());
            for(int j=4;j<68;j++) // 문제 조건에 따라 dp 배열 채움
            {
                dp[j]=dp[j-4]+dp[j-3]+dp[j-2]+dp[j-1];
            }
            System.out.println(dp[num]); // 결과값 출력
        }

    }
}





