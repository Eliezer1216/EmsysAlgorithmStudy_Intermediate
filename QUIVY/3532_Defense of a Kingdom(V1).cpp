#include<iostream>
using std::cin;
using std::cout;
using std::endl;
#define MAX 40000

int sort(int arr[][2], int n, int a){
    int temp;
    for(int i=0; i<n; i++){
        for(int j=0; j<n; j++){
            if(arr[i][a] < arr[j][a]){
                temp = arr[i][a];
                arr[i][a] = arr[j][a];
                arr[j][a] = temp;
            }
        }
    }
    return 0;
}

int main(){
    //변수 선언
    int w, h, n, x, y;  //w: 가로, h: 세로, n: 점의 개수, x: 가로 최대 길이, y: 세로 최대 길이
    int coord[MAX][2] = {0};    //점의 좌표
    //입력
    cin >> w >> h >> n;
    for(int i=0; i<n; i++){
        cin >> coord[i][0] >> coord[i][1];
    }
    //작은 순으로 정렬
    sort(coord, n, 0);
    sort(coord, n, 1);
    //초기값 설정
    x=coord[0][0]-1;
    y=coord[0][1]-1;
    
    //최대 길이 구하기
    for(int i=1; i<n; i++){
        if(coord[i][0] - coord[i-1][0]-1 > x){
            x = coord[i][0] - coord[i-1][0]-1;
        }
    }
    if(w - coord[n-1][0]-1 > x)
            x = w - coord[n-1][0]-1;

    //세로 최대 길이 구하기
    for(int i=1; i<n; i++){
        if(coord[i][1] - coord[i-1][1]-1 > y){
            y = coord[i][1] - coord[i-1][1]-1;
        }
    }
    if(h - coord[n-1][1]-1 > y)
            y = h - coord[n-1][1]-1;

    if(n==0){       //n=0
        cout << w*h << endl;
    }
    else cout << x*y << endl;
    return 0;
    
}
//12%에서 틀림