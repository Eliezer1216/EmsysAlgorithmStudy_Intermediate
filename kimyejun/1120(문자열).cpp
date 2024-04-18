#include <iostream>
using namespace std;

int main()
{
    string input[2];
    cin>> input[0]>> input[1];
    int output= 0;

    if(input[0].length()== input[1].length())
    {
        for(int i= 0; i< input[0].length(); i++)
        {
            if(input[0][i]!= input[1][i]) output++;
        }
        cout<< output;
        return 0;
    }
    else
    {
        int size= input[1].length()- input[0].length();
        int diff[size+ 1]= {0};
        for(int i= 0; i<= size; i++)
        {
            for(int j= 0; j< input[0].length(); j++)
            {
                if(input[0][j]!= input[1][j+i]) diff[i]++;
            }
        }

        int result= diff[0];
        for(int i= 1; i<= size; i++)
            if(result> diff[i]) result= diff[i];

        cout<< result;
    }
}