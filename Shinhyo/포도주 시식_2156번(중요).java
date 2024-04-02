/*풀이 방법 : - 신효민

    많이 헤맸던 이유 :
    1.자꾸 연속적으로 생각을 하려고 했다.
      어떤 포도주의 모든 경우의 수에서 그 다음 포도주를 마실때의 모든 경우의수를 생각함으로써
      정말 많은 경우의 수를 생각하느라 많이 헤맸다. ex) dp[i]=dp[i-1]+wine[i] ->이런식으로 생각을 해서 많이 헤맸다.
      대신 , 어떤 포도주를 마실때 전에 구했던 최댓값에 영향을 받지 않으면서 확실하게 그 포도주를 마실때의 최댓값을 구해야한다. ( 밑의 글 참고 )

    어떤 방식으로 풀어야 되나?
    예를 들어 4개의 포도주가 있다고 하자.
    4번째 포도주까지의 최댓값의 경우의 수는 첫번째 포도주+세번째 포도주+4번째 포도주 , 4번째 포도주를 마시지 않았을때 , 첫번째 포도주 +두번째 포도주+ 4번째 포도주이다.
    여기서 중요한 것이 첫번째 포도주+세번째 포도주+4번째 포도주를 -> S[4]=S[3]+wine[1]+wine[4] 이런식으로 처리하면 안된다.
    S[3]에 S[3]까지의 어떤 포도주 정렬이 있을지 모른다. 대신 -> S[4]=S[1]+wine[3]+wine[4]로 하면
    S[1]에 어떤 S[1]까지의 포도주 정렬이 오더라도 문제가 되지 않는다.

    비슷한 문제 -> 계단 오르기_2579번 -> 비슷한 풀이로 가능!!
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int []wine; // 포도주 배열
    static int []max_wine; // 포도주 dp 배열 ( 최댓값 )
    static int n; // 포도주 갯수
    public static void main(String args[])throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        wine=new int[n+1];
        max_wine=new int[n+1];
        for(int i=1;i<wine.length;i++) // 포도주 입력 받기
        {
            int num=Integer.parseInt(br.readLine());
            wine[i]=num;
        }

        if(n==1) // 총 포도주가 한개일때 
        {
            System.out.println(wine[1]);
        }
        else if(n==2)// 총 포도주가 2개일때
        {
            System.out.println(wine[1]+wine[2]);
        }
        else if(n>2) // 총 포도주가 2개보다 많을때
        {
            max_wine[1]=wine[1];
            max_wine[2]=wine[1]+wine[2];
            for(int i=3;i<=n;i++) 
            {
                max_wine[i]=Math.max
                        (max_wine[i-1], // 포도주를 마시지 않았을때 == 그 전의 최댓값
                            Math.max(max_wine[i-2]+wine[i], // 포도주를 마셨을때 case 1
                                    max_wine[i-3]+wine[i-1]+wine[i])); // 포도주를 마셨을때 case 2
            } 
            // 맨 위의 글 참고!!
            System.out.println(max_wine[n]);
        }

    }
}
