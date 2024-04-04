// 00 아니면 1으로 구분
// (1): 모든 경우의 수를 구한 다음에 안되는 경우 구분하기? - 모든 경우의 수 = 2^N; - 너무 많음
// (2): 2a(00)+b(1)=N -> N 에서 (00)의 개수를 뺀 뒤 (=M) -> M^2

// input 4 -
// (2 * 2) + (1 * 0) = 4        0000        :1
// (2 * 1) + (1 * 2) = 4  0011 1001 1100    :3
// (2 * 0) + (1 * 4) = 4        1111        :1

#include <iostream>
using namespace std;

int var(int i, int j){      //경우의 수
    int c=1;
    for(int a=1; a<=j; a++)    //제곱함수
        c*=(i+1);
    return c;
}   

int main(){
    int N, count=0;     //크기 N, 타일 순서
    cin >> N;           //N 입력

    // i는 1 타일, j는 00 타일
    for(int i=N; i>=0; i--)
        for(int j=0; j<=(N/2); j++){
            if((i+2*j)==N){
                count+=var(i, j);
                cout << j << "*2 + " << i << "*1 = N -> cases :" << var(i, j) << endl;
                break;
            }
        }
    cout << count;
}

//오류 1: 시간초과 -> 제곱함수 없애기