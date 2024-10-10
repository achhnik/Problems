import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges994 {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<int []>();
        int freshOranges = 0;
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(grid[i][j] == 1) freshOranges++;
                if(grid[i][j] == 2)
                {
                    q.offer(new int[]{i, j, 0});
                }
            }
        }

        if(freshOranges == 0)
            return 0;

        int mins = -1;
        int[][] directions = {{-1,0},{0,-1},{1,0},{0,1}};
        while(!q.isEmpty())
        {
            int[] rottenOrange = q.poll();
            for(int j = 0; j < directions.length; j++)
            {
                int x  = rottenOrange[0] + directions[j][0];
                int y =  rottenOrange[1] + directions[j][1];
                if(x >= 0 && x < m && y>=0 && y < n &&  grid[x][y] == 1)
                {
                    q.offer(new int[]{x, y, rottenOrange[2] + 1});
                    grid[x][y] = 2;
                    freshOranges--;
                    mins = Math.max(mins, rottenOrange[2] + 1);
                }
            }
        }

        return freshOranges == 0 ? mins : -1;
    }
}
