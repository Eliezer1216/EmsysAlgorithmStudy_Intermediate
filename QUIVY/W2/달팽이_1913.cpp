//배운점: 코드 더 생각하면서 짜기 - 무작정 코드부터 짜니 더 어려움, 생각을 좀더 하면서

#include<iostream>
using namespace std;

//   round(array, side size, starting point)
void round(int arr[][999], int n, int start){      
    int i=n*n, x=start, y=start;
    
    //add n-1 amount of numbers to each side

    for(int j=0; j<n-1; j++, i--, y++)  //left 
        arr[x][y]=i;
    
    for(int j=0; j<n-1; j++, i--, x++)  //bottom
        arr[x][y]=i;

    for(int j=n-1; j>0; j--, i--, y--)  //right
        arr[x][y]=i;
    
    for(int j=n-1; j>0; j--, i--, x--) //top
        arr[x][y]=i;   
}

int main(){
    int N, find[3];     //size, find[0(target num), 1(x coor), 2(y coor)]
    int arr[999][999]={1, };    //array

    //input
    cin >> N;
    cin >> find[0];

    // create array
    for(int i=N, j=0; i>0; i-=2, j++){
        if(i==1)
            arr[N/2][N/2]=1;
        else
        round(arr, i, j);
    }

    //print array
    for(int x=0; x<N; x++){
        for(int y=0; y<N; y++){
            cout << arr[y][x] << ' ';
            if(arr[y][x]==find[0])      //search for find[0]
                find[1]=y+1, find[2]=x+1;
        }
        cout << endl;
    }
    //print coor
    cout << find[2] << ' ' << find[1];
}