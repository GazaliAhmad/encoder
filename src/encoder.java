import org.jetbrains.annotations.NotNull;
import static java.lang.System.exit;
import static java.lang.System.out;
import static java.util.Arrays.asList;

public class encoder {
	
	encoder(@NotNull String key, String codePhrase) {
		
		final var refTable = new refTable();
		var refArray = refTable.getRefArray();
		int keyIndex = asList(refArray).indexOf(key);
		
		var rotatedArray = new String[refArray.length];
		int i = 0;
		while (i < refArray.length) {
			rotatedArray[i] = refArray[(i + keyIndex) % refArray.length];
			i++;
		}
		
		var encodedText = new StringBuilder();
		int j = 0;
		while (j < codePhrase.length()) {
			if (codePhrase.charAt(j) == ' ') encodedText.append(" ");
			else encodedText.append(refArray[asList(rotatedArray).
					indexOf(codePhrase.substring(j, j + 1))]);
			j++;
		}
		
		out.println("\nEncoded: " + encodedText);
		out.println("\nThank you for using a simple Caesar Cipher Encoder/Decoder!");
		exit(0);
	}
}

