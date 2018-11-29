package com.moonbase.hobby.sudoku;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class Constraint {

	private class Item {
		public int row;
		public int col;
		public int value;
		public Item(int row, int col, int value) {
			this.row = row;
			this.col = col;
			this.value = value;
		}
	}

	private List<Item> itemList = new ArrayList<>();

	protected void remove(Board board, int row, int col, int possibility) {
		int fill = board.getFill(row, col);
		if (fill == 0 && board.hasPossibility(row, col, possibility)) {
			board.removePossiblity(row, col, possibility);
			itemList.add(new Item(row, col, possibility));
		}
	}

	public abstract void apply(Board board);

	public void unapply(Board board) {
		Iterator<Item> itemIterator = itemList.iterator();
		while (itemIterator.hasNext()) {
			Item item = itemIterator.next();
			board.addPossibility(item.row, item.col, item.value);
			itemIterator.remove();
		}
	}
}
