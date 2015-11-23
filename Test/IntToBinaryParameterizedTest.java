import static org.junit.Assert.*;

import org.junit.runners.Parameterized;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Parameterized.class)
public class IntToBinaryParameterizedTest {

	private String binary;
	private int decimal;
	
	public IntToBinaryParameterizedTest(String decimal, String binary){
		this.decimal = Integer.parseInt(decimal);
		this.binary = binary;		
	}
	
	@Parameterized.Parameters
	public static java.util.Collection< String[] > input() {
		return java.util.Arrays.asList( new String[][]{
				{"0",      "000000000000000000000000"},
				{"13",     "000000000000000000001101"},
				{"213",    "000000000000000011010101"},
				{"345128", "000001010100010000101000"},
				{"83029",  "000000010100010001010101"},
				{ "20500", "000000000101000000010100"}
				
		});
	}
	@Test
	public void IntToBinary(){
		Utility utility = new Utility(); 
		String converted = utility.convertIntToBinary(decimal); 
		assertEquals(binary, converted);
	}
}
