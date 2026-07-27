package semSingleton.application;

import semSingleton.domain.User;
import semSingleton.infra.UserRepository;
import semSingleton.infra.UserRepositoryMemory;

public class Login {

    private final UserRepository userRepository;

    public Login() {
        this.userRepository = new UserRepositoryMemory();
    }

    public void execute(String email, String password) {
        User user = userRepository.getUserByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Passwords don't match");
        }

        System.out.println("Login Successful");
    }
}
