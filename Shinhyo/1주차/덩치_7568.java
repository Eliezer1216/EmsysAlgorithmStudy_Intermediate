/* 나의 풀이 -신효민
    풀이과정 : 1. 몸무게와 키를 저장하는 Person객체를 만들고 Person 객체 배열에 저장
             2. 이중반복문을 통해 덩치 등수를 업데이트
 */


import java.util.Scanner;

public class Main {
    static int N; // 사람 명수
    static Person []person; // 몸무게와 키를 저장하는 Person 객체를 저장하는 Person 객체 배열
    static int order; // 덩치 등수
    public static void main(String[] args)  {
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        person=new Person[N]; // Person 객체 배열 생성
        for(int i=0;i<N;i++)
        {
            int weight=sc.nextInt(); // 몸무게 입력
            int height=sc.nextInt(); // 키 입력
            person[i]=new Person(weight,height); // Person 객체 배열에 객체 생성해서 저장
        }
        for(int i=0;i<N;i++)
        {
            order=1; // 덩치 등수 초기화
            for(int j=0;j<N;j++) // 이중반복문을 통해 덩치 등수 업데이트
            {
                if(person[i].getHeight()<person[j].getHeight()
                        &&person[i].getWeight()<person[j].getWeight())
                {
                   order++; // 몸무게와 키 둘다 작으면 덩치 등수 업데이트
                }
            }
            person[i].setOrder(order); // 객체에 덩치 등수 저장
        }

        for (int i=0;i<N;i++) // 각 객체의 덩치 등수 출력
        {
            System.out.print(person[i].getOrder()+" "); 
        }
    }

}
class Person // Person 클래스 
{
    private int weight; //몸무게
    private int height; // 키
    private int order; // 덩치 등수

    Person(int weight ,int height) // 생성자
    {
        this.weight=weight;
        this.height=height;
    }

    //메소드를 통해 멤버 변수에 접근한다. ( 멤버변수가 private로 되어있기 때문에 )
    public void setOrder(int order) // 덩치 등수 업데이트하는 메소드
    {
        this.order=order;
    }
    public int getWeight() // 객체의 몸무게 반환하는 함수
    {
        return this.weight;
    }
    public int getHeight() // 객체의 키 반환하는 함수
    {
        return this.height;
    }
    public int getOrder() // 덩치 등수 반환하는 함수
    {
        return this.order;
    }
}


