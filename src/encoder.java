import org.jetbrains.annotations.NotNull;
import java.util.Arrays;
import static java.lang.System.out;

public class encoder {
	encoder(@NotNull String key, int keyIndex, String str, String output) {
		var refArray = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
				"K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",
				"0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
				"(", ")", "*", "+", ",", "-", ".", "/",};
		
		if (key.matches(("^[A-Z0-9()*+,-./]$"))) {
			keyIndex = Arrays.asList(refArray).indexOf(key);
		} else {
			out.println("Invalid key");
			System.exit(1);
		}
		
		String[] rotatedArray = new String[refArray.length];
		for (int i = 0; i < refArray.length; i++) rotatedArray[i] = refArray[(i + keyIndex) % refArray.length];
		
		StringBuilder outputBuilder = new StringBuilder(output);
		for (int j = 0; j < str.length(); j++) {
			if (str.charAt(j) == ' ') outputBuilder.append(" ");
			else outputBuilder.append(refArray[Arrays.asList(rotatedArray).indexOf(str.substring(j, j + 1))]);
		}
		
		output = outputBuilder.toString();
		out.println("\nEncoded: " + output);
	}
}
