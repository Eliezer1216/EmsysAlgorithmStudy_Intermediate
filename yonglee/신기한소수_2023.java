/*
-> dfs, 백트래킹
-> 1. 소수배열을 돌리면서 DFS
-> 2. DFS에 들어가면 홀수 배열을 반복하며 소수판별 알고리즘을 통해 백트래킹
-> 3. 깊이가 T일 시 리턴하며 멈춤
*/

import java.io.*;
import java.util.*;

public class Main {

    static int T; //깊이
    static int[] holsu = {1, 3, 7, 9}; //홀수 배열

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        int[] sosu = {2, 3, 5, 7}; //소수 배열

        for (int i = 0; i < 4; i++) {
            DFS(sosu[i],1); //소수 배열을 루프 돌리면서 반복문
        }
    }

    static void DFS(int n, int depth) {
        if (depth == T) { //깊이가 T일 시 출력하고 리턴
            System.out.println(n);
            return;
        }

        for (int k = 0; k < 4; k++) { //홀수 배열을 반복하면서
            int num=n * 10 + holsu[k]; //맨 뒷자리에 숫자 추가
            if (isPrime(num) != 0) {소수이면 DFS
                DFS(num, depth + 1);
            }
        }
    }

    static int isPrime(int n) { //소수판별
        for (int i = 2; i<=(int)Math.sqrt(n); i++) {
            if (n % i == 0) {
                return 0;
            }
        }
        return 1;
    }
}
