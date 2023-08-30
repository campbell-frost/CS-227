
/* ********************************************************************************************************
 *  Author:         	Campbell Frost
 *  Written:       		11/09/22
 *  Last updated:   	11/09/22
 *  
 *  Compilation:    	javac main.java
 *  Execution:      	java main
 *  
 *  Description:    	21.1 adds names to 2 different linked hash sets and performs the union, difference,
 *  					and intersect set operations on them
 *  
 *  					21.2 reads a text document and sends each word into a tree map.  The tree map is 
 *  					then displayed
 *  
 *  					21.4 scans a text document and counts the number of vowels and consonants 
 *  
 *  					21.6 asks the user to input an undefined number of integers and return which 
 *  					integer (or integers) occur the most frequently
 **********************************************************************************************************/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeSet;

public class main {

	/**
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// 21.1
		LinkedHashSet<String> names1 = new LinkedHashSet<String>();
		// adds names to names1
		names1.add("George");
		names1.add("Jim");
		names1.add("John");
		names1.add("Blake");
		names1.add("Kevin");
		names1.add("Michael");
		System.out.println("Set 1: " + names1);

		// adds more names to names 2
		LinkedHashSet<String> names2 = new LinkedHashSet<String>();
		names2.add("George");
		names2.add("Katie");
		names2.add("Kevin");
		names2.add("Michelle");
		names2.add("Ryan");
		System.out.println("Set 2: " + names2);

		// creates a linkedHashSet identical to names 1 and adds names2
		LinkedHashSet<String> union = new LinkedHashSet<>(names1);
		union.addAll(names2);
		System.out.println("The union of these sets is:         " + union);

		// creates a linkedHashSet identical to names 1 and removes any names contained
		// in names2
		LinkedHashSet<String> difference = new LinkedHashSet<>(names1);
		difference.removeAll(names2);
		System.out.println("The difference of these sets is:    " + difference);

		// creates a linkedHashSet identical to names 1 and only shows elements that
		// both sets have
		LinkedHashSet<String> intersect = new LinkedHashSet<>(names1);
		intersect.retainAll(names2);
		System.out.println("The intersection of these sets is : " + intersect);

		// 21.2
		// text file can be downloaded at the link below
		// http://textfiles.com/100/captmidn.txt
		// name the file words.txt and save to desktop
		// path should be changed for your computer's specific desktop location
		File file = new File("C:/Users/campbell/Desktop/words.txt");
		Scanner scan = new Scanner(file);
		TreeSet<String> set = new TreeSet<>();
		while (scan.hasNext()) {
			set.add(scan.next());
		}
		System.out.println(set);
		scan.close();
		// Note: the text shown first has apostrophes in front so it almost looks like
		// they arren't organized correcectly but they are.

		// 21.4
		// The text I put in the document is :"The code for this sample text will
		// return the number of vowels and the number of consonants"
		// I checked this phrase in an online character converter
		// (https://www.abahan.com/tools/letter-character-word-vowel-count.aspx) and got
		// the same numbers
		File file2 = new File("C:/Users/campbell/Desktop/sampleText.txt");
		// set with vowels to check for
		HashSet<Character> set2 = new HashSet<>(Arrays.asList('A', 'E', 'I', 'U', 'O', 'a', 'e', 'i', 'o', 'u'));
		Scanner scan2 = new Scanner(file2);
		int vowels = 0, consonants = 0;
		while (scan2.hasNext()) {
			String word = scan2.next();
			// scans each letter per word and determines if it is a vowel or a consonant
			for (int i = 0; i <= word.length() - 1; i++) {
				if (set2.contains(word.charAt(i)))
					vowels++;
				else
					consonants++;
			}
		}

		System.out.println("The file has " + vowels + " vowels and " + consonants + " consonants.");

		scan2.close();

		// 21.6

		System.out.println("Enter a non-specific amount of integers and press 0 when done: ");
		Scanner in = new Scanner(System.in);
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		// adds integers as indexes in hashmap
		while (true) {
			int key = in.nextInt();
			if (key == 0)
				break;
			// adds values to hashmap
			if (!hashMap.containsKey(key)) {
				hashMap.put(key, 1);
			} else {
				// if value is already in hashmap, increase value
				int value = hashMap.get(key);
				value++;
				hashMap.put(key, value);
			}
		}
		System.out.println("HashMap: " + hashMap);
		// Iterate through hashmap
		for (Entry<Integer, Integer> entry : hashMap.entrySet()) {
			if (entry.getValue() == Collections.max(hashMap.values())) {
				System.out.println("Integer that appears most frequently: " + entry.getKey());

			}
		}
		in.close();
	}
}
