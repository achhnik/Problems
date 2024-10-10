public class NoOfIslands200 {
    public static int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int noOfIslands = 0;
        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < cols; j++)
            {
                if(grid[i][j] == '1')
                {
                    noOfIslands++;
                    dfs(i, j, grid, visited);
                    break;
                }
            }
            if(noOfIslands > 0) break;
        }

        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < cols; j++)
            {
                if(!visited[i][j] && grid[i][j] == '1')
                {
                    noOfIslands++;
                    dfs(i, j, grid, visited);
                }
            }
        }
        return noOfIslands;
    }
    public static void dfs(int i, int j, char[][] grid,boolean[][] visited)
    {
        visited[i][j] = true;
        int[][] directions = {{-1,0},{0,-1},{1,0},{0,1}};
        for(int[] dir: directions)
        {
            int x = i + dir[0];
            int y = j + dir[1];
            if(x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && visited[x][y] == false && grid[x][y] == '1')
                dfs(x, y, grid, visited);
        }
    }

    public static void main(String args[])
    {
        char[][] grid = {
                          {'1', '1', '0', '0', '0'},
                          {'1', '1', '0', '0', '0'},
                          {'0', '0', '1', '0', '0'},
                          {'0', '0', '0', '1', '1'}
                        };
        System.out.println(numIslands(grid));
    }
}
