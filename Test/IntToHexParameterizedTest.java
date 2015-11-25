import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class IntToHexParameterizedTest {
	
	private String hex;
	private int decimal;
	
	public IntToHexParameterizedTest(String decimal, String hex){
		this.decimal = Integer.parseInt(decimal);
		this.hex = hex;
	}
	
	@Parameterized.Parameters
	public static java.util.Collection< String[] > input() {
		return java.util.Arrays.asList( new String[][]{
				{"154", "9A"},
				{"1007", "3ef"},
				{"2426", "97a"},
				{"9148", "23bc"},
				{"380263", "5cd67"},
				{"7903933", "789abd"}
				
		});
	}
	
	@Test
	public void convertIntToHex() {
		Utility utility = new Utility(); 
		int converted = utility.convertHexToIntResult(hex); 
		assertEquals(decimal, converted);	
	} 
}
