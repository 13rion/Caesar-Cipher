/**
 * CS 240
 * @author Samuel Baskerville
 *
 */
class Cipher {
	/**
	 * A field of type String. Represents the plaintext given by the user. It will be set
	 * in the shift method after the user is prompted for a phrase by the program.
	 */
	private String plaintext;
	/**
	 * This integer field represents the shift value that will be given by the user. It will 
	 * be set in the shift method after the user is prompted for the shift value
	 */
	private int shift;
	/**
	 * This field is an array of char values. It will contain the plaintext values.
	 */
	private char chars[];
	
	/**
	 * Parameters: String S, int x
	 * 
	 * This method is String, it will return a char array converted into a String. It receives two variables from 
	 * the ui.shift method, that are the users' phrase and shift value. It will assign these to their respective variable, 
	 * and uses .toCharArray() to change the plaintext value into a char array.
	 * 
	 * It will get the values within the array via a for loop and shift the value by the given amount
	 * by adding to the char value and looping around when needed. After shifting it will overwrite the previous
	 * non-shifted value with the shifted value.
	 * 
	 * Returns: String chars
	 */
	public String encrypt(String s, int x) {
		plaintext = s;
		chars = plaintext.toCharArray();
		shift = x;
		
		while(shift > 26) {	
			shift -= 26;
		}

		for(int i = 0; i < chars.length; i++) {
			char letter = chars[i];
			if(letter != 32) {
				letter = (char) (letter + shift);

				if(letter > 122) {
					int num = letter - 122;
					letter = (char)(96 + num);
				}
			}
			chars[i] = letter;
		}
		return new String(chars);
	}
	
	/**
	 * Parameters: String S
	 * 
	 * This method is String, it will return a char array converted into a String. It receives two variables from 
	 * the ui.shift method, that are the users' phrase and shift value. It will assign these to their respective variable, 
	 * and uses .toCharArray() to change the plaintext value into a char array.
	 * 
	 * It will get the values within the array via a for loop and shift the value by the given amount
	 * by subtracting the char value and looping around when needed. After shifting it will overwrite the previous
	 * non-shifted value with the shifted value.
	 * 
	 * Returns: String chars
	 */
	public String decrypt(String s) {
		plaintext = s;
		chars = plaintext.toCharArray();

		for(int i = 0; i < chars.length; i++) {
			char letter = chars[i];
			if(letter != 32) {
				letter = (char) (letter - shift);

				if(letter < 97) {
					int num = 96 - letter;
					letter = (char)(122 - num);
				}
			}
			chars[i] = letter;
		}
		return new String(chars);
	}
}
