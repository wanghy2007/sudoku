package com.moonbase.hobby.sudoku;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	int[][] intMatrix = new int[][]{
    		{2, 0, 7, 0, 0, 3, 0, 5, 0},
    		{0, 9, 0, 0, 0, 0, 1, 0, 0},
    		{0, 5, 0, 6, 2, 9, 0, 4, 8},
    		{0, 6, 3, 0, 9, 8, 4, 1, 7},
    		{0, 4, 0, 1, 0, 6, 0, 2, 0},
    		{8, 1, 2, 5, 4, 0, 3, 6, 0},
    		{6, 7, 0, 9, 5, 1, 0, 8, 0},
    		{0, 0, 8, 0, 0, 0, 0, 7, 0},
    		{0, 3, 0, 7, 0, 0, 6, 0, 4}
    	};

    	Sudoku sudoku = new Sudoku(intMatrix);
    	System.out.println(sudoku.solve());
    }
}
