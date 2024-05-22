/*
-> 백트래킹
-> 1차원 배열에서 숫자 선택 후 이차원배열의 값을 더해서 작으면 백트래킹
-> 재귀함수의 원칙 지켜야됨
*/

import java.io.*;
import java.util.*;

public class java14889 {
    static int n;
    static int ans1, ans2, realans=Integer.MAX_VALUE;
    static int[][] arr;
    static boolean[] check;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr=new int[n][n];
        check = new boolean[n];

        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(split[j]);
            }
        }

        recur(0,0); //순열
        System.out.println(realans);

    }

    static void recur(int idi, int cnt) {//시작 값, cnt 잡고
        if (cnt == n/2) { //cnt가 n/2일 시
            for (int i = 0; i < n; i++) {
                if (check[i]) {
                    for (int j = 0; j < n; j++) {
                        if (check[j]) {
                            ans1 += arr[i][j];
                        }
                    }

                } else {
                    for (int j = 0; j < n; j++) {
                        if (!check[j]) {
                            ans2 += arr[i][j];
                        }
                    }
                }

            }
            realans = Math.min(realans, Math.abs(ans1 - ans2)); //최솟값 계산
            ans1 = 0; ans2 = 0; //다음 재귀를 위해 초기화
            return;
        }

        for (int i = idi; i < n; i++) { //순열이라
            if (!check[i]) {
                check[i] = true;
                recur(i+1,cnt+1);
                check[i] = false; //다음 재귀를 위해 초기화
            }

        }
    }
}
