/* 나의 풀이 - 신효민
    풀이 방법 : 두개의 해쉬맵을 선언해서
    첫번째  해쉬맵에는 -> 숫자 : 빈도수
    두번째 해쉬맵에는 -> 숫자 : 숫자가 나온 순서 로 선언해서
    값들을 저장한다.
    그후에 해쉬맵을 순회하면서
    숫자 , 빈도수 , 나온 순서등을 멤버변수로 갖는 Bindo 클래스를 생성해 리스트에 넣는다.
    리스트를 정렬할때 문제에 나와있는 조건에 따라 객체 정렬을 수행한다. ( Comparable 사용 )
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main{

    static int N,C; // 메세지의 길이 -> N
    static HashMap<Integer,Integer> map1; // 숫자 : 빈도수를 저장하는 해쉬맵1
    static HashMap<Integer,Integer>map2; // 숫자 : 나온 순서를 저장하는 해쉬맵2
    static ArrayList<Bindo>list; // Bindo 클래스를 저장하는 리스트
    public static void main(String []args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        StringBuilder stringBuilder=new StringBuilder();
        N=Integer.parseInt(st.nextToken());
        C=Integer.parseInt(st.nextToken());
        map1=new HashMap<>();
        map2=new HashMap<>();
        list=new ArrayList<>();
        st=new StringTokenizer(br.readLine());
        int order=1;
        for(int i=0;i<N;i++) // 값을 입력받을때마다 해쉬맵1 , 해쉬맵2에 각각 저장
        {
            int num=Integer.parseInt(st.nextToken());
            if(map1.containsKey(num)) // 키가 해쉬맵1에 포함되어있다면 ( 숫자가 이미 해쉬맵1에 키로써 저장되어있다면 )
            {
                int k=map1.get(num);
                map1.put(num,k+1); // 빈도수 업데이트 해준다.
            }
            else
            {
                map1.put(num,1); // 숫자(키)가 해쉬맵1에 없다면 새로 넣어줌
            }
            if(!map2.containsKey(num)) // 키가 해쉬맵2에 포함되어 있지 않다면 ( 숫자가 이미 해쉬맵2에 키로써 저장되어 있지 않다면 )
            {
                map2.put(num,order); // 숫자 : 순서 새로 넣어줌
                order++; // 순서 업데이트
            }
        }
        for(int key:map1.keySet()) // Bindo 클래스를 만들어 리스트에 넣어줌
        {
            list.add(new Bindo(key,map1.get(key),map2.get(key)));
        }
        Collections.sort(list); // Bindo 클래스에 나와있는 comparable에 맞게 객체 정렬 수행한다.
        for(int i=0;i<list.size();i++)
        {
            for(int j=0;j<list.get(i).number;j++)
            {
                stringBuilder.append(list.get(i).num+" ");
            }
        }
        System.out.println(stringBuilder); // 결과값 출력.
    }
}


class Bindo implements Comparable<Bindo> {

    int num; // 숫자
    int number; // 빈도수
    int order; // 숫자가 나온 순서

    //생성자
    Bindo(int num,int number,int order)
    {
        this.num=num;
        this.number=number;
        this.order=order;
    }

    @Override
    public int compareTo(Bindo o) {
        if(this.number==o.number) // 빈도수가 같다면
        {
            return this.order-o.order; // 순서를 고려해서 정렬 수행 ( return 값이 양수면 위치를 바꿔줌 , 음수면 위치를 바꿔주지 않음. )
        }
        else
        {
            return -(this.number-o.number); // 빈도수가 많은 쪽이 앞으로 정렬( return 값이 양수면 위치를 바꿔줌 , 음수면 위치를 바꿔주지 않음. )
        }
    }
}
