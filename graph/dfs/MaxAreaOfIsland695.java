import java.util.LinkedList;
import java.util.Queue;

public class MaxAreaOfIsland695 {
    public static int dfs(int[][] grid, int[] node, boolean[][] visited, int ans)
    {
        visited[node[0]][node[1]] = true;
        int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};
        int rows = grid.length;
        int cols = grid[0].length;
        for(int[] dir : directions)
        {
            int x = node[0] + dir[0];
            int y = node[1] + dir[1];
            if(x >= 0 && x < rows && y >= 0 && y < cols && !visited[x][y] && grid[x][y] == 1)
            {
                 ans = dfs(grid, new int[]{x,y}, visited, ans + 1);
            }
        }
        return ans;
    }
    public static int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int area = 0;
        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < cols; j++)
            {
                if(!visited[i][j] && grid[i][j] == 1)
                {
                    area = Math.max(area, dfs(grid, new int[]{i, j}, visited, 1));
                }
            }
        }
        return area;
    }
    public static void main(String args[])
    {
        int[][] grid = {
                    {0,0,1,0,0,0,0,1,0,0,0,0,0},
                    {0,0,0,0,0,0,0,1,1,1,0,0,0},
                    {0,1,1,0,1,0,0,0,0,0,0,0,0},
                    {0,1,0,0,1,1,0,0,1,0,1,0,0},
                    {0,1,0,0,1,1,0,0,1,1,1,0,0},
                    {0,0,0,0,0,0,0,0,0,0,1,0,0},
                    {0,0,0,0,0,0,0,1,1,1,0,0,0},
                    {0,0,0,0,0,0,0,1,1,0,0,0,0}};

        System.out.println(maxAreaOfIsland(grid));
    }
}
