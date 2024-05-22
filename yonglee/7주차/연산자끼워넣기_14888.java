/*
-> 백트래킹
*/

import java.io.*;
import java.util.*;

public class Main {
    static int n, max=Integer.MIN_VALUE, min = Integer.MAX_VALUE; //정답값 초기화
    static int[] num, op; //숫자와 연산자배열
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        num = new int[n];
        op = new int[4];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
                num[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }


        recur(num[0], 1); //숫자 하나를 넣고 시작함, 왜냐하면 0으로 시작하면 if(cnt==0)이면 sum+=num[0]이런식으로 해야하는데 귀찮아서
        System.out.println(max);
        System.out.println(min);
    }

    static void recur(int sum, int cnt) {
        if (cnt == n) { //cnt==n일때 return
            max = Math.max(sum, max);
            min = Math.min(sum, min);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (op[i] > 0) { //0이 아닐때만 보도록 가지치기
                if (i == 0) {
                    op[i]--;
                    recur(sum + num[cnt], cnt + 1);
                    op[i]++;

                } else if (i == 1) {
                    op[i]--;
                    recur(sum - num[cnt], cnt + 1);
                    op[i]++;

                } else if (i == 2) {
                    op[i]--;
                    recur(sum * num[cnt], cnt + 1);
                    op[i]++;

                } else {
                    op[i]--;
                    recur(sum / num[cnt], cnt + 1);
                    op[i]++;
                }
            }
        }
    }
}
