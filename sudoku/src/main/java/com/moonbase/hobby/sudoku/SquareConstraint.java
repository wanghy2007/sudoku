package com.moonbase.hobby.sudoku;

import java.util.HashSet;
import java.util.Set;

public class SquareConstraint extends Constraint {

	private void applySquare(int startRow, int startCol, Board board) {
		Set<Integer> fillSet = new HashSet<>();
		for (int row = startRow; row < startRow+3; row++) {
			for (int col = startCol; col < startCol+3; col++) {
				int fill = board.getFill(row, col);
				if (fill != 0) {
					fillSet.add(Integer.valueOf(fill));
				}
			}
		}

		for (Integer fill : fillSet) {
			for (int row = startRow; row < startRow+3; row++) {
				for (int col = startCol; col < startCol+3; col++) {
					this.remove(board, row, col, fill.intValue());
				}
			}
		}
	}

	@Override
	public void apply(Board board) {
		for (int startRow = 1; startRow <= Board.NUM_ROWS; startRow += 3) {
			for (int startCol = 1; startCol <= Board.NUM_COLS; startCol += 3) {
				this.applySquare(startRow, startCol, board);
			}
		}
	}
}
