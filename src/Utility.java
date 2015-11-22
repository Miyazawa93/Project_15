
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
	public int convertHexToInt(String string) {
		checkInput(string, constant.ALLOWED_TOKENS_HEX );
		String digits =  "0123456789ABCDEF";
        string = string.toUpperCase();
        int converted = 0;
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            int d = digits.indexOf(c);
            converted = 16*converted + d;
        }
        return converted;
	}
	public String convertIntToHex(int integer){
		 String digits = "0123456789ABCDEF";
		 String converted = "";
	        while (integer > 0) {
	            int digit = integer % 16;             
	            converted = digits.charAt(digit) + converted;
	            integer = integer / 16;
	        }
	        return converted;
	    }
}
