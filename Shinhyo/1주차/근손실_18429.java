/* 나의 풀이 -신효민
    1. 운동키트 서로 양방향으로 연결된 그래프를 만든다.
    2. DFS를 실행해서 모든 경우의 수를 탐색한다.
    3. 탐색시 깊이가 N이되면 성공이므로 그때 결과값에 1을 증가시킨다.
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Kit>[] list; // Kit 인접리스트 -> 모든 경우의 수를 탐색하기 위한 인접리스트
    static int N,K; // 운동키트 갯수-> N , K
    static boolean []visited; // 방문배열 선언
    static int count; // 결과값
    static Kit [] kits; // kit 저장 배열 -> 모든 경우의 수를 탐색하기 위한 배열
    public static void main(String[] args)  {
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt(); // 운동키트 입력
        K=sc.nextInt(); // 줄어드는 중량 입력
        list=new ArrayList[N+1]; // Kit 인접리스트 생성
        kits=new Kit[N+1];  // kit 저장 배열 생성
       for(int i=1;i<=N;i++)
       {
           list[i]=new ArrayList<Kit>(); // 인접리스트 초기화
       }
        for(int i=1;i<=N;i++)
        {
            int num=sc.nextInt(); // 운동키트 중량 입력
            kits[i]=new Kit(i,num); // kit 저장 배열에 저장
            for(int j=1;j<=N;j++)
            {
                if(i!=j)
                {
                    list[j].add(new Kit(i,num)); // 인접리스트에 저장
                }
            }
        }

       for(int i=1;i< kits.length;i++) // 모든 경우의 수를 찾기 위해서 DFS 실행
        {
            visited=new boolean[N+1]; // 방문배열 초기화해줘야 된다!!
            DFS(kits[i],1,0);
        }
        System.out.println(count); // 결과값 출력

    }
    static void DFS(Kit kit,int depth,int value)
    {

        if((value+kit.getWeight_increase())<K) // 누적값+중량증가가 K보다 작으면
        {
            return;
        }
        
        int sum=value+ kit.getWeight_increase()-K; // 누적값 계산하는 식
        visited[kit.getKit_num()]=true; // 방문 처리
        
        if(depth==N) // 깊이가 N이면 모든 경우의 수를 탐색했다고 생각하고 count를 증가시킨다.
        {
            count++;
            visited[kit.getKit_num()]=false; // -> 중요 -> 이것을 해줘야 모든 경우의 수를 탐색할수 있다!!
            return;
        }
        for(Kit k:list[kit.getKit_num()])
        {

            if(!visited[k.getKit_num()])
                DFS(k,depth+1,sum); // DFS 실행 

        }
        visited[kit.getKit_num()]=false; // 중요 -> 이것을 해줘야 모든 경우의 수를 탐색할수 있다!!
    }
}
class Kit // kit 클래스
{
    private int kit_num; // kit 번호
    private int weight_increase; // 중량 증가

    Kit(int kit_num,int weight_increase)
    {
        this.kit_num=kit_num;
        this.weight_increase=weight_increase;
    }

    public int getKit_num()
    {
        return this.kit_num;
    }
    public int getWeight_increase()
    {
        return this.weight_increase;
    }

}

/* 다른 풀이 분석 - 아이디 : jjw981206 , 제출번호 :  68418786
import java.util.Scanner;

public class Main {

    static int n, k; 
    static int[] arr;
    static boolean[] visit; //방문배열
    static int answer = 0; // 결과값

            static void dfs(int count, int weight) {
                if(count == n) { // 모든 운동 키트를 다 사용했다면
                    answer +=1;
                    return;
                }
                for(int i=0; i<n; i++) {
                    if(!visit[i] && weight >= 500) { // 방문하지 않았으면서 weight가 500이상이면
                        visit[i] = true; // 방문처리
                        dfs(count+1, weight + arr[i] - k); // count에 1 더해주고 , weight에 운동키트 중량 증가량과 k를 빼준다.
                        visit[i] = false; // 모든 경우의 수를 구하기 위해 꼭 적어줘야 한다!!
                    }
                }
            }
            public static void main(String args[]) {
                Scanner in = new Scanner(System.in);
                n=in.nextInt();
                k=in.nextInt();
                arr = new int[n];
                visit = new boolean[n];
                for(int i=0; i<n; i++) {
                    arr[i] = in.nextInt();  중량 입력 받기
                }
                dfs(0, 500); // count , weight 처음에 넣기
                System.out.println(answer);
            }
}
*/
