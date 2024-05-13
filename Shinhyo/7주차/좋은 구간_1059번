/*나의 풀이
       1. 정렬 수행후 n이 포함되는 큰 범위를 구한다.
       2. 구한 범위 내에서 n이 무조건 포함되는 좋은 구간을 구한다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Main{

    static int L; // 집합 S의 크기
    static ArrayList<Integer> num_list; // 숫자를 저장하는 리스트
    static int n; // 포함해야 하는 숫자
    public static void main(String []args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        L=Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine()," ");
        num_list=new ArrayList<>();
        num_list.add(0); // 여기 중요 ->  밑 테스트 케이스를 만족시키기 위해 0을 추가
        /*
         테스트 케이스 
         3
         7 8 9
         2
         일때도 생각을 해야한다!!
         답은 : 9
         [1,2] ,[1,3],[1,4],[1,5],[1,6],[2,3],[2,4],[2,5],[2,6]
         */
        for(int i=0;i<L;i++) // 숫자 입력
        {
            int num=Integer.parseInt(st.nextToken());
            num_list.add(num);
        }
        Collections.sort(num_list); // 정렬 수행

        n=Integer.parseInt(br.readLine());
        int start=0;
        int end=0;
        for(int i=0;i<num_list.size()-1;i++) // n이 포함되어 있는 범위를 구한다.
        {
            if(n>num_list.get(i)&&n<num_list.get(i+1))
            {
                start=num_list.get(i)+1;
                end=num_list.get(i+1)-1;
                break;
            }
        }
        int sum=0; // 좋은 구간 갯수
        for(int i=start;i<=n;i++) // n이 무조건 포함되어 있는 좋은 구간을 구한다.
        {
            for(int j=n;j<=end;j++)
            {
                sum++;
            }
        }
        if(sum==0) // 좋은 구간이 하나도 없으면
        {
            System.out.println(0);
        }
        else
        {
            System.out.println(sum-1); // 1을 빼주는 이유 , 위에서 [n,n]도 포함하기 때문
        }
    }
}
