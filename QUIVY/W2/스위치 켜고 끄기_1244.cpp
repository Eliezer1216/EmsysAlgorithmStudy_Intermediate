//남학생 번호: 받은 수의 배수 스위치를 바꿈; 3 -> 3, 6, 9...
//여학생 번호: 대칭수를 바꿈(비대칭이 나오때 까지)

//배운것 (1 <--> 0 ) -> XOR operator ' ^ '  ; i = 1 ^ i; / i^=1;

#include<iostream>
using namespace std;

void malelight(int num, int size, int arr[]){
    for(int i=num-1; i<size; i+=num)
        arr[i]^=1;
}

void femlight (int num, int size, int arr[]){
    num--;
    arr[num]^=1;
    for(int i=1; (num + i < size) && (num - i >= 0); i++)   //for 안에 종료 조건 여러개 넣기
        if( ( arr[num+i] != arr[num-i]) )
            break;
        else
            arr[num+i]^=1, arr[num-i]^=1;
}

int main(void){
    int lin, stu, gen, num; //스위치 갯수, 학생수
    int lights[100]={0, };  //스위치 상태, 학생 정보 입력

    cin >> lin;                     //스위치 갯수 입력
    for(int i=0; i<lin; i++)        //스위치 정보 입력
        cin >> lights[i];
    
    cin >> stu;                     //학생수 입력
    for(int i=0; i<stu; i++){       //학생 정보 입력
        cin >> gen >> num;
        if(gen==1)                  //성별에 따른 계산
            malelight(num, lin, lights);
        else
            femlight(num, lin, lights);   
    }
    
    for(int i=0; i<lin; i++){           //스위치 출력
        cout << lights[i] << ' ';
        if((i+1)%20 == 0)
            cout << endl;
    }
}

//오류: 남자 계산 num+=num 는 제곱식으로 됨
//attempt 2 : output ; new line every 20 numbers