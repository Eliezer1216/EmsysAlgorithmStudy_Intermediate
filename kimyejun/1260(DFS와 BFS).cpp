#include <iostream>
#include <vector>
#include <queue>
using namespace std;

int graph[1001][1001];
queue <int> search;
bool visited_dfs[1001];
bool visited_bfs[1001];
int com, node, start;

void dfs(int now) {
    for(int i= 1; i<= com; i++) {
        if(graph[now][i]== 1 && visited_dfs[i]== false) {
            visited_dfs[i]= true;
            cout<< i<< ' ';
            dfs(i);
        }
    }
}

void bfs() {
    int temp1;
    int temp2;
    while(!search.empty()) {
        temp1= search.size();
        while(temp1--) {
            temp2= search.front();
            search.pop();
            for(int i= 1; i<= com; i++) {
                if(graph[temp2][i]== 1 && visited_bfs[i]== false) {
                    visited_bfs[i]= true;
                    cout<< i<< ' ';
                    search.push(i);
                }
            }
        }
    }
}

int main() {
    cin>> com>> node>> start;

    int a, b;
    for(int i= 0; i< node; i++) {
        cin>> a>> b;
        graph[a][b]= 1;
        graph[b][a]= 1;
    }

    cout<< start<< ' ';
    visited_dfs[start]= true;
    dfs(start);

    cout<< '\n';

    cout<< start<< ' ';
    visited_bfs[start]= true;
    search.push(start);
    bfs();
}