#include <iostream>
using namespace std;

int main()
{
    int n;
    cin>> n;

    int scale= 0;
    for(int i= 1; i<= n; i++) scale+= i;

    int result[n];
    cin>> result[0];
    int temp[n];

    for(int i= 1; i< n; i++)
    {
        cin>> temp[0];
        temp[0]+= result[0];

        for(int j= 1; j< i; j++)
        {
            cin>> temp[j];
            if(result[j- 1]> result[j]) temp[j]+= result[j- 1];
            else temp[j]+= result[j];
        }

        cin>> temp[i];
        temp[i]+= result[i- 1];

        for(int j= 0; j<= i; j++) result[j]= temp[j];
    }

    for(int i= 1; i< n; i++) if(result[0]< result[i]) result[0]= result[i];

    cout<< result[0];
}

/*
    DP(메모이제이션)
*/
