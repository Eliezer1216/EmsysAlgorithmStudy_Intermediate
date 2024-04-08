/* 나의 풀이 - 신효민
    1. 주유소마다 비용을 비교해서 최소비용으로 거리를 곱해 총 비용을 구한다.
     자세한 풀이는 밑 코드 주석 참고!
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N; // 주유소 갯수
    static long []gas_price; // 주유소마다의 기름 리터당 비용
    static long []distance; // 주유소 사이의 거리
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        distance=new long[N-1];
        gas_price=new long[N];
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<N-1;i++) // 주유소 사이의 거리 입력 받기
        {
            long num=Integer.parseInt(st.nextToken());
            distance[i]=num;
        }
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) // 주유소마다의 리터당 비용 입력 받기
        {
            long num=Integer.parseInt(st.nextToken());
            gas_price[i]=num;
        }
        long min_price=gas_price[0]; // 초기 최소값 설정
        long total_price=min_price*distance[0]; // 초기 총 비용 값 설정
        for(int i=1;i<N-1;i++)
        {
            if(min_price>gas_price[i]) // 새로 도착한 주유소 리터당 비용이 더 작다면 ( 더 최소라면 )
            {
                min_price=gas_price[i]; // 업데이트
            }
            total_price+=min_price*distance[i]; // 총비용에 업데이트한 최소 비용과 거리 곱해줌.
        }
        System.out.println(total_price); // 총비용 출력
    }

}
