//백준 정답처리가 안됨? 테스트 케이스 탐색 필요

#include <iostream>
using namespace std;

int main(void){

    //VARIABLES

    int size=0, boom=0;             //입력 크기, 폭발(지뢰개방) 확인
    char mine[11][11]={0, };        //지뢰 위치
    char open[11][11]={0, };        //개방 위치

    //INPUT

    //(1): 입력 크기: 10보다 작은 수 
    //(2): 지뢰 위치 (nxn 크기): 입력은 *(지뢰) 아니면 .(not)
    //(3): 개방 위치 (nxn 크기): 입력은 X(개방) 아니면 .(not)

    cin >> size;                    //(1) 입력 크기
    for(int x=0; x<size; x++)       //(2) 지뢰 위치
        for(int y=0; y<size; y++)
            cin >> mine[x][y];
    for(int x=0; x<size; x++)       //(3) 개방 위치
        for(int y=0; y<size; y++){
            cin >> open[x][y];
            if(mine[x][y]=='*' && open[x][y] == 'X')     //지뢰 개방 -> boom!=0
                boom++;
        }
    
    //OUTPUT

    for(int x=0; x<size; x++){
        for(int y=0, tick=0; y<size; y++, tick=0){  //모든 출력 반복문 + 지뢰 갯수 함수 tick & 리셋

            //출력: (1)지뢰가 있을때(그리고 boom!=0) > (2)X일때 > (3)미개방

            if(boom!=0 && mine[x][y]=='*')          //(1) boom!=0 & 개방 -> *표시
                    cout << "*";
            else if(open[x][y] == 'X'){             //(2)X일때
                //확인해야할 좌표
                //(x-1, y-1) (x, y-1) (x+1, y-1)
                //(x-1, y) (x, y) (x+1, y)
                //(x-1, y+1) (x, y+1) (x+1, y+1)
                for(int a=x-1; a<x+2; a++)
                    for(int b=y-1; b<y+2; b++)      //현재 위치(a, b) 둘러싸는 9*9 확인
                        if(mine[a][b]=='*')         //지뢰 있으면 tick++ 확인
                            tick++;
                cout << tick;                       //else 지뢰수 출력
            }            
            else cout <<'.';                        //(3)미개방이면 . 출력
        }
        cout << endl;
    }    
}

//attempt 1 : 지뢰 있는 칸은 *로 표시 추가
//attempt 2 : 지뢰가 있는 칸이 열렸다면 지뢰가 있는 모든 지뢰 공개 추가 **조건 재대로 읽기**
//attempt 3 : 지뢰 출력을 if조건 밖으로
//attempt 4 : boom!=0 이면 모든 출력이 * 오류 수정
