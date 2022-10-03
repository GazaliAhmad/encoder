import java.util.Scanner;
/*
	Get input from user. First character is the key to shift the alphabet by.
	Second character is the string to be encoded.
	
	Example:
	if key is B and the string is ABC, the output will be /AB.
	if key is F and the string is ABC, the output will be +,-.
	if key is F and the string is Hello, the output will be C/GGJ
	The array is looped through and the index of the character is found.
	The index is then shifted by the key and the character at that index is
	added to the output string.
	Two methods encode and decode are used to encode and decode the string.
	 */

public class Main {
	
	public static void main(String[] args) {
		String[] refArray = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
				"K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",
				"0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
				"(", ")", "*", "+", ",", "-", ".", "/",};
		
		Scanner input = new Scanner(System.in);
		System.out.println("\nEnter key and phrase: ");
		String phrase = input.nextLine();
		
		String key = phrase.substring(0, 1);
		key = key.toUpperCase();
		int keyIndex = 0;
		String str = phrase.substring(1);
		str = str.toUpperCase();
		String output = "";
		
		new encoder(refArray, key, keyIndex, str, output);
	}
}
