import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);// n 입력받음
        int n = sc.nextInt(); 
        int cnt5=0; //5kg 설탕 개수
        int cnt3=0; //3kg 설탕 개수
        int ans=5000; // 정답

        while (n>=3) { //n이 3보다 클때만 반복문
            while (n >= 5) { //n이 5보다 크거나 같을 때 5kg 갯수 세기
                n -= 5;
                cnt5++;
            }
            if (n == 0) { //n이 0일 때 정답 판별
                if (ans > cnt3 + cnt5&&cnt3+cnt5!=0) {//새롭게 계산된 갯수가 이전의 갯수보다 작을때와 0이 아닐 때
                    ans = cnt3 + cnt5;
                }
            }
            n-=3; //3kg 설탕봉지 개수 추가
            cnt3++;
            if (n == 0) { //한번 더 판별
                if (ans > cnt3 + cnt5&&cnt3+cnt5!=0) {
                    ans = cnt3 + cnt5;
                }
            }
            n+=cnt5*5; //3kg 설탕봉지 제외된 무게 복구
            cnt5 = 0; //5kg 갯수 초기화
        }
        if (ans == 5000) { //ans가 5000이면 값이 변경되지 않았으므로 -1출력
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }

    }

}
