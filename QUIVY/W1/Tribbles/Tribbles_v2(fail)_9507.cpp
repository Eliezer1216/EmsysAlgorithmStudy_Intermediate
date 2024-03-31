#include <iostream>
using namespace std;

long long koong(int n){
    int temp=0;
    if(n<2)
        return 1;
    else if(n==2)
        return 2;
    else if(n==3)
        return 4;
    else{
        for(int i=4; i<=n; i++)
        temp = koong(n-1)+koong(n-2)+koong(n-3)+koong(n-4);

        return temp;
    }
}

int main(void){
    int t, max=0;       //테스트 케이스의 개수
    int arr[100]={0, }; //테스트 케이스 값
    

    cin >> t;                   //테스트 케이스 개수 입력

    for(int i=0; i<t; i++){     //테스트 케이스 입력
        cin >> arr[i];
        if(max<arr[i])
            max=arr[i];
    }

    for(int i=0; i<t; i++)                  //테스트 케이스 출력
        cout << koong(arr[i]) << endl;      //재귀를 위해서 함수화
    
}