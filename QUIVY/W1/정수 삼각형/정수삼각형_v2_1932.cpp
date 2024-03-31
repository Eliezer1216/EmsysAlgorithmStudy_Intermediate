#include <iostream>
using namespace std;

int main(void){
    int n=0, res=0;                 //크기 변수, 결과 변수
    int tri[501][510]={0, };        //삼각형 배열 변수
    int max[501][501]={0, };

    cin >> n;                       //삼각형의 크기
    for(int i=1; i<=n; i++)
        for(int j=1; j<=i; j++)
            cin >> tri[i][j];       //값 입력

    for(int i=1; i<=n; i++){
        for(int j=1; j<=i; j++){    //위 각 대각선에서 코드 비교해서 더 큰 수 받아서 max 배열에 저장
            max[i][j]+= (tri[i][j] + ( (max[i-1][j]>max[i-1][j-1]) ? max[i-1][j] : max[i-1][j-1] ) );
            res = ((max[i][j]>res) ? max[i][j] : res);  //현대 줄에서 가장 큰 수 저장
        }
        
    }
    
    cout << res;                    //가장 큰 수 출력
}