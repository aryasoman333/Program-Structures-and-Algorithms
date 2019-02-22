package com.algo.finalTerm;

/**
 * @author Arya Soman
 *Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island
is surrounded by water and is formed by connecting adjacent lands horizontally or
vertically. You may assume all four edges of the grid are all surrounded by water.
 */

public class Solution1 
{
	public int numIslands(char[][] grid)
	{
		if(grid.length==0) 
			return 0;
		int count=0;
		int rowVal = grid.length;
		int colVal =grid[0].length;
		boolean[][] visited = new boolean[rowVal][colVal];
		for(int i=0 ; i < rowVal ; i++)
		{
			for(int j=0 ; j < colVal ; j++)
			{
				if(grid[i][j] == '1' && !visited[i][j])
				{
					depthFirstSearch(grid,i,j,visited);
					count++;
				}
			}
		}
		return count;
	}
	public void depthFirstSearch(char[][]grid, int row, int col, boolean[][]visited)
	{
		int [] neighbouringRow = {-1,1,0,0};
		int [] neighbouringCol = {0,0,-1,1};
		visited[row][col]=true;
		for(int k=0;k<4;k++)
		{
			if(isSafe(grid,row+neighbouringRow[k],col+neighbouringCol[k],visited))
			{
				depthFirstSearch(grid,row+neighbouringRow[k],col+neighbouringCol[k],visited);
			}
		}
	}
	public boolean isSafe(char[][]grid, int row, int col, boolean[][]visited)
	{
		return (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col]=='1' && !visited[row][col]);
	}

	public static void main (String[] args) 
	{ 
		char grid[][]=  new char[][] {{'1', '1', '0', '1', '0'}, 
			{'0', '1', '1', '0', '0'}};
			Solution1 sol = new Solution1(); 
			System.out.println("Number of islands = "+ sol.numIslands(grid)); 
	} 
}

