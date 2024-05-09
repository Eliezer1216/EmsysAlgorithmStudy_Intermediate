/*
-> 이분탐색, 매개변수탐색
*/

import java.io.*;
import java.util.*;

public class Main {

    static int n,m,MIN, MAX;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            MIN = Math.max(MIN, arr[i]); //가장 큰값을 찾음
            MAX += arr[i]; //강의 시간의 합
        }

        int start = MIN, end = MAX, ans = 0; //시작을 가장 큰 값, end를 강의시간의 합

        while (start <= end) {
            int mid = (start + end) / 2; 

            if (isValid(mid)) {
                end = mid - 1;
                ans = mid;
            } else {
                start = mid + 1;
            }
        }
        System.out.println(ans);
    }

    static boolean isValid(int range) {
        int cnt = 0;
        int sum = 0;

        for (int a : arr) {
            if (sum + a > range) {
                cnt += 1;
                sum = 0;
            }
            sum += a;
        }

        if(sum>0) cnt += 1;

        return cnt <= m;

    }
}
