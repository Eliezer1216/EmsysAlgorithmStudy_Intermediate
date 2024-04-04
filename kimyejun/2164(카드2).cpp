#include <iostream>
using namespace std;

int main()
{
    int n;
    cin>> n;

    int dec[2* n];          // 큐로 사용할 배열

    for(int i= 1; i<= n; i++) dec[i- 1]= i;

    int fLocation= 0;       // 큐 배열의 앞 부분을 가리키는 변수
    int lLocation= n- 1;    // 큐 배열의 뒷 부분을 가리키는 변수

    for(int i= 0; i< n- 1; i++)
    { // 앞 부분을 없애고, 그 다음 요소를 배열의 제일 뒤로 이동
        dec[fLocation++]= 0;
        dec[++lLocation]= dec[fLocation];
        dec[fLocation++]= 0;
    }

    cout<< dec[lLocation]; // 큐의 남은 제일 뒷 부분 데이터 출력
}

/*
    사용할 수 있는 최대 배열을 만들고
    큐 처럼 배열의 첫 부분을 제거한 후 그 다음 부분을 배열의 제일 뒤로 이동
*/