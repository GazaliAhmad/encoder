import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class refTable {
	
	@Contract(value = " -> new", pure = true)
	String @NotNull [] getRefArray() {
		return new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
				"K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",
				"0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
				"(", ")", "*", "+", ",", "-", ".", "/",};
	}
}
