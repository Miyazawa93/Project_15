
public class Utility {
	public static final int MAX_BIT_LENGTH = 24;
	public static final int MAX_HEX_LENGTH = 6; 

	public boolean checkLength(String string, int maxLength){
		if(string.length() < maxLength ){
			return true; 
		}
		else if(string.length() > maxLength){
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
		checkInput(binary);
		char [] numbers = binary.toCharArray(); 
		int converted = 0; 
		for(int i = numbers.length -1; i >= 0; i--)
			if(numbers[i]=='1')
				converted += Math.pow(2, (numbers.length-i - 1));
		return converted;
	}

	public static String convertIntToBinary(int integer) {
		StringBuilder string = new StringBuilder(""); 
		for(int i = 0; i < MAX_BIT_LENGTH; i++, integer/=2)
			string.append(integer % 2); 
		String converted = string.reverse().toString(); 
		return converted;		
	}

	public static void checkInput(String input) {
		if(!input.matches("[01]+"))
			throw new IllegalArgumentException("Wrong input"); 
	}
}
