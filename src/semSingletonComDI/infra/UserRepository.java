package semSingletonComDI.infra;

import semSingletonComDI.domain.User;

import java.util.Optional;

public interface UserRepository {
    public void save(User user);
    public Optional<User> getUserByEmail(String email);
}
