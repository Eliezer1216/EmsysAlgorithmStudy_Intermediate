/*
나의 풀이 - 신효민
    풀이 방법 : B에서 한칸한칸 옮겨가면서 A를 비교해 둘의 차이가 최소인 것을 찾아낸다.
    문제에 나와있는 1,2 조건은 어차피 둘의 차이가 최소인 구간만 찾아내면 추가만 하면 되는 것이므로
    1,2 조건은 생각 안해도 된다.
    자세한 풀이는 밑 주석 참고!
 */
import java.util.Scanner;

public class Main {

    static String A;
    static String B;
    public static void main(String[] args)  {
        Scanner sc=new Scanner(System.in);
        A=sc.next();
        B=sc.next();
        int min=Integer.MAX_VALUE;
        for(int i=0;i<=B.length()-A.length();i++) // 한칸 씩 옆으로 옮기면서 비교
        {
            int sum=0;
            for(int j=0;j<A.length();j++)
            {

                    if(B.charAt(i+j)!=A.charAt(j)) // 같지 않으면
                    {
                        sum++;
                    }
            }
          min=Math.min(min,sum);
        }
        System.out.println(min);

    }
}

