/*
-> dp..
-> 1. 입력 받을 배열과 합을 추가할 배열을 만들고 
   2. dp를 사용함
      (맨 가쪽의 합은 한 가지 케이스만 나와 비교할 필요가 없으나 중간에 값들은 
      arr[y-1][x-1]+arr[y][x], arr[y-1][x]+arr[y][x] 의 두가지 케이스가 나와서 더 큰값을 배열에 넣어야함)
*/

import java.io.*;
import java.util.*;

public class Main {

    static int[][] arr; //입력받을 배열
    static int[][] ans; //합을 넣을 배열

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); //n
        arr = new int[n+1][n+1]; //초기화
        ans= new int[n+1][n+1]; //초기화
        int max = 0; //정답, 가장큰값

        for (int i = 1; i < n+1; i++) { //배열입력
            String[] split = br.readLine().split(" ");
            for (int j = 1; j < i+1; j++) {
                arr[i][j]= Integer.parseInt(split[j-1]);
            }
        }

        for (int i = 1; i < n+1; i++) { //삼각형 모양으로 dp실행
            for (int j = 1; j < i+1; j++) {
                DFS(i, j); //dfs인줄 알고 풀었는데 dfs 아니었음..

            }
        }

        for (int i = 1; i <= n; i++) {
            if (ans[n][i] > max) {
                max = ans[5][n]; //가장 마지막줄에서 가장 큰 값을 추출
            }
        }

        System.out.println(max);

    }

    static void DFS(int y, int x) {
        if (y == 1 && x == 1) {
            ans[1][1] = arr[1][1]; //첫 값은 대입
        } else {
            if (x == 1) { //가장 왼쪽 합은 위에 것만 더할 수 있음
                ans[y][x] = ans[y - 1][x] + arr[y][x];
            } else if (x == y) { //가장 오른쪽의 합은 왼쪽 대각선 값만 더할 수 있음
                ans[y][x] = ans[y - 1][x-1] + arr[y][x];
            } else { /*
                      끝 값말고는 항상 두가지 케이스가 나옴
                      하나는 왼쪽 위 대각선에서 오른쪽 대각선을 더한 값, 다른 하나는 위에서 밑에 값을 더한 값.
                      아래 수식을 보면 이해가 쉬울 것임.
                     */
                if (ans[y - 1][x - 1] > ans[y - 1][x]) {
                    ans[y][x] = ans[y - 1][x - 1] + arr[y][x];
                } else {
                    ans[y][x] = ans[y - 1][x] + arr[y][x];
                }
            }
        }
    }


}
