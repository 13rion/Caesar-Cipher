/**
 * CS 240
 * @author Samuel Baskerville
 *
 */
import java.util.Scanner;

class UI {
	/**
	 * A Scanner that will receive the inputs from the user when prompted.
	 */
	private Scanner input;
	/**
	 * A field of type String. Represents the plaintext given by the user. It will be set
	 * in the inputs method when the user is prompted for a phrase by the program.
	 */
	private String s;
	/**
	 * A field of type Integer. Represents the shift value that will be given by the user. It
	 * will be set when the user is prompted for a shift value by the program.
	 */
	private int x;
	/**
	 * A field of type Cipher. Represents the Cipher class.
	 */
	private Cipher cipher;
	/**
	 * This field will contain the return value from the encrypt method in the Cipher class.
	 */
	private String encrypted;
	
	/**
	 * This field will contain the return value from the decrypt method in the Cipher class.
	 */
	private String decrypted;
	
	/**
	 * The default constructor for the UI class. It instantiates and assigns
	 * the Scanner and Cipher classes. It also calls upon the inputs method.
	 */
	public UI() {
		input = new Scanner(System.in);
		cipher = new Cipher();
		inputs();
	}
	
	/**
	 * This method is void, it returns nothing. It will prompts the user for input, and get and assign the
	 * input it receives to the String s and int x variables.
	 * The input will then be sent to the Cipher class and the return value assigned to value.
	 * The method will end with value being looped over to display the return value.
	 */
	public void inputs() {
		System.out.println("Enter a phrase: ");
		//Get Phrase
		s = input.nextLine();
		System.out.println("Enter a number: ");
		//Get Shift Value
		x = input.nextInt();
		//Get returned text with values shifted correctly
		encrypted = cipher.encrypt(s,x);
		//Get returned text with values shifted correctly
		decrypted = cipher.decrypt(encrypted);
		//Prints the return value
		System.out.println(encrypted);
		System.out.println(decrypted);
	}
}
