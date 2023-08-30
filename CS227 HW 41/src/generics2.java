/* ********************************************************************************************************
 *  Author:         	Campbell Frost
 *  Written:       		09/25/22
 *  Last updated:   	09/27/22
 *  
 *  Compilation:    	javac CS227 HW 41
 *  Execution:      	java generics2
 *  
 *  Description:    	19.06 runs through a 2d array and returns the maximum value.
 *  
 *  					19.07 implements binary search to see if a certain value is in the array.
 *  
 *  					19.08 is a generic method that shuffles an array list. 
 *  
 *  					19.09 is a generic method that sorts an array list.
 *  
 *  					19.10 is a generic method that finds the maximum value of an array list.
 **********************************************************************************************************/
import java.util.ArrayList;
import java.util.Scanner;

public class generics2 {
	
	public static <E extends Comparable<E>> E max(E[][] list) {
		E temp = list[0][0];
		// loops through 2D array and sets the biggest index equal to a temp value
		for (int i = 0; i < list.length; i++)
			for (int j = 0; j < list[i].length; j++)
				if (list[i][j].compareTo(temp) > 0)
					temp = list[i][j];

		return temp;
	}

	public static void initialize(Integer[][] list) {
		// Initializes list with random values between 10 and 99
		for (int i = 0; i < list.length; i++) {
			for (int j = 0; j < list[i].length; j++) {
				list[i][j] = (int) (Math.random() * 90) + 10;
			}
		}
	}

	public static void print(Integer[][] list, int s) {
		// prints the 2D array with no trailing commas
		int count = 0;
		for (int i = 0; i < list.length; i++) {
			for (int j = 0; j < list[i].length; j++) {
				++count;
				System.out.print(list[i][j] + ", ");
				if (count >= s-1) {
					count = 0;
					System.out.println(list[i][j]);
				}
			}
		}
	}

	public static <E extends Comparable<E>> int binarySearch(E[] list, E key) {
		// Creates parameters in list
		int first = 0;
		int last = list.length - 1;
		int middle;

		while (last >= first) {
			middle = (first + last) / 2;
			// If key is not in the last half, take last half out
			if (key.compareTo(list[middle]) < 0)
				last = middle - 1;
			// If key is not in the first half, take first half out
			else if (key.compareTo(list[middle]) > 0)
				first = middle + 1;
			// Once we collapse the list down to a single value, it must be equal to key
			else
				return middle;

		}
		return -first -1;
	}

	public static <E> void shuffle(ArrayList<E> list) {
		int next = (int) (Math.random() * list.size());
		// goes through array and creates a temp with a random index.
		for (int i = 0; i < list.size(); i++) {
			E temp = list.get(i);
			// swaps current index with temp
			list.set(i, list.get(next));
			list.set(next, temp);
		}
	}

	public static <E extends Comparable<E>> void sort(ArrayList<E> list) {
		for (int i = 0; i < list.size(); i++) {
			int index = 0;
			E min = list.get(i);
			// Second for loop for comparing (can't use boolean operators in compareTo)
			for (int j = i + 1; j < list.size(); j++) {
				index = i;
				E nextIndex = list.get(j);
				if (min.compareTo(nextIndex) > 0) {
					min = list.get(j);
					index = j;
				}
				// sets new min and swaps it old value iff there is a greater value
				if (index != i) {
					list.set(index, list.get(i));
					list.set(i, min);
				}
			}
		}
	}

	public static <E extends Comparable<E>> E max(ArrayList<E> list) {
		E max = null;
		// This goes through the array list and checks to see if the current index is
		// greater than max.
		for (int i = 0; i < list.size(); i++) {
			max = list.get(i);
			// If it is, change max to index
			if (max.compareTo(list.get(i)) > 0) {
				max = list.get(i);
			}
		}
		return max;
	}

	private static void initialize(Integer[] list) {
		// Initializes array with numbers 1-20
		for (int i = 0; i < list.length; i++) {
			list[i] = i + 1;
		}
	}

	public static void print(Integer[] list) {
		// Prints list without trailing comma
		for (int i = 1; i < list.length + 1; i++) {
			System.out.print(i);
			if (i != list.length) {
				System.out.print(", ");
			}
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		// 19.06
		System.out.println("Enter size of 2d array: ");
		int s = in.nextInt();
		Integer array[][] = new Integer[s - 1][s];

		initialize(array);
		print(array, s);

		System.out.println("\nMax value of array: " + max(array));

		// 19.07
		System.out.println("\nCreating list");
		Integer[] list1 = new Integer[20];

		initialize(list1);
		print(list1);

		System.out.println("\nEnter a number to search for: ");
		int key = in.nextInt();
		if (binarySearch(list1, key) > 0)
			System.out.println(key + " is in the list");
		else
			System.out.println(key + " is not in the list");

		// 19.08
		ArrayList<String> stringList = new ArrayList<>();
		stringList.add("Hambuger");
		stringList.add("CheeseBurger");
		stringList.add("HotDog");
		stringList.add("Sandwich");
		stringList.add("Pizza");
		stringList.add("Taco");
		System.out.println("\nInitial list:  " + stringList.toString());
		shuffle(stringList);
		System.out.println("Shuffled list: " + stringList.toString());

		// 19.09
		ArrayList<Integer> intList = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			int rand = (int) (Math.random() * 10) + 1;

			intList.add(rand);
		}

		System.out.println("\nUnsorted list: " + intList.toString());
		sort(intList);
		System.out.println("Sorted list:   " + intList.toString());

		// 19.10
		System.out.println("\nMax of list:   " + max(intList));
	}

}
