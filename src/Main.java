import java.util.Arrays;

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
				"(", ")", "*", "+", ",", "-", ".", "/"};
		
		System.out.println("\nRefTable:\n " + Arrays.toString(refArray));
		
		String key = "F";
		key = key.toUpperCase();
		int keyIndex;
		
		String input = "This is (the world) that we live in and I love it 3000";
		input = input.toUpperCase();
		String output = "";
		System.out.println("\nInput: " + input);
		
		if (key.matches(("^[A-Z0-9()*+,-./]$"))) {
			keyIndex = Arrays.asList(refArray).indexOf(key);
			System.out.println("\nKey: " + key + " KeyIndex: " + keyIndex);
			String[] rotatedArray = new String[refArray.length];
			for (int i = 0; i < refArray.length; i++) {
				rotatedArray[i] = refArray[(i + keyIndex) % refArray.length];
			}
				for (int j = 0; j < input.length(); j++) {
					if (input.charAt(j) == ' ') {
						output += " ";
					}
					if (input.charAt(j) != ' ') {
						int index = Arrays.asList(rotatedArray).indexOf(input.charAt(j) + "");
						output += refArray[index];
					}
				}
				System.out.println("\nOutput: " + output);
			}
		}
	}
	


