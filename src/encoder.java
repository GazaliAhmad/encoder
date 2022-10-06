import org.jetbrains.annotations.NotNull;
import static java.lang.System.out;
import static java.util.Arrays.asList;

public class encoder {
	
	encoder(@NotNull String key, String codePhrase) {
		
		var refTable = new refTable();
		String[] refArray = refTable.getRefArray();
		int keyIndex = asList(refArray).indexOf(key);
		
		String[] rotatedArray = new String[refArray.length];
		for (int i = 0; i < refArray.length; i++) rotatedArray[i] = refArray[(i + keyIndex) % refArray.length];
		
		StringBuilder encodedText = new StringBuilder();
		for (int j = 0; j < codePhrase.length(); j++) {
			if (codePhrase.charAt(j) == ' ') encodedText.append(" ");
			else encodedText.append(refArray[asList(rotatedArray).indexOf(codePhrase.substring(j, j + 1))]);
		}
		
		out.println("\nEncoded: " + encodedText);
		
	}
}
