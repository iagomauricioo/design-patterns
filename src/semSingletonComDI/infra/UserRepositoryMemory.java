package semSingletonComDI.infra;

import semSingletonComDI.domain.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UserRepositoryMemory implements UserRepository {

    private Map<String, User> users =  new HashMap<>();

    public UserRepositoryMemory() {
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
