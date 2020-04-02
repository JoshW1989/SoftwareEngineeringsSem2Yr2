package Users;

public class WrongUserException extends Exception{
	
	// Thrown when an incorrect user is added as an employee
    public WrongUserException (String errorMessage) {
        super(errorMessage);
    }

}
