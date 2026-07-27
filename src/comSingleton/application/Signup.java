package comSingleton.application;

import comSingleton.domain.User;
import comSingleton.infra.UserRepository;
import comSingleton.infra.UserRepositoryMemory;

public class Signup {

    private final UserRepository userRepository;

    public Signup() {
        this.userRepository = UserRepositoryMemory.getInstance();
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
