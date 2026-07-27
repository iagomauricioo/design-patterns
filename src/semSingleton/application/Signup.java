package semSingleton.application;

import semSingleton.domain.User;
import semSingleton.infra.UserRepository;
import semSingleton.infra.UserRepositoryMemory;

public class Signup {

    private final UserRepository userRepository;

    public Signup() {
        this.userRepository = new UserRepositoryMemory();
    }

    public void execute(String email, String password) {
        if (userRepository.getUserByEmail(email).isPresent()) {
            throw new IllegalArgumentException("Email already exists");
        }

        User user = new User(email, password);

        userRepository.save(user);

        System.out.println("User created");
    }
}
