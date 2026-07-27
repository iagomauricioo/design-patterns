package semSingletonComDI.application;

import semSingletonComDI.domain.User;
import semSingletonComDI.infra.UserRepository;
import semSingletonComDI.infra.UserRepositoryMemory;

public class Login {

    private final UserRepository userRepository;

    public Login(UserRepository userRepository) {
        this.userRepository = userRepository;
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
