package com.moonbase.hobby.sudoku;

import java.util.HashSet;
import java.util.Set;

public class RowConstraint extends Constraint {

	@Override
	public void apply(Board board) {
		for (int row = 1; row <= Board.NUM_ROWS; row++) {
			Set<Integer> fillSet = new HashSet<>();
			for (int col = 1; col <= Board.NUM_COLS; col++) {
				int fill = board.getFill(row, col);
				if (fill != 0) {
					fillSet.add(Integer.valueOf(fill));
				}
			}

			for (Integer fill : fillSet) {
				for (int col = 1; col <= Board.NUM_COLS; col++) {
					this.remove(board, row, col, fill.intValue());
				}
			}
		}
	}
}
