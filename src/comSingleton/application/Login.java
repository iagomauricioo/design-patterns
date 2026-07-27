package comSingleton.application;

import comSingleton.domain.User;
import comSingleton.infra.UserRepository;
import comSingleton.infra.UserRepositoryMemory;

public class Login {

    private final UserRepository userRepository;

    public Login() {
        this.userRepository = UserRepositoryMemory.getInstance();
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
