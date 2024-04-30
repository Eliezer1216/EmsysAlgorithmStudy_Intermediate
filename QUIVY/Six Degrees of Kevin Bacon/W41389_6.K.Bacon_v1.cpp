//use dfs to find target number -> level = connections
#include<iostream>
using namespace std;

#define MAX 5001
int friendship[MAX][MAX]={false};
int visited[MAX]={false};
int link;

//dfs: number of levels
int level(int node, int target){
    visited[node]=true;
    link++;                 //problem: need to subtract when backtrack
    
    if(node==target)
        return link;
    
    for(int i=1; i<=MAX; i++)
        if(friendship[node][i] && !visited[i])
            return level(i, target); // Add return statement here
    
    return link-1; // Return a default value if target is not found
}

int main(){
    int N, M;       //N: people, M: connections

    //input
    cin >> N >> M;
    int a, b;
    for(int i=0; i<M; i++){
        cin >> a >> b;
        friendship[a][b]={true};
        friendship[b][a]={true};
    }

    //input check
    /*
    for(int i=1; i<=M; i++){
        cout << i << " : ";
        for(int j=1; j<=M; j++)
            cout << friendship[i][j] << " ";
        cout << endl;
    }
    */

    
    //calculate all depths
    a=1, b=M;
    int sum=0;
    for(int i=1; i<=N; i++, sum=0){
        cout << "checking: " << i<< endl;
        for(int j=1; j<=N; j++){
            if(i!=j){
                visited[MAX]={false};
                link=0;
                cout << j << ": " << level(i, j);
                sum+=level(i, j);
                cout << " = " << sum<< endl;
            }
        }
        if(sum<b){      //save if sum is smaller than previous
            a=i, b=sum;
        }
        cout << " = " << sum << endl;
    }

    //output
    cout << b;

}
