/*나의 풀이 - 신효민
    주석 참고 -> 순수 구현 문제
    // 헤멘 이유 -> 전역 변수와 지역변수의 변수명을 똑같이 쓰면 컴퓨터 입장에서 어떤 값으로 계산할지 몰라 잘못된 값이 나온다!! -> 매우 조심하자!!
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main
{
	static int N,M; // N -> 세로 , M -> 가로
	static int r,c; // 처음에 로봇 청소기가 있는 좌표 ( r,c )
	static int [][] room; // 방
	
	//상하좌우 탐색을 위한 배열
	static int []dx= {-1,1,0,0};
	static int []dy= {0,0,1,-1};
	static int result; // 청소한 칸  총 갯수 출력
	public static void main(String []args) throws IOException
	{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		room=new int[N][M]; // 방 생성
		st=new StringTokenizer(br.readLine()," ");
		r=Integer.parseInt(st.nextToken());
		c=Integer.parseInt(st.nextToken());
		int direction=Integer.parseInt(st.nextToken());
		
		for(int i=0;i<N;i++) // 방에 값 입력하기
		{
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0;j<M;j++)
			{
				room[i][j]=Integer.parseInt(st.nextToken()); 
			}
		}
		CleanRoom(r,c,direction); // 청소 시작
		
	}
	
	// 청소 함수
	static void CleanRoom(int x,int y,int direction)
	{
		if(room[x][y]==0) // 현재 칸이 청소되지 않은 경우 , 현재 칸 청소
		{
			result++; // 청소한 칸 총 갯수 +1;
			room[x][y]=2; // 청소한 칸은 청소완료 표시로 2 저장
		}
		for(int i=0;i<4;i++) // 상하좌우 탐색
		{
			int a=x+dx[i];
			int b=y+dy[i];
			if(a>=0&&a<N&&b>=0&&b<M)
			{
				if(room[a][b]==0) // 상하좌우 중 청소하지 않은 칸이 있는 경우
				{
					ChangeMode(x,y,direction); // 함수 호출 ( 밑에서 자세한 함수 설명 )
					break; // 꼭 써줘야 한다. 바로 이동하기 때문에
				}
			}
		}
		
		goBack(x,y,direction); // 상하좌우 중 청소하지 않은 칸이 없는 경우 -> 후진 함수 호출 ( 밑에서 자세한 함수 설명 )
		
		
	}
	
	
	static void ChangeMode(int x,int y, int direction)
	{
		int a=x; 
		int b=y;
		
		// 반시계 방향으로 90도 회전
		switch(direction)
		{
		case 0:
			direction=3;
			b=b-1;
			break;
		case 1:
			direction=0;
			a=a-1;
			break;
		case 2:
			direction=1;
			b=b+1;
			break;
		case 3:
			direction=2;
			a=a+1;
			break;
		}
		
		if(a>=0&&a<N&&b>=0&&b<M) // 좌표를 벗어나지 않는다면
		{
			if(room[a][b]==0) // 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈칸인 경우
			{
				// 한칸 전진 후 청소 시작
				CleanRoom(a,b,direction);
			}
			else
			{
				// 다시 호출
				ChangeMode(x,y,direction);
			}
		}
		else
		{
			// 좌표를 벗어났다면 -> 다시 호출
			ChangeMode(x,y,direction);
		}
		
	}
	
	// 후진 함수 호출
	static void goBack(int x,int y,int direction)
	{
		
		int a=x;
		int b=y;
		
		switch(direction)
		{
		case 0:
			a=a+1;
			break;
		case 1:
			b=b-1;
			break;
		case 2:
			a=a-1;
			break;
		case 3:
			b=b+1;
			break;
		}
		
		if(a>=0&&a<N&&b>=0&&b<M) // 좌표를 벗어나지 않았다면
		{
			// 바라보는 방향을 유지한 채로 한 칸 후진 할수 있다면
			if(room[a][b]!=1) // 벽이 아닌 경우
			{
				// 한칸 후진하고 청소 시작
				CleanRoom(a,b,direction);
			}
			else if(room[a][b]==1) // 한칸 후진했을때 벽일 경우
			{
				System.out.println(result); // 청소한 칸 총 갯수 출력
				System.exit(0); // 작동 멈춤
			}
		}
		
	}
	
	
}
