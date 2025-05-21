class InvalidAgeException extends RuntimeException {
    public InvalidAgeException(String message) {
        super(message);
    }
}

class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}

class UserService {
    public void findUser(String username) {
        if (!"admin".equals(username)) {
            throw new UserNotFoundException("User not found: " + username);
        }
    }
}

public class UncheckedException {
    public static void validateAge(int age) {
        if (age < 18) {
            throw new InvalidAgeException("Age must be 18 or older.");
        }
    }

    public static void main(String[] args) {
        UserService userService = new UserService();
        try {
            validateAge(16);
            userService.findUser("guest");
        } catch (InvalidAgeException e) {
            System.out.println("Caught InvalidAgeException: " + e.getMessage());
        } catch (UserNotFoundException e) {
            System.out.println("Caught UserNotFoundException: " + e.getMessage());
        }
    }
}
