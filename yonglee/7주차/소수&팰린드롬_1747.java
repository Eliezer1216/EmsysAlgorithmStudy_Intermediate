/*
-> 에라토스네스의체, 팰린드롬 판별문제
*/

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = n;


        while (true) {
            if (cnt == 1) { //1은 소수가 아니기때문에
                System.out.println(2);
                break;
            }
            if (isPrime(cnt)&&isPalindrom(cnt)) { //소수이고 팰린드롬일때
                System.out.println(cnt);
                break;
            }
            cnt++;
        }
    }

    static boolean isPrime(int n) { //에라토스테네스의 체로 거름
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    static boolean isPalindrom(int n) {
        char[] arr = Integer.toString(n).toCharArray(); //int형을 char배열로 바꿔 맨앞-맨뒤에서 한칸씩 이동시켜 값비교
        for (int i = 0; i <= arr.length/2 ; i++) {
            if (arr[i] != arr[arr.length - i - 1]) {
                return false;
            }
        }
        return true;
    }
}
