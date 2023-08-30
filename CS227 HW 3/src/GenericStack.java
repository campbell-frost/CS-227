import java.util.ArrayList;
import java.util.Arrays;

/* ********************************************************************************************************
 *  Author:         	Campbell Frost
 *  Written:       		09/20/22
 *  Last updated:   	09/21/22
 *  
 *  Compilation:    	javac CS227 HW 3
 *  Execution:      	java GenericStack
 *  
 *  Description:    	19.01 uses a generic array to input different data types into the same methods.  
 *  					It features the push (adds a value to the list), pop (removes first pushed value 
 *  					from the list), peek (returns first pushed value), isEmpty (returns true or false 
 *  					if the list is empty), toString (returns stack as a string) and newList (creates a 
 *  					new temp list that is twice the size as the initial list)
 *  
 *   					19.3 uses a simple generic method that goes through an array list, checks to see
 *   					if there are any duplicate values and removes them from the list. 
 **********************************************************************************************************/

public class GenericStack<T> {
	private int size = 0;
	private T[] list = (T[]) new Object[5];

	// Returns the size of the list
	public int getSize() {
		return size;
	}
	
	// Returns the first element of the list
	public T peek() {
		return list[size - 1];
	}

	// Adds element to list
	public void push(T o) {
		if (size >= list.length) {
			newList();
		}
		list[size++] = o;
	}
	
	// Returns the next element of list and checks size
	public T pop() {
		if (size >= list.length) {
			newList();
		}
		T o = list[--size];
		return o;
	}

	// Returns whether the list is empty or not
	public boolean isEmpty() {
		return size == 0;
	}

	// method that converts list to string
	@Override
	public String toString() {
		return "stack: " + list.toString();
	}

	// Copies list to a new list with twice the total length
	public void newList() {
		T[] temp = (T[]) new Object[list.length * 2];
		System.arraycopy(list, 0, temp, 0, list.length);
		list = temp;
		
	}
	// Checks array list for duplicates values and removes duplicates from the list.
	public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
		ArrayList<E> list2 = new ArrayList<>();

		for (int i = 0; i < list.size(); i++) {
			if (!list2.contains(list.get(i))) {
				list2.add(list.get(i));
			}
		}
		return list2;
	}

	public static void main(String[] args) {
//19.01
		// Creates new stack object and adds 3 strings
		GenericStack<String> stack1 = new GenericStack<>();
		stack1.push("London");
		stack1.push("Berlin");
		stack1.push("Moscow");

		// Creates new stack object and adds 11 integers
		GenericStack<Integer> stack2 = new GenericStack<>();
		int t = stack2.getSize();
		for (int i = 0; i <= 10; i++) 
			stack2.push(i);
		
		// Checks methods for stack1
		System.out.println("Is stack1 empty? " + stack1.isEmpty());
		System.out.println("Size: " + stack1.getSize());
		System.out.println("Peek: " + stack1.peek());
		System.out.print("Popping: ");
		while (stack1.isEmpty() == false) {
			System.out.print(stack1.pop() + " ");
		}
		System.out.println("\nIs stack1 empty? " + stack1.isEmpty());

		// Checks methods for stack2
		System.out.println("\nIs stack2 empty? " + stack2.isEmpty());
		System.out.println("Size of stack2: " + stack2.getSize());
		System.out.println("Peek: " + stack2.peek());
		System.out.print("Popping: ");
		while (stack2.isEmpty() == false) {
			System.out.print(stack2.pop() + ", ");

		}
		System.out.println("\nIs stack2 empty? " + stack2.isEmpty());
//19.03
		// Initializes array list with integers
		ArrayList<Integer> integer = new ArrayList<Integer>(Arrays.asList(9, 8, 10, 21, 17, 38, 9, 8, 21));
		System.out.println("\n\nInitial list:         " + integer);
		System.out.println("Duplicates removed:   " + removeDuplicates(integer));
		
		// Initializes array list with strings
		ArrayList<String> string = new ArrayList<String>(
				Arrays.asList("Cheeseburger", "Sandwich", "FrenchFry", "Coke", "Cheeseburger", "Hamburger", "Coke", "Salad"));
		System.out.println("\nInitial list:         " + string);
		System.out.println("Duplicates removed:   " + removeDuplicates(string));
		
	}
}
