#include<iostream>
#include<algorithm>
using namespace std;

int main(){
    int w, h, n;  //w: width, h: height, n: number of points
    cin >> w >> h >> n;

    int x, y; // Arrays to store x and y coordinates

    int x1=0, x2=w, y1=0, y2=h;
    int smallx=w, bigx=0, smally=h, bigy=0;

    for(int i=0; i<n; i++){
        cin >> x >> y;

        // Find minimum and maximum x and y coordinates
        smallx = min(smallx, x);
        bigx = max(bigx, x);
        smally = min(smally, y);
        bigy = max(bigy, y);

        if(x1 < x && x < x2)
            if(x-x1 < x2-x)
                x1 = x;
            else
                x2 = x;
        if(y1 < y && y < y2)
            if(y-y1 < y2-y)
                y1 = y;
            else
                y2 = y;           
    }

    x = max(x2-x1-1, max(smallx-1, w-bigx));
    y = max(y2-y1-1, max(smally-1, h-bigy));
    // Calculate maximum distance
    cout << x*y << endl;
    return 0;
}