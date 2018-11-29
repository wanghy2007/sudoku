package com.moonbase.hobby.sudoku;

import java.util.HashSet;
import java.util.Set;

public class ColumnConstraint extends Constraint {

	@Override
	public void apply(Board board) {
		for (int col = 1; col <= Board.NUM_COLS; col++) {
			Set<Integer> fillSet = new HashSet<>();
			for (int row = 1; row <= Board.NUM_ROWS; row++) {
				int fill = board.getFill(row, col);
				if (fill != 0) {
					fillSet.add(Integer.valueOf(fill));
				}
			}

			for (Integer fill : fillSet) {
				for (int row = 1; row <= Board.NUM_ROWS; row++) {
					this.remove(board, row, col, fill.intValue());
				}
			}
		}
	}
}
