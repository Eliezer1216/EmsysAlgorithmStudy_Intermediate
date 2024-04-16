/*
못풀어서 doit 참고
-> 정수론문제
   에라토스테네스의 체를 사용해 소수를 구하고
   
*/

import java.io.*;
import java.util.*;

public class baek1456 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();

        long[] A = new long[1000001]; //10^14까지 범위이므로 제곱근인 10^7까지만 사용
        int cnt = 0;

        for (int i = 2; i < A.length; i++) {
            A[i] = i; //초기값으로 값 그대로 대입
        }

        for (int i = 2; i <= Math.sqrt(A.length); i++) {
            if (A[i] == 0) {
                continue; //소수일 시 패스
            }
            for (int j = i + i; j < A.length; j +=i) {
                A[j] = 0; //소수가 아닐 시 0값 입력
            }
        }

        for (int i = 2; i < 1000001; i++) {
            if (A[i] != 0) { //소수일 시에
                long temp = A[i]; //temp에 값 대입
                while ((double) A[i] <= (double) b / (double) temp) { // => A[i]*temp<=b
                    if ((double) A[i] >= (double) a / (double) temp) {// => A[i]*temp>=a
                        cnt++;
                    }
                    temp *= A[i];
                }
            }
        }
        System.out.println(cnt);
    }


}
