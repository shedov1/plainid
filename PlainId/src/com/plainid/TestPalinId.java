package com.plainid;

import java.util.Scanner;

public class TestPalinId {
	
	public static void main(String[] args) 
    { 
		
		GameBoard gameBoard = new GameBoard();
		gameBoard.print();
 		
        Scanner scanner = new Scanner(System.in); 
  
        while (true) {

            System.out.println("Enter numebr to move : ");
            String input = scanner.nextLine();

            if ("q".equals(input)) {
                System.out.println("Exit!");
                break;
            }
            
            if ("p".equals(input)) {
                System.out.println("Printing status!");
                gameBoard.print();
                System.out.println();
            } else if ("c".equals(input)) { 
            	if ( gameBoard.isBoardFix() ) {
            		 System.out.println("Board is fix !");
            	} else {
            		 System.out.println("Yet to come , board is not fix!");
            	}
            } else {
            
	            try {
					byte num = Byte.parseByte(input);
					if ( num > 0  && num < 16 ) {
						gameBoard.move(num);
					} else {
						System.err.println("Only numbers between 1 to 15 ,pay attention !!!");
					}
					
				} catch (NumberFormatException e) {
					System.err.println("can't parse number ,pay attention !!!");
				}
            }
           
            
        }

        scanner.close();
       
    } 
}
