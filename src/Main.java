import java.util.Scanner;
import static java.lang.System.err;
import static java.lang.System.out;
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
		
		Scanner input = new Scanner(System.in);
		out.println("\nEnter key and phrase: ");
		String phrase = input.nextLine();
		
		String key = phrase.substring(0, 1);
		key = key.toUpperCase();
		int keyIndex = 0;
		String str = phrase.substring(1);
		str = str.toUpperCase();
		if (!str.matches(("^[A-Z0-9()*+,-./ ]+$"))) {
			err.print("\nInvalid string!");
			err.print("\nString must only contain A-Z, 0-9, and the following characters: ()*+,-./");
			System.exit(1);
		}
		if (str.charAt(0) == ' ') {
			err.print("\nInvalid string!");
			err.print("\nString must not start with a space");
			System.exit(1);
		}
		String output = "";
		
		// Decode or encode
		out.print("\nDecode or encode? (d/e)");
		String choice = input.nextLine();
		choice = choice.toLowerCase();
		
		if (choice.equals("d")) new decoder(key, keyIndex, str, output);
		else if (choice.equals("e")) new encoder(key, keyIndex, str, output);
		else {
			err.print("\nInvalid choice");
			System.exit(1);
		}
	}
}
