class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

class UserNotFoundException extends Exception {
    public UserNotFoundException(String message) {
        super(message);
    }
}
class UserService {
    public void findUser(String username) throws UserNotFoundException {
        if (!"admin".equals(username)) {
            throw new UserNotFoundException("User not found: " + username);
        }
    }
}
public class CheckedException {
    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age must be 18 or older.");
        }
    }
    public static void main(String[] args) {
        UserService userService = new UserService();
        try {
            validateAge(19);
            userService.findUser("guest");
        } catch (InvalidAgeException e) {
            System.out.println("Caught InvalidAgeException: " + e.getMessage());
        } catch (UserNotFoundException e) {
            System.out.println("Caught UserNotFoundException: " + e.getMessage());
        }
    }
}
