/* 나의 풀이 - 신효민 
    풀이방법 : 
    1. 두 원 중심 사이의 거리랑 두 원 반지름의 합 거리를 비교한다.
    2. 두 원 중심 사이의 거리랑 두 원 반지름의 합 거리를 비교할때 중복 조건이 될수 있는 조건들이 있는지 비교하고 조건 분기를 잘 배치한다.       
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int test_case; // 테스트 케이스 갯수
    static int x1,y1,r1,x2,y2,r2;
    static double root_distance; // 두 원 중심간의 거리
    static double radius_sum; // 두 원의 반지름 합
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        test_case=Integer.parseInt(br.readLine());
        for(int i=0;i<test_case;i++)
        {
            StringTokenizer st=new StringTokenizer(br.readLine());
            x1=Integer.parseInt(st.nextToken());
            y1=Integer.parseInt(st.nextToken());
            r1=Integer.parseInt(st.nextToken());
            x2=Integer.parseInt(st.nextToken());
            y2=Integer.parseInt(st.nextToken());
            r2=Integer.parseInt(st.nextToken());
            root_distance=Math.sqrt(Math.pow(Math.abs(x1-x2),2)+Math.pow(Math.abs(y1-y2),2)); // 두 원 중심간의 거리
            radius_sum=r1+r2; // 두 원의 반지름을 합한 거리
            
            // 조건 분기 배치를 잘해야 함. -> 중요
            // ex) 두 원의 중심이 같고 반지름이 다를때 0이어야 하는데 조건 분기 배치를 잘 못하면 무한대가 나옴.
            // ex) 한 원이 한 원 안에 있는데 겹치지 않는 경우에서 root_distance<radius_sum 조건을 만족하는 경우가 있으므로 -> 중복 조건이 될수 있는 경우 예시
            //      root_distance<radius_sum 조건은 맨 마지막으로 빼야 함.
            
            if(root_distance>radius_sum) // 두 원이 떨어져 있는 경우
            {
                System.out.println(0);
            }
            else if(root_distance==radius_sum) // 두 원이 붙어 있는 경우
            {
                System.out.println(1);
            }
            else if(root_distance==0&&r1==r2) // 두 원의 중심이 같은 경우 -> 무한대
            {
                System.out.println(-1);
            }
            else if(Math.max(r1,r2)==Math.min(r1,r2)+root_distance) // 한 원이 한 원 안에 있는데 한 점에서 겹치는 경우
            {
                System.out.println(1);
            }
            else if(Math.min(r1,r2)+root_distance<Math.max(r1,r2)) //  한 원이 한 원 안에 있는데 겹치지 않는 경우
            {
                System.out.println(0);
            }
            else if(root_distance<radius_sum) // 두 원이 두 점에서 겹치는 경우
            {
                System.out.println(2);
            }

        }
    }
}
