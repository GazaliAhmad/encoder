import org.jetbrains.annotations.NotNull;
import java.util.Arrays;
import static java.lang.System.out;
import static java.util.Arrays.asList;

public class decoder {
	
	decoder(@NotNull String key, String codePhrase) {
		
		var refTable = new refTable();
		String[] refArray = refTable.getRefArray();
		int keyIndex = asList(refArray).indexOf(key);
		
		String[] rotatedArray = new String[refArray.length];
		for (int i = 0; i < refArray.length; i++) rotatedArray[i] = refArray[(i + keyIndex) % refArray.length];
		
		StringBuilder decodedText = new StringBuilder();
		for (int j = 0; j < codePhrase.length(); j++) {
			if (codePhrase.charAt(j) == ' ') decodedText.append(" ");
			else decodedText.append(rotatedArray[Arrays.asList(refArray).indexOf(codePhrase.substring(j, j + 1))]);
		}
		
		out.println("\nDecoded: " + decodedText);
	}
}
