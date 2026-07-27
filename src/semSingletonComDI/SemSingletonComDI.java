package semSingletonComDI;

import semSingletonComDI.application.Login;
import semSingletonComDI.application.Signup;
import semSingletonComDI.domain.User;
import semSingletonComDI.infra.UserRepository;
import semSingletonComDI.infra.UserRepositoryMemory;

public class SemSingletonComDI {
    public static void main(String[] args) {

        UserRepository userRepository = new UserRepositoryMemory();

        Signup signup = new Signup(userRepository);
        Login login = new Login(userRepository);

        User user = new User("iago@email.com", "senha123");
        signup.execute(user.getEmail(), user.getPassword());
        login.execute(user.getEmail(), user.getPassword());

        System.out.println("Usuário: " + userRepository.getUserByEmail(user.getEmail()).get().getEmail());
    }
}
