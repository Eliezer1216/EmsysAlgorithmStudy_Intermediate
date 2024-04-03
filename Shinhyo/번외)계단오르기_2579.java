/* 나의 풀이

    틀린 이유 : 포도주 시식_2156번 문제와 유사한 문제라서 풀이도 똑같게 했지만 틀렸다. 
    이 계단 오르기 문제에서는 무조건 마지막 계단을 밟아야 하므로
    Math.max 값에 score[i-1]를 넣으면 안된다. 예를 들어 n=3일때를 생각해보자 포도주 시식에서는 첫번째 와인+세번째 와인 , 두번째 와인+세번째 와인 , 첫번째 와인+두번째 와인
    이런식으로 가능했지만 여기서는 마지막 계단을 무조건 밟아야 하므로 포도주 시식에서 첫번째 와인+두번째 와인와 같이  첫번째 계단+두번째 계단 이 경우는 하면 안된다!!
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int []stairs;  // 계단 배열
    static int []score; // 계단 최댓값 배열 ( dp )
    static int  n; // 계단 갯수
    public static void main(String args[])throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        stairs=new int[n+1];
        score=new int[n+1];

        for(int i=1;i<=n;i++) // 계단 점수 입력
        {
            int num=Integer.parseInt(br.readLine());
            stairs[i]=num;
        }
        if(n==1)
        {
            System.out.println(stairs[1]);
        }
        else if(n==2)
        {
            System.out.println(stairs[1]+stairs[2]);
        }
        else if(n>2)
        {
            score[1]=stairs[1];
            score[2]=stairs[1]+stairs[2];
            //마지막 계단은 무조건 밟아야한다. 
            // 포도주 시식_2156번 에서는 Math.max에 score[i-1]도 넣어 비교했지만
            // 이것은 마지막 계단을 무조건 밟아야하는 이 문제에서는 넣으면 안된다!!
            for(int i=3;i<=n;i++) 
            {
                score[i]=Math.max(score[i-2]+stairs[i],
                                score[i-3]+stairs[i-1]+stairs[i]);
            }


            // 결과값 출력
            System.out.println(score[n]);
        }
    }
}




