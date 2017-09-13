package gpms.utils;

/**
 * Used for validating strings that the user of the application will pass in.
 * 
 * @author Patrick Chapman
 * @date 3/23/17
 *
 * @update 7/13/2017 2:05 PM
 * Added validation  for numeric-only and usernames.
 */
public class UserInputValidator {
	
	/**@author Patrick Chapman
	 * 
	 * Generic validation for user inputs. Does not allow for common 
	 * XSS characters and tags.
	 * 
	 * @param userInput, input string to be validated
	 * @param length, the length of the string to be validated
	 * @throws Exception, if the string does not meet the username requirements
	 */
	public void validateInput(String userInput, int length) throws Exception{
		System.out.println(userInput);
		String userInputCopy = userInput.toLowerCase();
		//Allow alpha-numeric, punctuation, and whitespace
		if(!userInputCopy.matches("^[a-zA-Z0-9,;.?!()\\s]*$") ||
		userInputCopy.contains("script")){
			throw new ValidationException("Invalid characters passed in.");
		}
		
		if((userInputCopy.length() > length) || (userInputCopy.length()) == 0){
			throw new ValidationException("Field does not contain the right amount of characters!");
		}
	}	
	
	/**@author Patrick Chapman
	 * 
	 * Validates user input for a field that is only allowed numeric
	 * values.
	 * 
	 * @param userInput, input string to be validated
	 * @param length, the length of the string to be validated
	 * @throws Exception, if the string does not meet the username requirements
	 */
	public void validateNumberInput(String userInput, int length) throws Exception{
		System.out.println(userInput);
		String userInputCopy = userInput.toLowerCase();
		//Allow numbers only
		if(!userInputCopy.matches("^[0-9,.\\s]*$")){
			throw new ValidationException("Input may only contain numbers!");
		}
		if((userInputCopy.length() > length) || (userInputCopy.length() == 0)){
			throw new ValidationException("Fields do not contain the right amount of numbers!");
		}
	}
	
	/**@author Patrick Chapman
	 * 
	 * Validates the username input from a user.
	 * 
	 * @param userInput, input string to be validated
	 * @param length, the length of the string to be validated
	 * @throws Exception, if the string does not meet the username requirements
	 */
	public void validateUsernameInput(String userInput, int length) throws Exception{
		System.out.println(userInput);
		String userInputCopy = userInput.toLowerCase();
		//Allow alpha-numeric ONLY for the usernames
		if(!userInputCopy.matches("^[a-zA-z0-9]*$") ||
		userInputCopy.contains("script")){
			throw new ValidationException("Invalid characters passed in Username field.");
		}
		
		if((userInputCopy.length() > length) || (userInputCopy.length()) == 0){
			throw new ValidationException("Field does not contain the right amount of characters!");
		}
	}
	
	/**@author Patrick Chapman
	 * 
	 * Validates the date input from a user.
	 * 
	 * @param userInput, input string to be validated
	 * @param length, the length of the string to be validated
	 * @throws Exception, if the string does not meet the username requirements
	 */
	public void validateDateInput(String userInput, int length) throws Exception{
		System.out.println("tes: " + userInput);
		//Allow only date characters
		if(!userInput.matches("^[-a-zA-Z0-9:/\\s]*$") ||
		userInput.contains("script")){
			throw new ValidationException("Date field contains illegal characters.");
		}
		
		if((userInput.length() > length) || (userInput.length()) == 0){
			throw new ValidationException("Date field contains too many characters!");
		}
	}
}
