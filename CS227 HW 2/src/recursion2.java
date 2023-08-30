
/* *************************************************************************************
 *  Author:         	Campbell Frost
 *  Written:       		09/10/22
 *  Last updated:   	09/10/22
 *  
 *  Compilation:    	javac CS227 HW 2
 *  Execution:      	java recursion2
 *  
 *  Description:    	18.21 converts a user-chosen decimal number into binary.  To 
 *  					convert decimal to binary, you must divide the decimal number 
 *  					by 2 until it reaches zero, save each of the remainders and 
 *  					then combine them to make a binary number.  
 *  					18.25 takes a string and shows all possible permutations of 
 *  					characters.  It does this by choosing a starting letter (prefix).
 *  					
 * 
 **************************************************************************************/
import java.util.Arrays;
import java.util.Scanner;

public class recursion2 {
//	public int n = 8;
//	public static int[][] board = new int[n][n];

	public static void main(String[] args) {
		// 18.21
		Scanner in = new Scanner(System.in);
//		System.out.println("Enter a decimal number: ");
//		int v = in.nextInt();
//		System.out.println(v + " in binary is: " + dec2Bin(v));
//		System.out.println();
//
//		// 18.25
//		System.out.println("Enter a string: ");
//		String s = in.next();
//		System.out.print("Permutations of " + s + ": \r\n");
//		displayPermutation(s);
//		System.out.println();
//
//		// 18.34
//		System.out.println("Enter size of chess board: ");
//		int n = in.nextInt();
//		int[][] board = new int[n][n];
//		setBoard(board);
//		placeQueen(board, n, 0);
//		printBoard(board, n);
//		
		double [] test = new double[]{160, 164, 183, 215, 217, 217, 230, 230, 239, 257, 259, 263, 277, 321, 326};
		double sum = 0;
		for(int i = 0; i< test.length; i++) {
			sum = (int) (sum + Math.pow(test[i], 2));
			//System.out.println(sum);
		}
		
		System.out.println("n(\u03A3x^2)= " +sum);
		double sum2 =0;
		for(int i = 0; i< test.length; i++) {
			sum2 = (int) (sum2 + test[i]);
			//System.out.println(sum2);
		}
		System.out.println("n(\u03A3x)^2 = "+sum2);
		double num1 =  (test.length * sum);
		double num2 = (int) Math.pow(sum2, 2);
		double num3 = num1 - num2;
		double dem = (test.length * (test.length-1));
	
		
		System.out.println("numerator = " + num1 + " - " + num2 + " = " + num3);
		System.out.println("denominator = " + dem);
		System.out.println("Variance = sqrt(" + num3/dem +")");
		System.out.println("Standard Deviation = " + Math.sqrt(num3/dem));


		
	}

	// 18.21
	public static String dec2Bin(int value) {
		// Base case
		if (value == 0)
			return "";

		// divides value by 2, saves remainder, and calls the method again with value /
		// 2
		else
			return dec2Bin(value / 2) + "" + (value % 2);
	}

	// 18.25
	// helper method
	public static void displayPermutation(String s) {
		displayPermutation("", s);
	}

	public static void displayPermutation(String s1, String s2) {
		// base case for each loop.
		if (s2.length() == 0) {
			System.out.println(s1);
		} else {
			// cycles through remaining characters and adds to current prefix.
			for (int i = 0; i < s2.length(); i++) {
				// adds next character to the prefix
				String swap = s1 + s2.charAt(i);
				// takes the substring up to i and adds it to substring after i
				String swap2 = s2.substring(0, i) + s2.substring(i + 1, s2.length());
				// calls recursive method
				displayPermutation(swap, swap2);
			}
		}
	}

	// 18.34

	public static void setBoard(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				board[i][j] = 0;
			}
		}
	}

	public static boolean checkBoard(int[][] board, int x, int y) {
		// Runs through each row of the selected column and sees if a queen is there
		for (int i = 0; i < x; i++)
			if (board[x][i] == 1 || board[i][y] == 1)
				return false;
		//int i, j;
		//while(i<)
		for (int i = x, j = y; i >= 0 && j >= 0; i--, j--) {
			if (board[i][j] == 1) {
				return false;
			}
		}
		// checking lower diagonal
		for (int i = x, j = y; i < board.length && j >= 0; i++, j--) {
			if (board[i][j] == 1) {
				return false;
			}
		}
		return true;

	}
	public static boolean placeQueen(int board[][], int n, int x) {
		// Exits loop when all columns are filled
		if (n == 0 || x >= n) {
			return true;
		}
		 for(int j=0;j<n;j++){
//			 printBoard(board, j);
//			 System.out.println();
			 // Checks to see if the index is in a queen's kill-zone and places a queen if the index is free
			if (checkBoard(board, x, j)) {
				board[x][j] = 1; 

				// call recursive method and increment x to go through the column.
				if (placeQueen(board, n, x + 1)) // call recursive method and increment x to go through the column.
					return true;
				
				// removes previous move if the next move wont work.
				else
					board[x][j] = 0; 

			}
		}
		return false;

	}

	static boolean solveNQUtil(int board[][], int n, int x) {
		/*
		 * base case: If all queens are placed then return true
		 */
		if (x >= n)
			return true;

		// tries to place a queen on each row of a particular column
		for (int y = 0; y < n; y++) {
			/*
			 * Check if the queen can be placed on board[i][col]
			 */
			if (checkBoard(board, y, x)) {
				/* Place this queen in board[i][col] */
				board[y][x] = 1;

				/* recur to place rest of the queens */
				if (solveNQUtil(board, n - 1, x + 1) == true)
					return true;

				/*
				 * If placing queen in board[i][col] doesn't lead to a solution then remove
				 * queen from board[i][col]
				 */
				board[y][x] = 0; // BACKTRACK
			}
		}
		return false;
	}
	

	public static void printBoard(int[][] board, int n) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if(board[i][j] == 1)
				System.out.print("Q ");
				else
					System.out.print("* ");
					//System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

		
}
