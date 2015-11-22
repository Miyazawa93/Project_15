import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/*Hex strenger:
En tom streng skal returnere 0
En streng som er lengre enn 6 skal forårsake at en IllegalArgumentException kastes
En streng som har andre tegn enn 01234567890ABCDEF / abcdef skal forårsake at en
IllegalArgumentException kastes*/


public class UtilityTest {
	
	public Utility utility;	
	public static final int MAX_BIT_LENGTH = 24;
	public static final int MAX_HEX_LENGTH = 6; 
	
	@Rule
	public ExpectedException thrown = ExpectedException.none(); 
	
	@Before
	public void setUp (){
		utility = new Utility();	
	}
	@Test
	public void testLengthOfString_shouldReturnNull(){
		assertTrue(utility.isEmpty(""));		
	}
	@Test
	public void testLengthOfString_LongerThan24_IllegalArgumentException(){
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Number of bits exceeds maximum allowed");
		utility.checkLength("010101010101010101010101011101", MAX_BIT_LENGTH); 
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
	public void convertIntToBinary_0_shouldReturn0x16(){
		assertEquals("000000000000000000000000", utility.convertIntToBinary(0)); 
	}
	@Test
	public void convertIntToBinary_213_shouldReturn_000000000000000011010101(){
		assertEquals("000000000000000011010101", utility.convertIntToBinary(213)); 
	}
	@Test 
	public void checkInput_shouldReturnIllegalArgumentException(){
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Wrong input");
		utility.checkInput("5"); 
	}
	@Test 
	public void checkLength_longerThan6_IllegalArgumentException(){
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Number of bits exceeds maximum allowed");
		utility.checkLength("1234567", MAX_HEX_LENGTH); 
	}
}
