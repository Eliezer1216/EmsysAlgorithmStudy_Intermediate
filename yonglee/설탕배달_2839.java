/*
 -> 그리디
 -> 5kg 설탕의 갯수가 가장 많아야 봉지 갯수가 적어지므로
    1. 3kg 설탕의 갯수가 0일 떄 부터 시작해 5kg 봉지 갯수를 세어 
    2. 무게가 0이 되는 지점에서 최솟값을 비교함.
    3. 3kg 설탕의 봉지 갯수를 1씩 늘리며 더 이상 3kg 설탕 봉지를 늘릴 수 없을 때까지 반복함.
 */

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
