package com.moonbase.hobby.sudoku;

import java.util.HashSet;
import java.util.Set;

public class Board {

	private class Cell {
		private int fill;
		private Set<Integer> possibilitySet = new HashSet<>();

		public int getFill() {
			return fill;
		}
		public void setFill(int fill) {
			this.fill = fill;
		}

		public Set<Integer> getPossibilitySet() {
			return new HashSet<>(this.possibilitySet);
		}

		public void setPossibilitySet(Set<Integer> possibilitySet) {
			this.possibilitySet = new HashSet<>(possibilitySet);
		}

		public boolean hasPossibility(int possibility) {
			return this.possibilitySet.contains(Integer.valueOf(possibility));
		}

		public void addPossibility(int possibility) {
			this.possibilitySet.add(Integer.valueOf(possibility));
		}

		public void removePossibility(int possibility) {
			this.possibilitySet.remove(Integer.valueOf(possibility));
		}
	}

	private Cell[][] cellMatrix;
	public static final int NUM_ROWS = 9;
	public static final int NUM_COLS = 9;
	private static final int MAX_NUM = 9;

	public Board(int[][] intMatrix) {
		this.cellMatrix = new Cell[NUM_ROWS+1][NUM_COLS+1];

		Set<Integer> allPossibilitySet = new HashSet<>();
		for (int num = 1; num <= MAX_NUM; num++) {
			allPossibilitySet.add(Integer.valueOf(num));
		}

		for (int row = 0; row < NUM_ROWS; row++) {
			for (int col = 0; col < NUM_COLS; col++) {
				Cell cell = new Cell();
				cell.setFill(intMatrix[row][col]);
				if (intMatrix[row][col] == 0) {
					cell.setPossibilitySet(allPossibilitySet);
				} else {
					Set<Integer> singlePossibilitySet = new HashSet<>();
					singlePossibilitySet.add(Integer.valueOf(intMatrix[row][col]));
					cell.setPossibilitySet(singlePossibilitySet);
				}
				this.cellMatrix[row+1][col+1] = cell;
			}
		}
	}

	public int getFill(int row, int col) {
		return this.cellMatrix[row][col].getFill();
	}

	public void setFill(int row, int col, int fill) {
		this.cellMatrix[row][col].setFill(fill);
	}

	public Set<Integer> getPossibilitySet(int row, int col) {
		return this.cellMatrix[row][col].getPossibilitySet();
	}

	public boolean hasPossibility(int row, int col, int possibility) {
		return this.cellMatrix[row][col].hasPossibility(possibility);
	}

	public void addPossibility(int row, int col, int possibility) {
		this.cellMatrix[row][col].addPossibility(possibility);
	}

	public void removePossiblity(int row, int col, int possibility) {
		this.cellMatrix[row][col].removePossibility(possibility);
	}

	public boolean isDeadEnd() {
		for (int row = 1; row <= NUM_ROWS; row++) {
			for (int col = 1; col <= NUM_COLS; col++) {
				if (this.cellMatrix[row][col].getPossibilitySet().size() == 0) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean isSolved() {
		for (int row = 1; row <= NUM_ROWS; row++) {
			for (int col = 1; col <= NUM_COLS; col++) {
				if (this.cellMatrix[row][col].getFill() == 0) {
					return false;
				}
			}
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("+---+---+---+---+---+---+---+---+---+\n");
		for (int row = 1; row <= NUM_ROWS; row++) {
			sb.append("|");
			for (int col = 1; col <= NUM_COLS; col++) {
				int fill = this.cellMatrix[row][col].getFill();
				sb.append(" "+fill+" |");
			}
			sb.append("\n");
			sb.append("+---+---+---+---+---+---+---+---+---+\n");
		}
		return sb.toString();
	}
}
