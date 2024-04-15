/*
-> 구현문제
-> 시작 후 위로 한번 오른쪽 한번, 아래쪽 2번, 왼쪽 2번 후
-> 위쪽 1+2번, 오른쪽 1+2번, 아래쪽 2+2번, 왼쪽 2+2번의 패턴으로 이동하며 숫자대입
*/
import java.io.*;
import java.util.*;

public class baek1913 {

    static int[][] arr; //배열
    static int findx; //찾는 x값
    static int findy; //찾는 y값
    static int cnt=1; // 숫자
    static int n;


    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder(); //시스템아웃 사용시 시간초과

        n = sc.nextInt();
        int p = sc.nextInt();

        arr = new int[n+1][n+1];

        if (n == 1) {
            System.out.println(1); //1일시 1출력
        } else if (n == 2) {
            BFS(1, 1, 2, p); //2일 시 초기값 지정
        } else {
            BFS(1, n / 2 + 1, n / 2 + 1, p);
        }


        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                sb.append(arr[i][j]);
                sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
        System.out.println(findy+" "+findx);
    }

    static void BFS(int depth, int x, int y,int find) {
        for (int i = 0; i < depth; i++) { 
            if (find == cnt) {
                findx = x;
                findy = y;
            }
            arr[y--][x] = cnt++;
            if (cnt == n * n+1) {
                return;
            }
        }
        for (int i = 0; i < depth; i++) {
            if (find == cnt) {
                findx = x;
                findy = y;
            }
            arr[y][x++] = cnt++;
        }for (int i = 0; i < depth+1; i++) {
            if (find == cnt) {
                findx = x;
                findy = y;
            }

            arr[y++][x] = cnt++;
        }for (int i = 0; i < depth+1; i++) {
            if (find == cnt) {
                findx = x;
                findy = y;
            }
            if (cnt == n * n+1) { //cnt가 n^2 값을 넘을 시 종료
                return;
            }
            arr[y][x--] = cnt++;
        }

        BFS(depth + 2, x, y,find);

    }
}
