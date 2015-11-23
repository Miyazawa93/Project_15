import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class HexToIntParameterizedTest {
	
	private String hex;
	private int decimal;
	
	public HexToIntParameterizedTest(String hex, String decimal){
		this.hex = hex;
		this.decimal = Integer.parseInt(decimal);
		
	}
	@Parameterized.Parameters
	public static java.util.Collection< String[] > input() {
		return java.util.Arrays.asList( new String[][]{
				{"9A", "154"},
				{"3ef", "1007"},
				{"97a", "2426"},
				{"23bc", "9148"},
				{"5cd67", "380263"},
				{"789abd", "7903933"}
				
		});
	}
	
	@Test
	public void convertHexToInt() {
		Utility utility = new Utility(); 
		int converted = utility.convertHexToIntResult(hex); 
		assertEquals(decimal, converted);	
	}

}
