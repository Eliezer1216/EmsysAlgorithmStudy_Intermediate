/*
-> 재귀로 풀었다가 시간초과로 dp로 해결
   시간이 적게 주어질 시 dp로 해결해야함을 깨달음
   파스칼 법칙 이용
*/

import java.io.*;
import java.util.*;

public class Main {

    static int[][]arr; //앞의 결과를 저장할 배열

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); //테스트케이스

        for (int i = 0; i < T; i++) {
            int n = sc.nextInt(); //시작
            int m = sc.nextInt(); //도착
            arr = new int[m+1][n+1];

            for (int k = 1; k < m+1; k++) {
                for (int j = 1; j < n+1; j++) {
                    arr[k][j] = 0; //초기화
                }
            }

            for (int k = 1; k < m+1; k++) {
                for (int j = 1; j < n+1; j++) {
                    arr[k][j] = PASCAL(k, j); //파스칼 법칙 적용
                }
            }
            System.out.println(arr[m][n]);
        }
    }

    static int PASCAL(int m, int n) { //mCn
        if (n == 1&&m!=0) { //m이 0이 아니고 n이 1일시 m
            return m;
        } else if (n == 0 || m == n) { // n이 0이거나 m=n이면 1
            return 1;
        } else if (n != 0 && m == 0) { // n이 0 이 아닌데 m이 0일 시 0
            return 0;
        }

        return arr[m - 1][n]+arr[m - 1][n - 1]; //mCn=m-1Cn-1+m-1Cn
    }

}
