#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int minimumMoves(vector<string> grid, int x1, int y1, int x2, int y2) {
  vector<int> g[100002];
  int n = grid.size();
  for(int i = 0 ; i < n ; i++) {
    for(int j = 0 ; j < n; j++) {
      if(grid[i][j] == '.') {
        int cur = i * n + j;
        for(int k = i - 1; k >= 0; k--) {
          if(grid[k][j] == '.') {
            int now = k*n + j;
            g[cur].push_back(now);
          }
          else
            break;
        }

        for(int k = i+1; k < n; k++) {
          if(grid[k][j] == '.') {
            int now = k*n + j;
            g[cur].push_back(now);
          }
          else
            break;
        }

        for(int k = j-1; k >= 0; k--) {
          if(grid[i][k] == '.')
          {
            int now = i*n + k;
            g[cur].push_back(now);
          }
          else
            break;
        }

        for(int k = j+1; k < n; k++) {
          if(grid[i][k] == '.') {
            int now = i * n + k;
            g[cur].push_back(now);
          }
          else
            break;
        }
      }
    }
  }

  int start_pos = x1*n + y1;
  int done[10001] = {0}, dis[10001] = {0};
  queue<int> q;
  q.push(start_pos);
  done[start_pos] = 1;
  while(!q.empty()) {
    int now = q.front();
    q.pop();
    for(int i = 0 ; i < g[now].size(); i++) {
      int nxt = g[now][i];
      if(!done[nxt]) {
        done[nxt] = 1;
        dis[nxt] = dis[now]+1;
        q.push(nxt);
      }
    }
  }

  return dis[x2*n + y2];
}