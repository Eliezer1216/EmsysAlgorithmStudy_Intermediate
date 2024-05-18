/*나의 풀이 -신효민
 	자세한 풀이는 주석 참고
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main
{
	static int N,M,B; // N -> 세로 , M -> 가로 , B -> 초기에 인벤토리에 있는 블록 갯수
	static int [][] minecraft; // 마인크래프트 맵
	static ArrayList<Result>result_list; // 결과 리스트
	public static void main(String []args) throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		B=Integer.parseInt(st.nextToken());
		minecraft=new int[N][M]; // 마인크래프트 맵 생성
		result_list=new ArrayList<>();
		
		for(int i=0;i<N;i++) // 맵에 값 넣기
		{
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0;j<M;j++)
			{
				int num=Integer.parseInt(st.nextToken());
				minecraft[i][j]=num;
			}
		}
		
		for(int a=0;a<=256;a++) // 브루트포스 , a는 목표 높이 ( a는 음수 x , 256을 초과하면 안된다.)
		{
			int inventory=0; // 작업을 다 수행하고 나서의 인벤토리에 있는 블록 갯수
			int time=0; // 걸린 시간
			for(int i=0;i<N;i++)
			{
				for(int j=0;j<M;j++)
				{
					if(a<minecraft[i][j]) // 목표 높이보다 현재 맵에 있는 높이가 더 높다면
					{
						/* 1번 작업 ( 가장 위에 있는 블록을 제거하여 인벤토리에 넣는다.)
						    -> 땅 고르기 작업을 한다.-> 시간 2초 걸림*/
						inventory+=(minecraft[i][j]-a); // 인벤토리에 넣어지는 블록 갯수
						time+=2*(minecraft[i][j]-a); // 시간 계산
					}
					else if(a>minecraft[i][j]) // 목표높이보다 현재 맵에 있는 높이가 더 낮다면
					{
						/* 2번 작업 ( 인벤토리에서 블록 하나를 꺼내어 좌표의 가장 위에 있는 블록 위에 놓는다.
						 	-> 시간 1초 걸림
						 */
						inventory+=minecraft[i][j]-a; // 인벤토리에서 빠지는 블록 갯수 -> 마이너스 값을 더함
						time+=a-minecraft[i][j]; // 시간 계산
					}
					
				}
			}
			
			/* 다 수행하고 나서의 인벤토리에 있는 블록 갯수는 
			 초기에 인벤토리에 있던 블록 갯수 + 작업을 수행하면서의 총 블록 유동량을 더해주면 된다.*/
			inventory=inventory+B; 
			
			// 인벤토리에 있는 블록 갯수가 마이너스이면 안된다.
			if(inventory>=0)
			{
				result_list.add(new Result(time,a));
			}
		}
		
		// 가장 최소시간이면서 땅의 높이가 가장 높은 것을 구하기 위해 객체 정렬
		Collections.sort(result_list); 
		
		// 결과값 출력
		System.out.println(result_list.get(0).time+" "+result_list.get(0).height);
		
	}
	
}


// 객체정렬을 위해 Comparable 구현
class Result implements Comparable<Result>
{
	int time; // 시간
	int height; // 높이
	
	// 생성자
	Result(int time,int height)
	{
		this.time=time;
		this.height=height;
	}
	@Override
	public int compareTo(Result o) {
		
		if(this.time==o.time) // 시간이 같다면
		{
			return o.height-this.height; 
		}
		return this.time-o.time;
	}
	
}
