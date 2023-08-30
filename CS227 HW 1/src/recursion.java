
/* *************************************************************************************
 *  Author:         	Campbell Frost
 *  Written:       		09/04/22
 *  Last updated:   	09/04/22
 *  
 *  Compilation:    	javac CS227 HW 1
 *  Execution:      	java recursion
 *  
 *  Description:    	18.9 is program that recursively calls a method that removes the
 *  					first character of a string and adds it to the end.
 *  					
 *  					18.10 inputs a string and a specific character to a recursive 
 *  					method that checks each element of the string to see if it 
 *  					matches the specific character.
 *  
 *  					18.11 asks the user to input a 3 digit number.  It sends this 
 *  					number to a recursive method that removes elements of the number
 *  					and adds them together.  (Note, this could work with any size 
 *  					number but I wanted the print statement to look clean.) 
) *  
 *  					18.16 takes a string and converts it to an array of characters.
 *  					This array is fed into a helper method that sends the array 	
 *  					along with the length of the array to a second method.  This 
 *  					method checks to see if there is an upper-case letter or not.  
 *  					If it is it will recall the method and add to the counter.
 **************************************************************************************/
import java.util.Scanner;

public class recursion {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String value = "Whats 9 + 10?";
		System.out.println(value + " -> " + reverseDisplay(value));
		

		String str = "Welcome";
		char a = 'e';
		System.out.println("The letter " + a + " appears " + count(str, a) + 
				" times in the string " + str);

		System.out.println("Enter 3 digit integer: ");
		long n = in.nextLong();
		System.out.println(n + " -> " + n/100 + " + " + (n/10)%10 + " + " + n%10 
				+ " = " + sumDigits(n));

		String name = "My name is Campbell Frost";
		char[] nameInCharAr = name.toCharArray();
		System.out.println(name + " has " + count(nameInCharAr) + " uppercase letters.");
	}

//18.9
	public static String reverseDisplay(String value) {
		// Base case. 
		if (value.length() <= 1) {
			return value;

		// If string length is greater than 1, this uses the substring method remove
		// the first character from the string and then the charAt method to append it
		// to the end of the string. This part loops until it reaches the base case. 
		} else 
			return reverseDisplay(value.substring(1)) + value.charAt(0);
		
	}

//18.10
	public static int count(String str, char a) {
		int c = 0;
		// Base case. 
		if (str.length() == 0) {
			return c;

		// This checks to see if the current character is equal to the chosen character.
		// If it is, it adds 1 to the counter, recalls the method on the next character,
		// and then adds the counter	
		} else if (str.charAt(0) == a) {
			++c;
			return count(str.substring(1), a) + c;

		// If the character is not the same, the method is called again at the next
		// character.
		} else 
			return count(str.substring(1), a);
	}

//18.11
	public static int sumDigits(long n) {
		// Base case. This will exit the recursive method when n is equal to 0.
		if (n == 0)
			return 0;

		// This takes the remainder of the integer when it is divided by 10 which
		// returns the last digit of the number. To do this with every number, the
		// sumDigits method is recalled with the integer divided by 10 which removes the
		// last number from the integer. 
		else
			return (int) (n % 10 + sumDigits(n / 10));
	}

//18.16
		// helper method
	public static int count(char[] chars) {
		return count(chars, chars.length);
	}

	public static int count(char[] chars, int high) {
		// Base case
		if(high == 0) 
			return high;
		
		// This checks to see if a character is upper-case.  If it is, it will recall the 
		// count method, increment the count, and decrement the length of the string.  
		if (Character.isUpperCase(chars[high-1])) 
			return 1 + count(chars, high-1);
		
		// If the character is not upper case, it recalls count and decrements the length.	
		 else 
			return count(chars, high-1);
	}
}
