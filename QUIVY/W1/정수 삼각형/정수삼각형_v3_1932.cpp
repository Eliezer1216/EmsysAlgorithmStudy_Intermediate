//v2와 방법은 일치하나 하나의 반복문 안에서 모두 해결을 함

//v2와 차이: 약 4ms 더 오래 걸리나 코드 길이는 95b 차이가 남

#include <iostream>
using namespace std;

int main(void){
    int n=0, res=0;             //삼각형의 크기 변수 선언
    int tri[501][510]={0, };      //삼각형 배열 변수
    int max[501][501]={0, };

    cin >> n;               //삼각형의 크기
    for(int i=1; i<=n; i++)
        for(int j=1; j<=i; j++){
        cin >> tri[i][j];

        max[i][j]+= (tri[i][j] + ( (max[i-1][j]>max[i-1][j-1]) ? max[i-1][j] : max[i-1][j-1] ) );
            res = ((max[i][j]>res) ? max[i][j] : res);
        }    

  
    
    cout << res;
}