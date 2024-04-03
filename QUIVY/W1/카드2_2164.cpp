//종이에 직접 계산해보기
// 만약 남은 숫자 갯수가 짝수일시 홀수 번째 숫자가 모두 없앰
// 만약 남은 숫자 갯수가 홀수일시 홀수 번째 숫자가 모두 없앤다음 맨 앞숫자를 뒤로 보내기
// 배열 크기가 1이 될때까지 반복

#include <iostream>
using namespace std;

void test(int arr[]){
    cout << arr[0] << " : ";
    for(int i=1; i<=arr[0]; i++)
        cout << arr[i] << ' ';
    cout << endl;
}

void back(int arr[]){
    arr[arr[0]+1]=arr[1];
    for(int i=1; i<=arr[0]; i++)
        arr[i]=arr[i+1];
}

void half(int arr[]){
    for(int i=1; i<=arr[0]; i++)
        arr[i]=arr[i*2];
    arr[0]/=2;
    
}

int main(){
    int N=1, g=1;                 //크기 변수, 등수 변수(5로 선언)
    int x[500100]={0, };         //몸무게, 키 배열 선언

    cin >> x[0];
    
    while( (x[0]%2) == 0 ){     //미리 2 로 최대한 나눠보기
        x[0]/=2;
        N*=2;
    }

    for(int i=1; i<=x[0]; i++)      //배열에 숫자 입력
        x[i]=i*N;    

    while(x[0]!=1){                 //크기(x[0])=1이 될때까지 계속 나누기 & 반복
        if(x[0]%2==0)               //짝수인 경우 홀수번째 수들 없애기
            half(x);
        else{
            half(x);                //홀수인 경우 홀수번째 수 없애고  
            back(x);                //맨 앞에 숫자 뒤로 보내기   
        }
    }
    cout << x[1];    
}

//오류1: i = 0 (배열 크기)에 영향을 주는 배열이 있었음
//오류2: 숫자를 뒤로 보내기(back)을 두번 중복하게 됬음 -> 기존에 있던 clean 함수 없애기
//오류3: 런타임 에러(insufficient space) -> 배열 크기 늘리기