package com.plainid;

import java.util.Arrays;
import java.util.HashMap;

public class GameBoard {

	private HashMap<Byte, Position> gameBoard = new HashMap<Byte, Position>();

	class Position implements Comparable<Position> {
		byte num, row, column;

		public Position(byte num, byte row, byte column) {
			super();
			this.num = num;
			this.row = row;
			this.column = column;
		}

		@Override
		public int compareTo(Position o) {
			if (o.row < this.row) {
				return 1;
			} else if (o.row == this.row) {
				if (o.column < this.column) {
					return 1;
				} else if (o.column > this.column) {
					return -1;
				} else {
					return 0;
				}
			} else {
				return -1;
			}
		}

	}

	private byte[][] board;

	public GameBoard() {

		init();
	}

	private void init() {
		GameBoardBuilder builder = new GameBoardBuilder();
		board = builder.build();

		for (byte i = 0; i < board.length; i++) {
			for (byte j = 0; j < board[i].length; j++) {
				gameBoard.put(board[i][j], new Position(board[i][j], i, j));
			}
		}
	}

	public void print() {
		Position[] numbers = gameBoard.values().toArray(new Position[0]);
		Arrays.sort(numbers);
		byte count = 1;
		for (Position pos : numbers) {
			if (count % 4 == 0) {
				if (pos.num == 0) {
					System.err.println("\tX");
				} else {
					System.err.println("\t" + pos.num);
				}

			} else {
				if (pos.num == 0) {
					System.err.print("\tX");
				} else {
					System.err.print("\t" + pos.num);
				}
			}
			count++;
		}
	}

	public void move(byte num) {
		Position zeroPos = gameBoard.get((byte) 0);
		Position numPos = gameBoard.get(num);

		if (Math.abs(numPos.row - zeroPos.row) <= 1 && Math.abs(numPos.column - zeroPos.column) <= 1) {
			swap(zeroPos, numPos);
		} else {
			System.err.println("can not move " + num);
		}

	}

	private void swap(Position a, Position b) {
		byte temp;

		temp = a.row;
		a.row = b.row;
		b.row = temp;

		temp = a.column;
		a.column = b.column;
		b.column = temp;
	}

	public boolean isBoardFix() {
		Position[] numbers = gameBoard.values().toArray(new Position[0]);
		Arrays.sort(numbers);
		byte count = 1;
		boolean isFix = true;
		for (Position pos : numbers) {
			if (pos.num != count) {
				isFix = false;
				break;
			}
			count++;
		}
		return isFix;
	}

}
