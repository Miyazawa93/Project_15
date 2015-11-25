import static org.junit.Assert.*;
import org.junit.runners.Parameterized;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Parameterized.class)
public class BinaryToIntParameterizedTest {

	private String binary;
	private int decimal;
	
	public BinaryToIntParameterizedTest(String binary, String decimal){
		this.binary = binary;
		this.decimal = Integer.parseInt(decimal);	
	}
	
	@Parameterized.Parameters
	public static java.util.Collection< String[] > input() {
		return java.util.Arrays.asList( new String[][]{
				{"0", "0"},
				{"1101", "13"},
				{"11010101", "213"},
				{"1010100010000101000", "345128"},
				{"10100010001010101", "83029"},
				{"101000000010100", "20500"}
				
		});
	}
	@Test
	public void binaryToInt(){
		Utility utility = new Utility(); 
		int converted = utility.convertBinaryToInt(binary); 
		assertEquals(decimal, converted);
	}
}
