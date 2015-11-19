import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class UtilityTest {
	
/*	Bitstrenger:
		En streng som har andre tegn enn 0 og 1 skal forårsake at en IllegalArgumentException kastes
		Du skal kunne sende inn en streng med 0 og 1 (kun), heretter kalt bitstreng, og få returnert
		korresponderende int verdi
		Du skal kunne sende inn en int og få returnert den som en bitstreng med lengde 24*/
	public Utility utility;	
	public ExpectedException exception = ExpectedException.none(); 
	
	@Before
	public void setUp (){
		utility = new Utility();	
	}
	
	
	@Test
	public void testLengthOfString_shouldReturnNull(){
		assertEquals("0", utility.isItEmpty(""));		
	}
	@Test
	public void testLengthOfString() {
		assertTrue(utility.getLength("01011")); 
	}

	@Test  (expected = IllegalArgumentException.class)
	public void testLengthOfString_LongerThan24_IllegalArgumentException(){
		utility.getLength("010101010101010101010101011101"); 
		exception.expectMessage("Number of bits exceeds maximum allowed");	
	}
	@Test
	public void convertBinaryToInt(){
		assertEquals(0, utility.convertBinaryToInt("0")); 
		assertEquals(13, utility.convertBinaryToInt("1101")); 
		assertEquals(213, utility.convertBinaryToInt("11010101"));
	}
	@Test
	public void convertIntToBinary(){
		assertEquals("000000000000000000000000", utility.convertIntToBinary(0)); 
		assertEquals("000000000000000011010101", utility.convertIntToBinary(213)); 
	}
}
