package semSingletonComDI.application;

import semSingletonComDI.domain.User;
import semSingletonComDI.infra.UserRepository;
import semSingletonComDI.infra.UserRepositoryMemory;

public class Signup {

    private final UserRepository userRepository;

    public Signup(UserRepository userRepository) {
        this.userRepository = userRepository;
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
