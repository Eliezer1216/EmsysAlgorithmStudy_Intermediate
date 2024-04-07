/* 나의 풀이 - 신효민
    1. mode를 두개 설정한다.
    큐에서 꺼내서 뒤에 넣는 모드 -> flag=true
    큐에서 꺼내는 모드 -> flag=false
    2. 큐가 빌때까지 모드를 번갈아가면서 실행 -> 마지막에 꺼내는 수가 결과값이다.
    중요사항 : N=1일때 정답은 무조건 1이다. 그 외에는 위의 두 과정을 진행하면 된다.
 */
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int result; // 결과값 변수
    public static void main(String[] args)  {
        Scanner sc=new Scanner(System.in);
        Queue<Integer> queue=new LinkedList<>(); // 큐 선언
        int N=sc.nextInt();
        for(int i=1;i<=N;i++)
        {
            queue.add(i); // 큐에 값 집어넣기
        }
        if(N==1) // N이 1일때 1 출력
        {
            System.out.println(1);
        }
        else
        {
            queue.poll(); // 맨 먼저 맨 위의 값을 꺼낸다.
            boolean flag=true; // 큐에서 꺼내서 뒤에 넣는 mode -> true
                               // 큐에서 꺼내는 mode -> false
            while(!queue.isEmpty()) // 큐가 빌때까지
            {
                if(flag==true) // 큐에서 꺼내서 뒤에 넣는 mode 일때
                {
                    int now=queue.poll(); // 꺼내서
                    queue.add(now); // 뒤에 넣는다.
                    flag=false; // mode를 바꿔준다.
                }
                else
                {
                    result= queue.poll(); // 큐에서 꺼내서 result에 저장
                    flag=true; // mode를 바꿔준다.
                }
            }
            System.out.println(result); // 맨 마지막에 남아있는 수 출력
        }

    }

}
