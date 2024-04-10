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
bool graph[MAX][MAX] = {false};
bool visited[MAX] = {false};

//정점: nodes   간선: edge

int checklower(int arr[][500], int i){         // check branches below current one and if any positive return true
    int count=0;
    for(int j=0; arr[i][j]==0; j++)
        if(arr[i][j]>0)
            return false;
    return true;

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
    //use stack to track history: if visit -> turn to negative
    for(int x=0, y=0; ;)            // x is element, y is elements under x
        

        cout << "checking element: " << N[x][y] << endl;
        if (N[x][y]>0){             // if element(N[][]) hasn't been visited(>0)
            cout << "unvisited" << endl;
            N[x][y] *= -1;          // mark visit
            x=N[x][y]*(-1);         // go to element

            cout << "added to stack" << endl;
            base[ss]=x;        // add element to stack
            ss++;

            if(checklower(N, x)){             // if no lower branches (or no positive lower branches) print element
                cout << N[x][y] << ' ';
            }
            
        }
        else if(N[x][y]==0){        // if element = 0 ; no more element
            ss--;                   // go back one stack and retrieve element
            if(ss==0){
                cout << "error";
                break;
            }
            x=base[ss];
        }
        else                        // if element has been visited go to next element
            y++;

    //BFS
    /*
    for(int i=0; i<edge; i++)
        cout << N[0][1];
    */

}
