/*나의 풀이 - 신효민
   풀이 방법 : 밑 주석 참고
   주의점 : 배열의 인덱스 범위를 넘어가지 않게 초기에 n의 범위를 구분해준다!!
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

	static int [][] map; // 파스칼의 삼각형을 표현할 2차원 배열
	static int n,k; 
	public static void main(String []args) throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		k=Integer.parseInt(st.nextToken());
		
		if(n==1) 
		{
			System.out.println(1);
		}
		else if(n==2)
		{
			System.out.println(1);
		}
		else if(n>2)
		{
			map=new int[n][n];
			// 초기에 값들을 밑처럼 세팅해줘야 점화식 사용 가능
			map[0][0]=1;
			map[1][0]=1;
			map[1][1]=1;
			
			for(int i=2;i<n;i++)
			{
				for(int j=0;j<i+1;j++)
				{
					if(j==0||j==i) // 제일 바깥변들은 1로 채워준다.
					{
						map[i][j]=1;
						continue;
					}
					map[i][j]=map[i-1][j-1]+map[i-1][j]; // 값들을 채워준다.
					
				}
			}
			
			System.out.println(map[n-1][k-1]); // 결과값 출력
		}
		
	}
 
}
