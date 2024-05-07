/*나의 풀이-신효민
    풀이방법 : 백트래킹 사용 -> k개의 번호중 6개를 뽑는 경우
    자세한 풀이는 밑 코드와 주석 참고
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main{

    static ArrayList<Integer> num_list; // 번호를 저장하는 리스트
    static StringBuilder stringBuilder;
     public static void main(String[]args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        while(true)
        {
            num_list=new ArrayList<>();
            stringBuilder=new StringBuilder();
            StringTokenizer st=new StringTokenizer(br.readLine()," ");
            int k=Integer.parseInt(st.nextToken()); // 번호 갯수 입력 받기
            if(k==0) // 0이 입력되면 입력 종료
            {
                return;
            }

            for(int i=0;i<k;i++) // 번호 입력 받기
            {
               int num=Integer.parseInt(st.nextToken());
                num_list.add(num);
            }
            lotto(0,new ArrayList<>(),0); // 함수 호출
            System.out.println(stringBuilder);
        }
    }
    //6개 뽑는 함수 -> 백트래킹 사용
    static void lotto(int depth,ArrayList<Integer>selectednums,int start)
    {
        if(depth==6) // 6개까지 뽑았으면
        {
            for(int i=0;i<selectednums.size();i++)
            {
                stringBuilder.append(selectednums.get(i)+" ");//결과값에 저장
            }
            stringBuilder.append("\n"); 
            return;
        }
        for(int i=start;i<num_list.size();i++)
        {
            ArrayList<Integer>list=new ArrayList<>(selectednums); 
            list.add(num_list.get(i));  // 여태까지 뽑은 번호조합에 추가
            lotto(depth+1,list,i+1);  // 다시 호출
        }
    }
}
