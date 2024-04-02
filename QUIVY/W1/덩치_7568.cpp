#include <iostream>
using namespace std;

int main(){
    int N, g=1;                 //크기 변수, 등수 변수(5로 선언)
    int x[2][51]={0, };         //몸무게, 키 배열 선언

    cin >> N;                   //크기 변수 입력
    for(int i=0; i<N; i++){     //몸무게 & 키 변수 입력 반복문
        cin >> x[0][i];         
        cin >> x[1][i];
    }

    for(int i=0; i<N; i++, g=1){    //드수 구하기 모든 함수 비교할수 있게 반복문
        for(int j=0; j<N; j++)
            if( (x[0][i]<x[0][j]) && (x[1][i]<x[1][j]) )
                g++;        //몸무게 & 키 둘다 비교하는 변수보다 크면 등수 ++
                            //중복 등수를 가능케 하기 위해 모두 비교하기
                
        cout << g << ' ';   //등수 출력
    }

}