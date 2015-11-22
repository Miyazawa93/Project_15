import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class UtilityTest {
	
/*	Bitstrenger:
		En streng som har andre tegn enn 0 og 1 skal forårsake at en IllegalArgumentException kastes
		Du skal kunne sende inn en streng med 0 og 1 (kun), heretter kalt bitstreng, og få returnert
		korresponderende int verdi
		Du skal kunne sende inn en int og få returnert den som en bitstreng med lengde 24*/
	public Utility utility;	
	
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
	public void testLengthOfString() {
		assertTrue(utility.getLength("01011")); 
	}
	@Test
	public void testLengthOfString_LongerThan24_IllegalArgumentException(){
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Number of bits exceeds maximum allowed");
		utility.getLength("010101010101010101010101011101"); 
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
	public void convertBinaryToInt_11010101_shouldReturn213(){ //Dele opp koden i flere tester
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
	
}
