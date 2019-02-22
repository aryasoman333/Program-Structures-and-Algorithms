package com.algo.finalTerm;

/**
 * @author Arya Soman
 *Given a “2 x n” board and tiles of size “2 x 1”, count the number of ways to tile the given
board using the 2 x 1 tiles. A tile can either be placed horizontally i.e., as a 1 x 2 tile or
vertically i.e., as 2 x 1 tile.

 *Solution using recursion, tabulization and memoization
 */

import java.util.HashMap;
import java.util.Map;

public class Solution3 
{
	//recursive solution
	
	public int numberOfWaysToTileRecursive ( int boardColumns ) 
	{
		if( boardColumns <= 2)
			return boardColumns;

		return numberOfWaysToTileRecursive(boardColumns-1) + numberOfWaysToTileRecursive(boardColumns-2);
	}

	//tabulize solution

	public int numberOfWaysToTileTabulize(int boardColumns)
	{
		if(boardColumns <= 2)
			return boardColumns;
		int[] array = new int[boardColumns+1];
		array[0] = 0;
		array[1] = 1;
		array[2] = 2;
		for(int i = 3; i <= boardColumns; i++)
		{
			array[i] = array[i-1] + array[i-2];
		}
		return array[boardColumns];
	}

	//memoize solution
	
	public int numberOfWaysToTileMemoize(int boardColumns)
	{
		if(boardColumns <= 2)
			return boardColumns;
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 0);
		map.put(1, 1);
		map.put(2, 2);
		return numberOfWaysToTileMemoize(boardColumns,map);
	}

	public static int numberOfWaysToTileMemoize(int boardColumns, Map<Integer, Integer> map)
	{
		if(!map.containsKey(boardColumns)) 
		{
			int value = numberOfWaysToTileMemoize(boardColumns-1, map) + numberOfWaysToTileMemoize(boardColumns-2, map);
			map.put(boardColumns, value);
		}
		return map.get(boardColumns);
	}

	public static void main(String[] args) 
	{
		Solution3 sol = new Solution3();
		System.out.println(sol.numberOfWaysToTileRecursive(3));

	}

}
