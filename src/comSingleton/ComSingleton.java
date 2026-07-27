package comSingleton;

import comSingleton.application.Login;
import comSingleton.application.Signup;
import comSingleton.domain.User;
import comSingleton.infra.UserRepository;
import comSingleton.infra.UserRepositoryMemory;

public class ComSingleton {
    public static void main(String[] args) {

        UserRepository userRepository = UserRepositoryMemory.getInstance();

        Signup signup = new Signup();
        Login login = new Login();

        User user = new User("iago@email.com", "senha123");
        signup.execute(user.getEmail(), user.getPassword());
        login.execute(user.getEmail(), user.getPassword());

        System.out.println("Usuário: " + userRepository.getUserByEmail(user.getEmail()).get().getEmail());
    }
}
