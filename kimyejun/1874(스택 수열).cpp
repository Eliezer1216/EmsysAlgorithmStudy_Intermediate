#include <iostream>
using namespace std;

int main()
{
	int n;
	cin>> n;

	int input[n];
	for(int i= 0; i< n; i++) cin>> input[i];

	int stack[n]= {1}; // stack
	int stackLocation= 0;
	int inputNum= 1;

	char output[2*n+1999999]; // output
	output[0]= '+';
	int outputCount= 1;

	for(int i= 0; i< n; i++)
	{
		while(input[i]> inputNum)
		{
			inputNum++;
			stackLocation++;
			stack[stackLocation]= inputNum; // push

			output[outputCount]= '+';
			outputCount++;
		}
		if(input[i]!= stack[stackLocation])
		{
			cout<< "NO";
			return 0;
		}
		stack[stackLocation]= 0; // pop
		stackLocation--;

		output[outputCount]= '-';
		outputCount++;
	}

	for(int i= 0; i< outputCount; i++) cout<< output[i]<< '\n';

	return 0;
}