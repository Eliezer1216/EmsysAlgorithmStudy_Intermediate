/*
<vicinity>
asdf -> (a1==b1 || a2==b2)
asdf 1: +3      abs(a1 - b1) = 1 || abs(a2 - b2) = 1
asdf 2: +2      abs(a1 - b1) = 2 || abs(a2 - b2) = 2
asdf 3: move

dia 1: +2
dia 2: move
dia 3:

-------------------
# 3 2 3 #
3 2 1 2 3
2 1 K 1 2
3 2 1 2 3
# 3 2 3 #
-------------------

exceptions: direct corner diagonals: +4 - if prior move exists +2

maximum moves untill vicinity trigger is 4

other branch might be more effecient
exception: (+3, +1) needs preset
*/

#include<iostream>
#include<cmath>

using std::cin;
using std::cout;
using std::endl;

bool vicinity(int x1, int x2, int y1, int y2){
    int a, b;
    a=((x1>y1)?(x1-y1):(y1-x1)), b=((x2>y2)?(x2-y2):(y2-x2));

    if( a<3 && b<3){
        if( !(a==2 && b==2) )
            return false;
        else
            return true;
    }
    else
        return true;
}
int cornerCheck(int a1, int a2, int b1, int b2){
    //corner exceptions require fidelity
    //direct corner exception - 8 different cases, 16 different coord
    // (1,1 - 2,2) (7,7-8,8) (1,8 - 2,7) (8,1 - 7,2) and reversed
    if( (a1==1 && a2==1 && b1==2 && b2==2) || (a1==2 && a2==2 && b1==1 && b2==1) )
        return 1;
    else if( (a1==7 && a2==7 && b1==8 && b2==8) || (a1==8 && a2==8 && b1==7 && b2==7) )
        return 1;
    else if( (a1==1 && a2==8 && b1==2 && b2==7) || (a1==2 && a2==7 && b1==1 && b2==8) )
        return 1;
    else if( (a1==8 && a2==1 && b1==7 && b2==2) || (a1==7 && a2==2 && b1==8 && b2==1) )
        return 1;
    else
        return 0;

}


int main(){
    //(1)starting position -> (2)final position -> (3)final move
    int a1, a2, b1, b2, c=0;

    //(1)starting position
    cin >> a1 >> a2 >> b1 >> b2;
    
    //(2)check vicinity -> move to final position
    while(vicinity(a1, a2, b1, b2) && c<4){
        if( abs(a1-b1) > abs(a2-b2) ){
            a1+= (a1-b1>0)?-2:2;
            a2+= (a2-b2>0)?-1:1;
        }
        else{
            a1+= (a1-b1>0)?-1:1;
            a2+= (a2-b2>0)?-2:2;
        }
        cout << a1 << " " << a2 << endl;
    }

    //(3)final move
/*  # 3 2 3 #
    3 2 1 2 3
    2 1 K 1 2
    3 2 1 2 3
    # 3 2 3 #       */

    int t = abs(a1-b1) + abs(a2-b2);    //simplify final position for easier comparison
    if(t == 3)      //direct capture
        c++;
    else if(t==2){  //2 move capture
        if( cornerCheck(a1, a2, b1, b2) ){ //check for corner exception
            c+=4;
        }
        else    //asdf 2
            c+=2;
    }
    else if(t==1){  //3 move capture
        if(c>0) //prior move allows for optimization
            c+=4;
        else
            c+=3;
    }
    cout << c << endl;
}