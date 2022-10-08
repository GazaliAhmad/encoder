import org.jetbrains.annotations.NotNull;
import java.util.Arrays;
import static java.lang.System.exit;
import static java.lang.System.out;
import static java.util.Arrays.asList;

public class decoder {
	
	@SuppressWarnings("ReassignedVariable")
	decoder(@NotNull String key, String codePhrase) {
		
		final var refTable = new refTable();
		var refArray = refTable.getRefArray();
		var keyIndex = asList(refArray).indexOf(key);
		
		var rotatedArray = new String[refArray.length];
		var i = 0;
		while (i < refArray.length) {
			rotatedArray[i] = refArray[(i + keyIndex) % refArray.length];
			i++;
		}
		
		var decodedText = new StringBuilder();
		var j = 0;
		while (j < codePhrase.length()) {
			if (codePhrase.charAt(j) == ' ') decodedText.append(" ");
			else decodedText.append(rotatedArray[Arrays.asList(refArray).
					indexOf(codePhrase.substring(j, j + 1))]);
			j++;
		}
		
		out.println("\nDecoded: " + decodedText);
		out.println("\nThank you for using a simple Caesar Cipher Encoder/Decoder!");
		exit(0);
	}
}
