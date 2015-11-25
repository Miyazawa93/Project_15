import static org.junit.Assert.*;
import org.junit.*;
import org.junit.rules.ExpectedException;
import static org.mockito.Mockito.*;

public class FileClassTest { 
	
	private String firstInput =  "100101010001010110101010"; 
	private String secondInput = "101001000101000100010111"; 
	private FileClass file; 
	private FileReader reader; 
	public Utility utility; 
	
	@Rule
	public ExpectedException exception = ExpectedException.none(); 
	
	 
	@Before
	public void setUp(){
		reader = mock(FileReader.class);
		file = new FileClass(reader); 
	}

	@Test
	public void openFile() {
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
	public void setReader(){
		file.setReader(reader);
		assertEquals(reader, file.getReader()); 
	}
	@Test 
	public void readLine(){
		when(reader.readLine()).thenReturn("ac0e1e 2 " + firstInput + " " + secondInput);
		assertEquals("ac0e1e 2 " + firstInput + " " + secondInput,file.readLine()); 
		verify(reader, times(1)).readLine(); 
	}
	@Test
	public void readLine_IllegalArgumentException(){
		exception.expect( IllegalArgumentException.class );
		exception.expectMessage("Not the right amount of tokens");
		when(reader.readLine()).thenReturn("ac0e1e 256 " + firstInput + " " + secondInput);
		file.readLine(); 
	}
	@Test
	public void saveResult(){
		file.saveResults("ac0e1e 2 " + firstInput + " " + secondInput);
//		assertEquals("2", file.getInput("ac0e1e").getOperator());
		assertEquals("2", file.getInput("ac0e1e").getResultBinary());
	}

	@Test
	public void calculate_shouldReturn_(){
		assertEquals("1101001001", file.calculate("1", firstInput, secondInput));
	}
	@Test
	public void getReader(){
		assertEquals(reader, file.getReader()); 
	}
	
}