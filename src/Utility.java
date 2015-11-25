
public class Utility {

	public void checkBitLength(String string){
		if(string.length() > constant.MAX_BIT_LENGTH)
			throw new IllegalArgumentException("Number of bits exceeds maximum allowed"); 
	}
	public void checkHexLength(String string){
		if(string.length() > constant.MAX_HEX_LENGTH )
			throw new IllegalArgumentException("Maximum of hex exceeded");
	}

	public int checkLength(String string) {
		if(string.length() == 0){
			return 0;
		}
		return string.length();
	}
	public int convertBinaryToInt(String binary){
		checkInput(binary, constant.ALLOWED_TOKENS_BINARY);
		char [] numbers = binary.toCharArray(); 
		int converted = 0; 
		for(int i = numbers.length -1; i >= 0; i--)
			if(numbers[i]=='1')
				converted += Math.pow(2, (numbers.length-i - 1));
		return converted;
	}

	public String convertIntToBinary(int integer) {
		StringBuilder string = new StringBuilder(""); 
		for(int i = 0; i < constant.MAX_BIT_LENGTH; i++, integer/=2)
			string.append(integer % 2); 
		String converted = string.reverse().toString(); 
		return converted;		
	}

	public void checkInput(String input, String acceptedTokens){
		if(!input.matches(acceptedTokens))
			throw new IllegalArgumentException("Input not allowed"); 
	}

	public int convertHexToIntResult(String string){
		checkInput(string, constant.ALLOWED_TOKENS_HEX );
		return convertHexToInt(string.toUpperCase().toCharArray()); 
	}

	public int convertHexToInt(char [] charArray) {
		int converted = 0;
		for(char digit : charArray)
			converted = 16 * converted + constant.ALLOWED_TOKENS_HEXADECIMAL.indexOf(digit);
		return converted;
	}

	public String convertIntToHex(int integer){
		String digits = constant.ALLOWED_TOKENS_HEXADECIMAL; 
		String converted = "";
		while (integer > 0) {
			int digit = integer % 16;             
			converted = digits.charAt(digit) + converted;
			integer = integer / 16;
		}
		return converted;
	}
	public String bitwise_AND_Operation(String first, String last) {
		checkBitLength(first);
		checkBitLength(last);
		return bitwiseAndOperation( first.toCharArray(), last.toCharArray());
	}
	public String bitwiseAndOperation(char[] charArrayFirst, char[] charArrayLast) {
		StringBuilder string = new StringBuilder("");
		for(int i = 0; i < constant.MAX_BIT_LENGTH; i++){
			if(charArrayFirst[i] == '1' && charArrayLast[i] == '1'){
				string.append(1);
			}
			else 
				string.append(0); 
		}
		return string.toString();
	}
	public String bitwise_OR_Operation(String first, String last) {
		checkBitLength(first);
		checkBitLength(last);
		return bitwiseOrOperation(first.toCharArray(), last.toCharArray());
	}
	public String bitwiseOrOperation(char[] charArrayFirst, char[] charArrayLast) {
		StringBuilder string = new StringBuilder("");
		for(int i = 0; i < constant.MAX_BIT_LENGTH; i++){
			if(charArrayFirst[i] == '1' || charArrayLast[i] == '1'){
				string.append(1);
			}
			else 
				string.append(1); 
		}
		return string.toString(); 
	}
}

