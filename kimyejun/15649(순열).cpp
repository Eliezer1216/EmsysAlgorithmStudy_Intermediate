#include <iostream>
#include <vector>
using namespace std;

int n, m;
bool visited[9];
vector<int> output;

void comb(int depth)
{
    if(depth== m)
    {
        for(auto i: output) cout<< i<< ' ';
        cout<< '\n';
    }
    else
    {
        for(int i= 1; i<= n; i++)
        {
            if(visited[i]== false)
            {
                visited[i]= true;
                output.push_back(i);
                comb(depth+ 1);
                visited[i]= false;
                output.pop_back();
            }
        }
    }
}

int main()
{
    cin>> n>> m;
    comb(0);
}