
public class Utility {
	public final int MAX_BIT_LENGTH = 24; 

	public boolean getLength(String string) {
		if(string.length() < MAX_BIT_LENGTH ){
			return true; 
		}
		 else if(string.length() > 24){
			throw new IllegalArgumentException(); 
		}
		return false; 
}

	public Object isItEmpty(String string) {
		if(string.length() == 0){
			return 0; 
		}
		return null;
	}
}
