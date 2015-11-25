import java.util.LinkedHashMap;

public class FileClass {
	
	private FileReader reader;
	private Utility utility = new Utility(); 
	public LinkedHashMap <Integer, InputFromSensor> data = new LinkedHashMap<Integer, InputFromSensor>();

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
		checkLength(arguments);
		return arguments;
	}
	private void checkLength(String[] arguments) {
		if (arguments.length != 4 || arguments.length == 0) {
			throw new IllegalArgumentException("Illegal number of arguments");
		}
	}
	public boolean createInput(String keyHexValue, String firstInput, String secondInput, String operator){
		int key = utility.convertHexToIntResult(keyHexValue); 
		InputFromSensor input = new InputFromSensor(firstInput, secondInput, operator); 
		return checkForDuplicates(key, input); 
	}
	private boolean checkForDuplicates(int key, InputFromSensor input) {
		if (!data.containsKey(key))
			data.put(key, input);
		else
			return false;
		return true;
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

		private void calculate(String firstValue, String secondValue, String operator) {
			if (operator.equals("1"))
				result = utility.bitwise_OR_Operation(firstValue, secondValue);
			else if (operator.equals("2"))
				result = utility.bitwise_AND_Operation(firstValue, secondValue);
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