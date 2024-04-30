//last two result links are +1 each???
//runtime error : Out of Bounds

#include<iostream>
using namespace std;

#define MAX 101
int friendship[MAX][MAX]={false};
int visited[MAX]={false};
int link;

//dfs: number of levels
int level(int node, int target){
    visited[node]=true;
    link++;                 // Increment link count when visiting a node
    
    if(node==target)
        return link;
    
    for(int i=0; i<=MAX; i++) {
        if(friendship[node][i] && !visited[i]) {
            int result = level(i, target);
            if(result != -1) // If target found in child nodes, return the result
                return result;
        }
    }
    
    visited[node]=false; // Backtrack: Mark node as unvisited
    link--;              // Decrement link count when backtracking
    return -1;           // Return -1 to indicate target not found
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

    //calculate all depths
    a=1, b=MAX;
    int sum=0;
    for(int i=1; i<=N; i++, sum=0){
        //cout << "checking: " << i<< endl;
        for(int j=1; j<=N; j++){
            if(i!=j){
                for(int k=1; k<=N; k++) // Reset visited array for each new pair (i, j)
                    visited[k] = false;
                link=-1;
                int result = level(i, j);
                //cout << j << ": " << result << endl;
                sum += result;
            }
        }
        if(sum<b){      //save if sum is smaller than previous
            a=i, b=sum;
        }
        //cout << " = " << sum << endl;
    }

    //output
    cout << a;

}
