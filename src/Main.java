import java.util.Scanner;
import static java.lang.System.*;
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
		
		final var input = new Scanner(System.in);
		out.println("\nEnter key and phrase: ");
		final var phrase = input.nextLine();
		
		final var key = phrase.substring(0, 1).toUpperCase();
		final var codePhrase = phrase.substring(1).toUpperCase();
		
		if (!codePhrase.matches("^[A-Z0-9()*+,-./ ]+$")) {
			err.print("\nInvalid string!");
			err.print("\nString to encode/decode must only contain A-Z, 0-9, and the following characters: ()* +,-./");
			exit(1);
		} else if (codePhrase.charAt(0) == ' ') {
			err.print("\nInvalid string!");
			err.print("\nString to encode/decode must not start with a space");
			exit(1);
		} else if (!key.matches("^[A-Z0-9()*+,-./]$")) {
			err.print("\nInvalid key!");
			err.print("\nKey must only contain A-Z, 0-9, and the following characters: ()*+,-./");
			exit(1);
		}
		
		out.println("\nEncode or decode (q to Quit, r to Re-enter text) ? (e/d)");
		
		@SuppressWarnings("ReassignedVariable") var choice = input.nextLine().toLowerCase();
		if (!choice.equals("q")) {
			do {
				switch (choice) {
					case "e" -> new encoder(key, codePhrase);
					case "d" -> new decoder(key, codePhrase);
					case "r" -> main(args);
					default -> {
						err.print("\nInvalid choice!");
						out.print("\nEncode or decode (q to Quit, r to Re-enter text) ? (e/d)");
					}
				}
				choice = input.nextLine().toLowerCase();
			} while (!choice.equals("q"));
		}
	}
}
