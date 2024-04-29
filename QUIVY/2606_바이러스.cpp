#include<iostream>
using namespace std;

#define MAX 101

bool network[MAX][MAX] = {false};     //graph
bool visited[MAX] = {false};        //visited
int queue[MAX];                     //queue (BFS)
int front =0, rear=0; 

void bfs(int start, int nodeCount){
    queue[rear++]=start;        // start is input into queue (queue begin) (& rear+=1)
    visited[start]=true;        // mark start as visited


    //adds element in next layer to queue - goes through queue looking for elements in next layer
    while(front!=rear){         // until queue is empty(= all nodes visited) : front = rear
        int node = queue[front++];  // node = queue[front] -> front++(element in queue has been processed)
        
        
        // finds unvisited elements connected to node (i) and adds to queue
        for(int i=1; i<=nodeCount; ++i)     //loop until nodeCount has been depleted
            if(network[node][i] && !visited[i]){  // if node and i is connected & i not visited
                visited[i]=true;                // mark i as visited
                queue[rear++]=i;                // insert i into last in queue
            }
    }
}

int main(){
  int coms=0, cons=0, a, b;
  

  //input
  cin >> coms >> cons;
  for(int i=0; i<cons; i++){
    cin >> a >> b;
    network[a][b]=1;
    network[b][a]=1;
  }

  //bfs -> rear 는 연결된 컴퓨터 갯수
  bfs(1, coms);


  cout << --rear;
}