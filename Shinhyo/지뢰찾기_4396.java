/*나의 풀이 -신효민 */
/* 풀이과정 : 상하좌우대각선 방향으로 다 탐색해서 그 배열의 값에 숫자를 업데이트해준다. 
 틀렸던 이유 -> 문제를 잘못 이해함.
    어디서부터 게임을 시작하는지에 대해서 정해져있지 않기 때문에 지뢰를 밟았더라도 'x' 표시에 따라서 주변에 지뢰가 몇개있는지는 다 표시해야함.
*/
import java.util.Scanner;

public class Main {

    static char [][] map; // 맵
    static char [][] test; // 게임할때의 배열
    static char [][]result; // 결과 값을 저장하는 배열
    static int []dx={-1,0,0,1,-1,-1,1,1}; // 상하좌우 대각선 다 살펴보기 위한 값
    static int []dy={0,-1,1,0,-1,1,1,-1}; // 상하좌우 대각선 다 살펴보기 위한 값
    static int n;
    static boolean flag; // 지뢰를 밟았을때
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        map=new char[n][n];
        test=new char[n][n];
        result=new char[n][n];

        // 맵 입력
        for(int i=0;i<n;i++) {
            String s = sc.next();
            for (int j = 0; j < n; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        // 게임 실행했을때
        for(int i=0;i<n;i++) {
            String s = sc.next();
            for (int j = 0; j < n; j++) {
                test[i][j] = s.charAt(j);
            }
        }

        // 숫자 업데이트를 위함
        for(int i=0;i<n;i++) {
            for (int j= 0; j < n; j++) {
                if(test[i][j]=='x'&& map[i][j]=='*')
                {
                   flag=true;
                }
                else if(test[i][j]=='x' && map[i][j]=='.')
                {
                    result[i][j]='0';
                    find_mine(i,j);
                }
                else {
                    result[i][j]='.';
                }
            }
        }

        if(flag) // 지뢰를 밟았을때
        {
            for(int i=0;i<n;i++) {
                for (int j = 0; j < n; j++) {
                    if(map[i][j]=='*') 
                    {
                        result[i][j]='*'; // 남아있는 지뢰표시
                    }
                    if(map[i][j]=='.'&&!(Character.getNumericValue(result[i][j])>=0))
                    {
                        result[i][j]='.';  // 숫자가 아니면서 온점 부분은 온점으로 표시
                    }
                }
            }

            //결과값 출력
            for(int i=0;i<n;i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(result[i][j]);
                }
                System.out.println();
            }
        }
        else
        {
            // 지뢰를 밟지 않았을때 결과 표시
            for(int i=0;i<n;i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(result[i][j]);
                }
                System.out.println();
            }
        }
    }

    // 지뢰가 몇개인지 알려주는 함수 -> 숫자 업데이트
    static void find_mine(int i,int j)
    {
        for(int k=0;k<8;k++) // 상하좌우 대각선 다 탐색
        {
            int x=i+dx[k];
            int y=j+dy[k];
            if(x>=0&&y>=0&&x<n&&y<n)
            {
                if(map[x][y]=='*') // 상하좌우 대각선에 지뢰가 있을때
                {
                    int num=Character.getNumericValue(result[i][j]);
                    num=num+1;
                    result[i][j]=Integer.toString(num).charAt(0); // 업데이트
                }
            }
        }
    }

}

