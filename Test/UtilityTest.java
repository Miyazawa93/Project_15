import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class UtilityTest {
	
	public Utility utility;	
	private String first = "100110101011101101011001";
	private String last =  "010100010010110010011101";
	
	@Rule
	public ExpectedException thrown = ExpectedException.none(); 
	
	@Before
	public void setUp (){ 
		utility = new Utility();	
	}
	@Test
	public void testLengthOfString_shouldReturnNull(){
		assertEquals(0, utility.checkLength(""));		
	}
	@Test 
	public void isEmpty_shouldReturnLengthOfString(){
		assertEquals(5, utility.checkLength("Hello"));
	}
	@Test
	public void testLengthOfString_LongerThan24_IllegalArgumentException(){
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Number of bits exceeds maximum allowed");
		utility.checkBitLength("010101010101010101010101011101"); 
	}
	@Test
	public void convertBinaryToInt_0_shouldReturn0(){
		assertEquals(0, utility.convertBinaryToInt("0")); 
	}
	@Test  
	public void convertBinaryToInt_1101_shouldReturn13(){
		assertEquals(13, utility.convertBinaryToInt("1101"));		
	}
	@Test
	public void convertBinaryToInt_11010101_shouldReturn213(){
		assertEquals(213, utility.convertBinaryToInt("11010101"));
	}
	@Test
	public void convertIntToBinary_0_shouldReturn0x24(){
		assertEquals("000000000000000000000000", utility.convertIntToBinary(0)); 
	}
	@Test
	public void convertIntToBinary_213_shouldReturn_000000000000000011010101(){
		assertEquals("000000000000000011010101", utility.convertIntToBinary(213)); 
	}
	@Test  
	public void checkInput_shouldReturnIllegalArgumentException(){
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Input not allowed");
		utility.checkInput("5", constant.ALLOWED_TOKENS_BINARY); 
	}
	@Test 
	public void checkHexLength_longerThan6_IllegalArgumentException(){
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Illegal number of input");
		utility.checkHexLength("1234567"); 
	}
	@Test
	public void checkHexLength_lessThan6_IllegalArgumentException(){
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Illegal number of input");
		utility.checkHexLength("123"); 
	}
	@Test 
	public void checkInput_5G_illegalArgumentException(){
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Input not allowed");
		utility.checkInput("5G", constant.ALLOWED_TOKENS_HEX);
	}
	@Test 
	public void checkInput_IllegalTokens_illegalArgumentException(){
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Input not allowed");
		utility.checkInput("ghj", constant.ALLOWED_TOKENS_HEX);
	}
	@Test
	public void convertHexToInt_9A_shouldReturn_154(){
		assertEquals(154, utility.convertHexToIntResult("9A"));  
	}
	@Test
	public void convertHexToInt_B6_shouldReturn_182(){
		assertEquals(182, utility.convertHexToIntResult("B6")); 
	}
	@Test
	public void convertIntToHex_154_shouldReturn_9A(){
		assertEquals("9A", utility.convertIntToHex(154));
	}
	@Test 
	public void convertIntToHex_182_shouldReturn_B6(){
		assertEquals("B6", utility.convertIntToHex(182)); 
	}
	@Test 
	public void bitwiseANDOperation_shouldReturn_000100000010100000011001(){
		assertEquals("000100000010100000011001", utility.bitwise_AND_Operation(first, last));
	}
	@Test
	public void bitwiseANDOperation_shouldReturn_000000000000000000000000(){
		assertEquals("000000000000000000000000", utility.bitwise_AND_Operation("101010101010001111010101", "000000000000000000000000"));
	}
	@Test 
	public void bitwiseANDOperation_shouldReturn_IllegalArgumentException(){
		assertEquals("111111111111111111111111", utility.bitwise_OR_Operation("101010101010001111010101", "000000000000000000000000")); 
	}
	@Test
	public void bitWise_AND_Operation_shouldReturn_101010101010001111010101(){
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Number of bits exceeds maximum allowed");
		utility.bitwise_AND_Operation("101010101010001111010101000000000000", "000000000000000000000000"); 
	}
	@Test 
	public void bitwise_OR_Operation_shouldReturn_110110111011111111011101(){
		assertEquals("111111111111111111111111", utility.bitwise_OR_Operation(first, last));
	}
	@Test
	public void bitWise_OR_Operation_shouldReturn_101010101010001111010101(){
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Number of bits exceeds maximum allowed");
		utility.bitwise_OR_Operation("101010101010001111010101000000000000", "000000000000000000000000"); 
	}
}