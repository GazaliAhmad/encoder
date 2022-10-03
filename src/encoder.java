import java.util.Arrays;

public class encoder {
	encoder(String[] refArray, String key, int keyIndex, String str, String output) {
		if (key.matches(("^[A-Z0-9()*+,-./]$"))) {
			keyIndex = Arrays.asList(refArray).indexOf(key);
		} else {
			System.out.println("Invalid key");
			System.exit(0);
		}
		String[] rotatedArray = new String[refArray.length];
		for (int i = 0; i < refArray.length; i++) {
			rotatedArray[i] = refArray[(i + keyIndex) % refArray.length];
		}
		for (int j = 0; j < str.length(); j++) {
			if (str.charAt(j) == ' ') {
				output += " ";
			} else {
				output += refArray[Arrays.asList(rotatedArray).indexOf(str.substring(j, j + 1))];
			}
		}
		System.out.println("\nEncoded: " + output);
	}
}
