#include <iostream>
using namespace std;

int main(void){
    int t, max=0;                       //테스트 케이스의 개수, 입력 최댓값(시간절약)
    int arr[100]={0, };                 //테스트 케이스 값
    long long koong[70]={1, 1, 2, 4, };

    cin >> t;                           //테스트 케이스 개수 입력

    for(int i=0; i<t; i++){             //테스트 케이스 입력
        cin >> arr[i];
        if(max<arr[i])
            max=arr[i];                 //테스트 케이스 최댓값 저장
    }

    for(int i=4; i<=max; i++){          //꿍의 피보나치 계산 (아래 -> 위)
        koong[i]=koong[i-1] + koong[i-2] + koong[i-3] + koong[i-4];
    }
    
    for(int i=0; i<t; i++)              //테스트 케이스 출력
        cout << koong[arr[i]] << endl;    
}

//재귀 함수 시도 하려고 했으나 시간 초과 오류가 걸림 + 새로움 입력 마다 함수를 처음부터 다시 계산해햐하는 번거로움
// -> 입력 최댓값을 미리 구해놔 최댓값까지의 꿍을 미리 계산 - 반복되는 계산 방지
