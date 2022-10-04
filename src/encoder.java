import org.jetbrains.annotations.NotNull;

import static java.lang.System.err;
import static java.lang.System.out;
import static java.util.Arrays.asList;

public class encoder {
	
	encoder(@NotNull String key, int keyIndex, String str, String output) {
		
		var refTable = new refTable();
		String[] refArray = refTable.getRefArray();
		
		if (key.matches(("^[A-Z0-9()*+,-./]$"))) keyIndex = asList(refArray).indexOf(key);
		else {
			err.println("Invalid key");
			System.exit(1);
		}
		
		
		String[] rotatedArray = new String[refArray.length];
		for (int i = 0; i < refArray.length; i++) rotatedArray[i] = refArray[(i + keyIndex) % refArray.length];
		
		StringBuilder outputBuilder = new StringBuilder(output);
		for (int j = 0; j < str.length(); j++) {
			if (str.charAt(j) == ' ') outputBuilder.append(" ");
			else outputBuilder.append(refArray[asList(rotatedArray).indexOf(str.substring(j, j + 1))]);
		}
		
		output = outputBuilder.toString();
		out.println("\nEncoded: " + output);
	}
}