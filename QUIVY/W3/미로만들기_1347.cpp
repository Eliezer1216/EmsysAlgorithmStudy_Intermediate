#include<iostream>
using namespace std;
#define CENTER 50;
//아래를 보면서 시작
int main(){
    char maze[101][101]={0, };
    int inputNum, direction=3;
    int lowx=50, lowy=50, highx=50, highy=50; //parameter of maze
    int x=50, y=50;
    //dir       1/5=top
    //  2=left          4=right
    //          3=bottom

    //starting point
    maze[x][y]='.';

    //input data
    cin >> inputNum;
    string line;
    cin >> line;

    for(int i=0; i<inputNum; i++){
        
        if(line[i]=='F'){           // if F
            if(direction==3){       //bottom
                ++x;
                if(x>highx) highx++;
            }
            else if(direction==2){   //left
                --y;
                if(y<lowy) lowy--;
            }
            else if(direction==4){   //right
                ++y;
                if(y>highy) highy++;
            }
            else{                   //top
                --x;
                if(x<lowx) lowx--;
            }
            maze[x][y]='.';            
        }
        else if(line[i]=='R'){      // if R
            if(direction==1)
                direction=4;
            else
                direction--;
        }
        else{                       // if L
            if(direction==5)
                direction=2;
            else
                direction++;
        }
    
        //fill excess with #
        for(int a=lowx; a<=highx; a++){
            for(int b=lowy; b<=highy; b++)
                if(maze[a][b]!='.')
                    maze[a][b]='#';
        }

        /*//debug
        cout << line[i] << ' ' << direction << endl;
        cout << "current: " << x << ' ' << y <<endl;
        cout << lowx << " to " << highx <<endl<<lowy <<" to " << highy<<endl;
        for(int a=lowx; a<=highx; a++){
            for(int b=lowy; b<=highy; b++)
                cout << maze[a][b];
            cout << endl;
        }
        cout << endl;
        */
        
    }

    for(int a=lowx; a<=highx; a++){
        for(int b=lowy; b<=highy; b++)
                cout << maze[a][b];
        cout << endl;
    }

}

//boundary setting
