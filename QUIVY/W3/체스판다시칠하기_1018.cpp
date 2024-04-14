#include<iostream>
using namespace std;

char board1[8][8];
char board2[8][8];

void mockboard(){
    for(int i=0; i<8; i++)
        for(int j=0; j<8; j+=2)
            if(i%2==0){
                board1[i][j]='W';
                board1[i][j+1]='B';
                board2[i][j]='B';
                board2[i][j+1]='W';
            }
            else{
                board1[i][j]='B';
                board1[i][j+1]='W';
                board2[i][j]='W';
                board2[i][j+1]='B';
            }      
}

int compareboard(char main[][51], int x, int y){
    int count1=0, count2=0;
    for(int i=0; i<8; i++)
        for(int j=0; j<8; j++){
            if(main[x+i][y+j]!=board1[i][j])
                count1++;
            if(main[x+i][y+j]!=board2[i][j])
                count2++;
        }
    return min(count1, count2);
}

int main(){
    int N, M, change=64;
    char main[51][51];
    
    cin >> N >> M;              //input N M

    //create mock board1
    mockboard();

    for(int i=0; i<N; i++)      //input board
        for(int j=0; j<M; j++)
            cin >> main[i][j];

    for(int i=0; i<=N-8; i++){       //compare with mock
        for(int j=0; j<=M-8; j++){
            change = min(change, compareboard(main, i, j));
        }
    }
    
    cout << change;
    
}