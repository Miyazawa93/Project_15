import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FileClass {
	
	private FileReader reader;
	private Utility utility = new Utility(); 
	public HashMap <Integer, InputFromSensor> data = new HashMap<Integer, InputFromSensor>();
	public List<String> errorLog = new ArrayList<>(); 
	
	public FileClass(FileReader reader) {
		this.reader = reader; 
	}
	public boolean openFile(String fileName){
		return reader.openFile(fileName); 
	}
	public String readFile(){
		return reader.readLine(); 
	}
	public String[] checkInput(String collectedData){
		String [] arguments = collectedData.split("\\s+");
		if (arguments.length != 4 || arguments.length == 0) {
			throw new IllegalArgumentException("Illegal number of arguments");
		}
		return arguments;
	}
	public String calculate(String firstValue, String secondValue, String operator){
		String result = ""; 
		if (operator.equals("1"))
			result =  utility.bitwise_AND_Operation(firstValue, secondValue); 
		else if (operator.equals("2"))
			result = utility.bitwise_OR_Operation(firstValue, secondValue);
		return result; 
	}
	public void createInput(String keyHexValue, String operator, String firstInput, String secondInput){
		if(data.containsKey(utility.convertHexToIntResult(keyHexValue)))
			saveError(keyHexValue + " " + operator + " " + firstInput + " " + secondInput);
		else if( operator.equals("1") || operator.equals("2")){
			InputFromSensor input = new InputFromSensor(firstInput, secondInput, operator); 
			int key = utility.convertHexToIntResult(keyHexValue); 
			data.put(key,input); 
		}
		saveError(keyHexValue + " " + operator + " " + firstInput + " " + secondInput);
	}
	private void saveError( String line ) {
		errorLog.add(line);
	}
	public List<String> getErrors(){
		return errorLog;
	}
	
	public class InputFromSensor{
		private String firstSensor, secondSensor, result; 
		private Integer resultInteger; 

		public InputFromSensor(String firstValue, String secondValue, String operator){
			this.firstSensor = firstValue;  
			this.secondSensor = secondValue; 
			calculate(firstValue, secondValue, operator);
			convert(firstValue, secondValue); 
		}

		private void convert(String firstValue, String secondValue) {
			utility.convertBinaryToInt(firstValue); 
			utility.convertBinaryToInt(secondValue);
			resultInteger = utility.convertBinaryToInt(result);
		}

		public void calculate(String firstValue, String secondValue, String operator) {
			if (operator.equals("1"))
				result = utility.bitwise_AND_Operation(firstValue, secondValue);
			else if (operator.equals("2"))
				result = utility.bitwise_OR_Operation(firstValue, secondValue); 
			else{
				throw new IllegalArgumentException(); 
			}
		}

		public boolean checkEquality(Object check){
			if(firstSensor.equals(((InputFromSensor) check).firstSensor) && secondSensor.equals(((InputFromSensor) check).secondSensor));
			return true; 
		}
		public String getFirst(){return firstSensor;}
		public String getSecond(){return secondSensor;}
		public String getResult(){return result;}
		public String getFirstSensor(){return firstSensor;}
		public String getSecondSensor(){return secondSensor;}
		public Integer getResultInteger(){return resultInteger;}	
	}
}