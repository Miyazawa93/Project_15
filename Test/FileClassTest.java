import static org.junit.Assert.*;

import org.junit.*;
import org.junit.rules.ExpectedException;
import static org.mockito.Mockito.*;

public class FileClassTest { 

	private String firstInput =  "100101010001010110101010"; 
	private String secondInput = "101001000101000100010111"; 
	private FileClass file; 
	private FileReader reader;
	private Utility utility; 

	@Rule
	public ExpectedException exception = ExpectedException.none(); 

	@Before
	public void setUp(){
		reader = mock(FileReader.class);
		file = new FileClass(reader);
		utility = new Utility(); 
	}

	@Test
	public void openFile_shouldBeAbleToOpenFile() {
		when(reader.openFile("fileName.txt")).thenReturn(true); 
		assertTrue(file.openFile("fileName.txt"));
		verify(reader, times(1)).openFile("fileName.txt");
	} 
	@Test 
	public void readFile(){
		when(reader.readLine()).thenReturn("03ac0f 1 110101000000110111001101 001000011110011101001111");
		String returnShouldBe = "03ac0f 1 110101000000110111001101 001000011110011101001111";
		assertEquals(returnShouldBe, reader.readLine()); 
		verify(reader, times(1)).readLine();
	}
	@Test 
	public void readLine(){
		when(reader.readLine()).thenReturn("ac0e1e 2 " + firstInput + " " + secondInput);
		assertEquals("ac0e1e 2 " + firstInput + " " + secondInput, file.readFile()); 
		verify(reader, times(1)).readLine(); 
	}
	@Test
	public void textLeft_assertTrue(){
		when(reader.textLeft("fileName.txt")).thenReturn(true); 
		assertTrue(reader.textLeft("fileName.txt"));
		verify(reader, times(1)).textLeft("fileName.txt"); 
	}
	@Test
	public void textLeft_assertFalse(){
		when(reader.textLeft("fileName.txt")).thenReturn(false); 
		assertFalse(reader.textLeft("fileName.txt"));
		verify(reader, times(1)).textLeft("fileName.txt"); 
	}
	@Test 
	public void checkInput_3Arguments_IllegalArgumentException(){
		String operatorMissing = "ac0e1e firstInput secondInput";
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Illegal number of arguments");
		file.checkInput(operatorMissing); 
	}
	@Test 
	public void checkInput_5Arguments_IllegalArgumentException(){
		String operatorMissing = "ac0e1e firstInput secondInput firstInput secondInut";
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Illegal number of arguments");
		file.checkInput(operatorMissing); 
	}
	@Test
	public void checkInput_0Argument_IllegalArgumentException(){
		String operatorMissing = "";
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Illegal number of arguments");
		file.checkInput(operatorMissing); 
	}
	@Test
	public void createInput_OR_Operator(){
		String key = "03ac0f";
		String operator = "1";
		file.createInput(key, firstInput, secondInput, operator); 
		FileClass.InputFromSensor input = file.data.get(utility.convertHexToIntResult(key));
		assertEquals("111111111111111111111111", input.getResult()); 
	}
	@Test
	public void createInput_AND_Operator(){
		String key = "ac0e1e";
		String operator = "2";
		file.createInput(key, firstInput, secondInput, operator); 
		FileClass.InputFromSensor input = file.data.get(utility.convertHexToIntResult(key));
		assertEquals("100001000001000100000010", input.getResult()); 
	}
}