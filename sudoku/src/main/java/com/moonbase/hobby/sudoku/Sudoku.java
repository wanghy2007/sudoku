package com.moonbase.hobby.sudoku;

import java.util.ArrayList;
import java.util.List;

public class Sudoku {

	private Board board;
	private List<Constraint> constraintList;

	public Sudoku(int[][] intMatrix) {
		this.board = new Board(intMatrix);
		this.constraintList = new ArrayList<>();
		this.constraintList.add(new RowConstraint());
		this.constraintList.add(new ColumnConstraint());
		this.constraintList.add(new SquareConstraint());
	}

	private void apply() {
		for (Constraint constraint : this.constraintList) {
			constraint.apply(this.board);
		}
	}

	private void unapply() {
		for (Constraint constraint : this.constraintList) {
			constraint.unapply(this.board);
		}
	}

	public String solve() {
		if (this.board.isSolved()) {
			return this.board.toString();
		}

		this.apply();
		if (this.board.isDeadEnd()) {
			this.unapply();
			return null;
		}

		for (int row = 1; row <= Board.NUM_ROWS; row++) {
			for (int col = 1; col <= Board.NUM_COLS; col++) {
				int fill = this.board.getFill(row, col);
				if (fill != 0) {
					continue;
				}
				for (Integer possibility : this.board.getPossibilitySet(row, col)) {
					this.board.setFill(row, col, possibility.intValue());
					String solution = this.solve();
					if (solution != null) {
						return solution;
					} else {
						this.board.setFill(row, col, 0);
						this.board.removePossiblity(row, col, possibility.intValue());
					}
				}
			}
		}
		return null;
	}
}
