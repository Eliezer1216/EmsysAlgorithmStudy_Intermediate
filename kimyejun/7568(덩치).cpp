#include<iostream>
using namespace std;

struct person
{ // 
    int weight;
    int tall;
};

int main()
{
    int n;
    cin>> n;

    person input[n];

    for(int i= 0; i< n; i++) cin>> input[i].tall>> input[i].weight;

    int result[n]= {0};

    for(int i= 0; i< n; i++)
    {
        for(int j= 0; j< n; j++)
        {
            if(input[j].tall> input[i].tall)
            {
                if(input[j].weight> input[i].weight)
                result[i]++;
            }
        }
    }
    for(int i= 0; i< n; i++) cout<< result[i]+ 1<< ' ';
}

// 브루트 포스 알고리즘으로 노가다 비교