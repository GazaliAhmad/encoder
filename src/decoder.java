import org.jetbrains.annotations.NotNull;
import java.util.Arrays;
import static java.lang.System.err;
import static java.lang.System.out;

public class decoder {
	decoder(@NotNull String key, int keyIndex, String str, String output) {
		var refTable = new refTable();
		String[] refArray = refTable.getRefArray();
		
		if (key.matches(("^[A-Z0-9()*+,-./]$"))) {
			keyIndex = Arrays.asList(refArray).indexOf(key);
		} else {
			err.println("Invalid key");
			System.exit(1);
		}
		
		String[] rotatedArray = new String[refArray.length];
		for (int i = 0; i < refArray.length; i++) {
			rotatedArray[i] = refArray[(i + keyIndex) % refArray.length];
		}
		
		StringBuilder outputBuilder = new StringBuilder(output);
		for (int j = 0; j < str.length(); j++) {
			if (str.charAt(j) == ' ') outputBuilder.append(" ");
			else {
				outputBuilder.append(rotatedArray[Arrays.asList(refArray).indexOf(str.substring(j, j + 1))]);
			}
		}
		
		output = outputBuilder.toString();
		out.println("\nDecoded: " + output);
	}
}
	