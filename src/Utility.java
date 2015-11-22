
public class Utility {
	public static final int MAX_BIT_LENGTH = 24;

	public boolean getLength(String string) {
		if(string.length() < MAX_BIT_LENGTH ){
			return true; 
		}
		else if(string.length() > MAX_BIT_LENGTH){
			throw new IllegalArgumentException("Number of bits exceeds maximum allowed"); 
		}
		return false; 
	}

	public static boolean isEmpty(String string) {
		if(string.length() == 0){
			return true; 
		}
		return false;
	}

	public static int convertBinaryToInt(String binary){
		char [] numbers = binary.toCharArray(); 
		int converted = 0; 
		for(int i = numbers.length -1; i >= 0; i--)
			if(numbers[i]=='1')
				converted += Math.pow(2, (numbers.length-i - 1));
		return converted;
	}

	public static String convertIntToBinary(int number) {
		StringBuilder string = new StringBuilder(""); 
		for(int i = 0; i < MAX_BIT_LENGTH; i++, number/=2)
			string.append(number % 2); 
		String converted = string.reverse().toString(); 
		return converted;		
	}
}
