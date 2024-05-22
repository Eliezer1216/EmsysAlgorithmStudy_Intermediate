/*
-> 최소공배수, 최대공약수 문제
-> 최대공약수는 유클리드 호제법에 따라 구했고, 최소공배수는 a*b/최대공약수를 나누는 값이 된다.
*/
import java.io.*;
import java.util.*;

public class baek1934 {
    static boolean[] prime;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            System.out.println(a*b/lcd(Math.max(a, b),Math.min(a, b))); //a*b/최대공약수이므로
        }
    }

    static int lcd(int a, int b) { //b가 0이 아닐때까지 r을 a%b를 반복해서 마지막 a값이 최대공약수가 된다.
        while (b != 0) {
            int r = a % b;

            a = b;
            b = r;
        }
        return a;
    }
}
