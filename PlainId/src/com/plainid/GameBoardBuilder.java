package com.plainid;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class GameBoardBuilder {

	private byte[] board = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };

//	public static void main(String[] args) {
//		GameBoardBuilder builder = new GameBoardBuilder();
//		builder.build();
//
//	}

	public byte[][] build() {
		Random rnd = ThreadLocalRandom.current();
		for (int i = board.length - 1; i > 0; i--) {
			int index = rnd.nextInt(i + 1);
			byte a = board[index];
			board[index] = board[i];
			board[i] = a;
		}
//		for (int i = 0; i < board.length; i++) {
//			System.err.print("\t"+board[i]);
//		}
		
		byte[][] newBoard = new byte[4][];

        for(int i = 0; i < 4; ++i) {
            int start = i * 4;
            int length = Math.min(board.length - start, 4);

            byte[] temp = new byte[length];
            System.arraycopy(board, start, temp, 0, length);
            newBoard[i] = temp;
        }

        return newBoard;
	}

}
