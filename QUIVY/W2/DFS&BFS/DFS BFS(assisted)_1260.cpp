/*
            [[[ BFS ]]]
        Breadth First Search

-Uses *Queue data structure* for finding the shortest path
-Is a traversal approach in which we first walk through all
  nodes on the same level before moving onto the next level
  (floor(/level) by floor traversal)
-FIFO approach
-usage: searching vertices *closer* to the given source
-application: bipartite, graphs, shortest paths, etc

        A
       / \
      B   C       -->     A, B, C, D, E, F
     /   / \
    D   E   F
visualization: https://upload.wikimedia.org/wikipedia/commons/5/5d/Breadth-First-Search-Algorithm.gif

            [[[ DFS ]]]
        Depth First Search

-Uses *Stack data structure*
-Is a traversal approach in which traverse begins at root node and
  proceeds through the nodes as far as possible until there are no
  unvisited nearby nodes
  (branch(/subtree) by branch traversal)
-LIFO approach
-usage: searching solution away from source
-application: acyclic grapsh, find strongly connected components

        A
       / \
      B   D      -->    A, B, C, D, E, F
     /   / \
    C   E   F
visualization: https://upload.wikimedia.org/wikipedia/commons/7/7f/Depth-First-Search.gif

source: https://www.geeksforgeeks.org/bfs-vs-dfs-binary-tree/
        https://www.geeksforgeeks.org/difference-between-bfs-and-dfs/
*/

#include<iostream>
using namespace std;

#define MAX 1001
//bool is used for T/F values, int is value
bool graph[MAX][MAX] = {false};     //graph
bool visited[MAX] = {false};        //visited
int queue[MAX];                     //queue (BFS)
int front =0, rear=0;               //queue front and rear index(BFS)

//정점: nodes   간선: edge

//void doesn't return value
void dfs(int node, int nodeCount){
    visited[node]= true;        // mark starting node as visited
    cout << node << " ";        // print node

    for(int i=1; i<=nodeCount; ++i){    // loop until all nodes have been printed
        if(graph[node][i] && !visited[i])  // if node and i is connceted, and i has not been visited 
            dfs(i, nodeCount);          // recursion with different start(unvisited node is next start)
    }                                   // if untrue or unvisited then next loop
}

void bfs(int start, int nodeCount){
    queue[rear++]=start;        // start is input into queue (queue begin) (& rear+=1)
    visited[start]=true;        // mark start as visited


    //adds element in next layer to queue - goes through queue looking for elements in next layer
    while(front!=rear){         // until queue is empty(= all nodes visited) : front = rear
        int node = queue[front++];  // node = queue[front] -> front++(element in queue has been processed)
        cout << node << " ";        // print node
        
        // finds unvisited elements connected to node (i) and adds to queue
        for(int i=1; i<=nodeCount; ++i)     //loop until nodeCount has been depleted
            if(graph[node][i] && !visited[i]){  // if node and i is connected & i not visited
                visited[i]=true;                // mark i as visited
                queue[rear++]=i;                // insert i into last in queue
            }
    }
}

int main(){
    int node, edge, start;
    cin >> node >> edge >> start;

    // input edge
    // if a is connected to b -> graph[a][b] is true
    for(int i=0; i<edge; ++i){
        int a, b;
        cin >> a >> b;
        graph[a][b]=true;       // connect a to b
        graph[b][a]=true;       //two way?
    }

    //DFS
    // function used for recursion
    dfs(start, node);
    cout << endl;

    //BFS
    bfs(start, node);
}
