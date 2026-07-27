package comSingleton.infra;

import comSingleton.domain.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UserRepositoryMemory implements UserRepository {

    private static UserRepositoryMemory instance;

    private Map<String, User> users =  new HashMap<>();

    public UserRepositoryMemory() {
    }

    public static UserRepositoryMemory getInstance() {
        if (instance == null) {
            instance = new UserRepositoryMemory();
        }
        return instance;
    }

    @Override
    public void save(User user) {
        users.put(user.getEmail(), user);
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return Optional.ofNullable(users.get(email));
    }
}
