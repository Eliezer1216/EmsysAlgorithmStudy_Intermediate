/*
-> 별찍기 구현
*/
import java.util.*;
import java.io.*;

public class Main {

    static char[][] myarr;
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = sc.nextInt();
        int sqt = (int)Math.pow(5, n);
        myarr = new char[sqt+1][sqt+1];

        for (int i = 1; i <= sqt; i += 1) {
            for (int j = 1; j <= sqt; j += 1) {
                myarr[i][j]=' ';
            }
        }

        if (n == 0) { //0일때 그냥 별 출력
            System.out.println("*"); 
        } else { //아니면 재귀
            star(n,1,1);
        }

        for (int i = 1; i < sqt+1; i += 1) { //큰 출력값때문에 버퍼라이터 사용
            for (int j = 1; j < sqt+1; j += 1) {
                bw.write(myarr[i][j]);
            }
            bw.write('\n');
        }

        bw.close();

    }

    public static void star(int n,int x,int y) {

        int p = (int)Math.pow(5, n-1); //n이 1일시 p는 5, n이 2일시 

        if (n == 0) { //n이 0일때
            myarr[y][x] = '*'; //중심값에 별찍기
        } else { //별모양 대로 별 중심값 좌표를 다음 재귀로 넘김
        // 따라서 처음엔 star(n,x,y)였던 것이 12개씩 늘어나서 12^n승으로 바뀌면서 마지막에 n이0일때 별만 찍음
            star(n - 1, 2*p+x, y);
            star(n - 1, 2*p+x, p+y);
            star(n - 1, x, 2*p+y);
            star(n - 1, p+x, 2*p+y);
            star(n - 1, 2*p+x, 2*p+y);
            star(n - 1, 3*p+x, 2*p+y);
            star(n - 1, 4*p+x, 2*p+y);
            star(n - 1, p+x, 3*p+y);
            star(n - 1, 2*p+x, 3*p+y);
            star(n - 1, 3*p+x, 3*p+y);
            star(n - 1, p+x, 4*p+y);
            star(n - 1, 3*p+x, 4*p+y);
        }

    }
}
