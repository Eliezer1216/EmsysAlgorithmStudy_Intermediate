#include<stdio.h>
using namespace std;

int main(){
    int N, score, Players, rank=1;      // 변수 // N : 입력하는 점수, score : 입력하는 점수, Players : 올라가는 점수 갯수, rank : 등수
    int scoreBoard;                     //         scoreBoard : 입력 받는 점수 갯수
    scanf("%d %d %d", &N, &score, &Players);       // N, score, Players 입력 받음

    for(int i=0; i<N; i++){             // 입력 N개 받을때 까지 반복
        scanf("%d", &scoreBoard);              // scoreBoard 입력 받기

        if(N<Players){              // 만약 표시할수 있는 점수가 N개 보다 많다 = 표시할 자리가 있다
            if(score<scoreBoard)        // 입력 받은 점수가 score 보다 크면 rank++ (만약 같은 숫자를 만날시 그 숫자랑 등수가 동일함)
                rank++;
        }
        else{                       // 만약 표시할수 있는 점수가 N개 보다 적거나 같다 = 표시할 자리가 없다
            if(score<=scoreBoard)       // 입력 받은 점수가 score 보다 크면 rank++ (만약 같은 숫자를 만날시 같은 숫자 중 가장 순위가 낮음)
                rank++;
        }
    }

    if(rank<=Players)       // 만약 등수 < 표시할수 있는 수 : 등수 표시
        printf("%d", rank);
    else                    // 아닐시 -1 표시
        printf("-1");
}