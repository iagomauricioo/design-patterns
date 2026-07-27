package comSingleton.infra;

import comSingleton.domain.User;

import java.util.Optional;

public interface UserRepository {
    public void save(User user);
    public Optional<User> getUserByEmail(String email);
}
