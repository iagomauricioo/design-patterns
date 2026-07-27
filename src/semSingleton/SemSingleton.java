package semSingleton;

import semSingleton.application.Login;
import semSingleton.application.Signup;
import semSingleton.domain.User;
import semSingleton.infra.UserRepository;
import semSingleton.infra.UserRepositoryMemory;

/*
* 1. Injetar via construtor o UserRepository no Signup e Login
* 2. Criar uma instância no Main  UserRepository userRepository = new UserRepositoryMemory();
* 3. Passar no construtor dos 2 use cases
* 4. Deve sumir o "Exception in thread 'main' java.lang.RuntimeException: User not found"
*/
public class SemSingleton {
    public static void main(String[] args) {

        UserRepository userRepository = new UserRepositoryMemory();

        Signup signup = new Signup();
        Login login = new Login();

        User user = new User("iago@email.com", "senha123");
        signup.execute(user.getEmail(), user.getPassword());
        login.execute(user.getEmail(), user.getPassword());

        System.out.println("Usuário: " + userRepository.getUserByEmail(user.getEmail()).get().getEmail());
    }
}
