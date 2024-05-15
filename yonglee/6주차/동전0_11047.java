/*
-> greedy
*/

import java.io.*;
import java.util.*;

public class java11047 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int cnt = 0; //동전 갯수
        int[] coin = new int[n]; //동전 기차 배열

        for (int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        for (int i = n - 1; i >= 0; i--) {
            if (m == 0) {
                break; //잔여금액이 0일시 브렉
            }
            if (m >= coin[i]) {
                while (m >= coin[i]) {//가치보다 클떄까지 반복
                    m -= coin[i]; 
                    cnt++;
                }

            }
        }

        System.out.println(cnt);



    }
}
