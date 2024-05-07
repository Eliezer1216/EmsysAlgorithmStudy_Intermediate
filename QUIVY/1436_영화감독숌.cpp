/*
N 번째로 작은, 666을 포함한 숫자
1666 2666 3666 4666 5666 6666 6661 6662 6663 6664 6665 6666 6667 6668 6669 7666 8666 9666
1   2       3   4   5       6   7   8   9   10      11  12  13      14  15  16  17      18

*/

#include<iostream>


using std::cin;
using std::cout;
using std::endl;

int main(){
    int N, r=665, c=0;
    
    cin >> N;
    for(int i=665; N; i++){ //N이 0될때까지
        for(int t=i, c=0; t; t/=10){
            //cout << "checkin : " << t%10 << c << endl;
            if(t%10==6){//r에 666이 포함?
                c++;
            }
            else c=0;
    
            if(c==3){  // c=3 ? N-- & r에 숫자 저장
                r=i;
                N--;
            }
        }
    }

    cout << r << endl;
}