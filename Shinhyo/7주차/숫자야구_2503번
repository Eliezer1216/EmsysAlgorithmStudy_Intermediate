/*나의 풀이
    백트래킹 + 구현 문제
    풀이 방법 :
    1. 순열로 1~9 숫자중 서로 다른 숫자 3개를 뽑는다.
    2. 뽑은 숫자를 가지고 영수가 말한 스트라이크 , 볼을 판별한다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main{

    static ArrayList<Minheok> num_list; // 민혁이가 말한 숫자,영수가 말한 스트라이크 , 영수가 말한 볼을 저장한 클래스를 저장하는 리스트
    static boolean [] visited; // 방문 배열 ( 숫자 순열 조합을 위한 방문 배열 )
    static int N; // 민혁이가 말한 숫자 갯수
    static int result; // 결과값
    public static void main(String []args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        result=0;
        visited=new boolean[10];
        num_list=new ArrayList<>();
        for(int t=0;t<N;t++) // 입력 받기
        {
            st=new StringTokenizer(br.readLine()," ");
            String s=st.nextToken();
            int strike=Integer.parseInt(st.nextToken());
            int ball=Integer.parseInt(st.nextToken());
            num_list.add(new Minheok(s,strike,ball));
        }
        backtrack(0,""); // 함수 호출
        System.out.println(result); // 결과값 출력
    }

    static void backtrack(int depth,String s)
    {
        if(s.length()==3) // 1~9의 숫자중 서로 다른 숫자 3자리를 뽑았다면
        {
            youngsu(s); // 그 숫자를 youngsu 함수에 넘겨줌
            return;
        }
        for(int i=1;i<=9;i++) // 1~9까지 숫자중에서 서로 다른 숫자 3개를 뽑아서 세자리수의 숫자를 만듬 -> 순열
        {
            if(!visited[i]) // 숫자 중복 방지를 위함
            {
                visited[i]=true;
                String k=s+Integer.toString(i);
                backtrack(depth+1,k);
                visited[i]=false; // 다시 방문배열 초기화
            }
        }
    }
    static void youngsu(String s) // 스트라이크 , 볼을 판별하는 함수
    {
        int count=0;
        for(int i=0;i<num_list.size();i++) // 다 검사함.
        {
            int strike=0;
            int ball=0;
           Minheok k=num_list.get(i); // 클래스를 꺼내옴
           for(int j=0;j<k.num.length();j++)
           {
               if(s.charAt(j)==k.num.charAt(j)) // 스트라이크 판별 검사
               {
                   strike++;
                   continue; // continue를 써줘야 밑에서 볼을 정확하게 판별할수 있다. -> 안 써주면 볼 갯수가 늘어난다.
               }
               if(s.contains(String.valueOf(k.num.charAt(j)))) // 볼 판별 검사
               {
                   ball++;
               }
           }
            if(strike==k.strike && ball==k.ball) // 영수가 말한 스트라이크와 볼 갯수가 둘다 맞다면
            {
                count++;
            }
        }
        if(count==N) // 다 검사했는데 다 맞다면
        {
            result++;
        }
    }
}

class Minheok // 민혁 클래스
{
    String num; // 민혁이가 말한 숫자
    int strike; // 영수가 말한 스트라이크
    int ball; // 영수가 말한 볼

    Minheok(String num,int strike,int ball)
    {
        this.num=num;
        this.strike=strike;
        this.ball=ball;
    }


}
