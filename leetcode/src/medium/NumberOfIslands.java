package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NumberOfIslands {


    private class Coordination {
        int x;
        int y;
        public Coordination(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int numIslands(char[][] grid) {
        // bfs technique
        // m = grid.length;
        // n = grid[0].length;

        // 1. Traverse the grid using nested for-loop from (0,0) to (m-1, n-1).
        // 2. When we encounter a cell with value '1' that has not been visited:
        // - start a BFS from that cell
        // - use a queue to explore all connected land cells (up, down, left, right).
        // - mark each visited cell to avoid reprocessing
        // 3. Every time we finish a full BFS traversal, it represents one island
        // 4. Increment the island count after each BFS
        // 5. return the total count of islands

        // - ensure the new (x,y) coordinates are within the bounds:
        // x >=0 && x < m
        // y >=0 && y < n

        // Interview
        // I'm using BFS to find the number of islands in the grid.
        // I loop through every cell and start BFS when I encounter an unvisited land ('1').
        // During BFS, I mark all connected land cells as visited, so I don't count the same island twice.
        // I use a queue to traverse in 4 directions, and increment the island count for each BFS start.

        Queue<Coordination> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        boolean[][] visited = new boolean[m][n];

        int[] rowDir = {-1, 0, 1, 0};
        int[] colDir = {0, 1, 0, -1};

        for(int i = 0; i < m; i++) {
            for(int j = 0; j<n;j++) {
                if(grid[i][j] == '1' && !visited[i][j]) {

                    q.add(new Coordination(i,j));
                    visited[i][j] = true;
                    // bfs
                    while(!q.isEmpty()) {

                        Coordination coord = q.poll();

                        for(int h = 0; h<4;h++) {
                            int x = coord.x + rowDir[h];
                            int y = coord.y + colDir[h];

                            if(x >= 0 && x < m && y >=0 && y < n && !visited[x][y] && grid[x][y] == '1') {
                                visited[x][y] = true;
                                q.add(new Coordination(x,y));
                            }
                        }

                    }
                    count++;
                }
            }
        }

        return count;
    }

    // public void countIsland(int x, int y, char[][] grid) {
    //     Queue<Coodination> queue = new LinkedList<>();

    //     visited[x][y] = true;
    //     queue.add(new Coodination(x,y));

    //     while(!queue.isEmpty()) {
    //         int size = queue.size();
    //         for(int i = 0; i < size; i++) {
    //             Coodination coodination = queue.poll();
    //             visited[coodination.x][coodination.y] = true;
    //             for(Coodination c : findNeigbours(coodination, grid)) {
    //                 if(visited[c.x][c.y]) continue;
    //                 visited[c.x][c.y] = true;
    //                 queue.add(new Coodination(c.x, c.y));
    //             }
    //         }
    //     }
    // }
}
