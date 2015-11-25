import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class FileClass {

	private FileReader reader;
	private Utility utility; 
	private Map< String, InputFromSensor > input;
	private List< InputFromSensor > duplicates;

	public FileClass(FileReader reader) {
		this.reader = reader; 
		input = new HashMap<>();
		duplicates = new ArrayList<>();
	}
	public boolean openFile(String fileName){
		return reader.openFile(fileName); 
	}
	public void readFile(){
		String collectedString = readLine(); 
		while(collectedString != null){
			saveResults(collectedString);
		}		
	}
	public void setReader(FileReader reader){
		this.reader = reader; 
	}
	public String readLine(){
		String collectedString =  reader.readLine(); 
		checkLength(collectedString);
		return collectedString; 
	}
	public InputFromSensor newInput(String[] token, String resultBinary) {
		return new InputFromSensor( token[1], token[2], token[3], utility.convertBinaryToInt(resultBinary), resultBinary);
	}
	public void save(String[] token, String resultBinary) {
		input.put(token[0], newInput(token, resultBinary));
	}
	public void saveResults(String collectedData) {
		String[] token = checkInput(collectedData); 
		String resultBinary = getResult(collectedData, token);

		if(input.containsKey(token[0]))
			duplicates.add(newInput(token, resultBinary)); 
		else if( resultBinary != null)
			save(token, resultBinary); 
	}
	public String getResult(String collectedData, String[] token) {
		return calculate(token[1], token[2], token[3]); 
	}
	public String[] checkInput(String collectedData){
		StringTokenizer stringTokenizer = new StringTokenizer(collectedData); 
		String [] data = new String[4]; 
		checkForMoreElements(stringTokenizer, data);
		return data; 
	}
	public void checkForMoreElements(StringTokenizer stringTokenizer, String[] data) {
		for(int i = 0; stringTokenizer.hasMoreElements(); i++)
			data[i] = stringTokenizer.nextToken(); 
		if(data.length != 4){
			throw new IllegalArgumentException("To many arguments"); 
		}
	}
	public void checkLength(String dataString){
		if(dataString.length() != 58 ) {
			throw new IllegalArgumentException("Not the right amount of tokens"); 
		}
	}
	public String calculate(String operator, String first, String last){
		checkAllowedOperator(operator); 
		String result =""; 
		if(operator == "1"){
			result = utility.bitwise_AND_Operation(first, last);
			return result; 
		}
		else 
			if(operator == "2"){
				result = utility.bitwise_OR_Operation(first, last);	
			}
		return result; 
	}
	public void checkAllowedOperator(String operator) {
		if ( !operator.matches( "[12]+" ) )
			throw new IllegalArgumentException( "Line contains illegal operator" );
	}
	public InputFromSensor getInput(String key){
		return input.get(key); 
	}
	public List<InputFromSensor> getDuplicates(){
		return duplicates; 
	} 
	public FileReader getReader(){
		return reader; 
	}
}

class InputFromSensor{
	private String first, second, resultBinary, operator;
	private Integer resultInteger; 

	public InputFromSensor(String first, String second, String resultBinary, Integer resultInteger, String operator){
		this.first = first; 
		this.second = second; 
		this.resultBinary = resultBinary; 
		this.resultInteger = resultInteger; 
		this.operator = operator; 
	}
	public String getFirst(){return first;}
	public String getSecond(){return second;}
	public String getResultBinary(){return resultBinary;}
	public Integer getResultInteger(){return resultInteger;}
	public String getOperator(){return operator;}	
}