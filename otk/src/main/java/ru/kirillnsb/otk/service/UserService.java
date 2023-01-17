package ru.kirillnsb.otk.service;

import org.springframework.stereotype.Service;
import ru.kirillnsb.otk.model.User;
import ru.kirillnsb.otk.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(String login, String password, String email){
        if(login == null || password == null){
            return null;
        } else {
            if (userRepository.findByLogin(login).isPresent()) {
                System.out.println("Duplicate login");
                return null;
            }
            User user = new User();
            user.setLogin(login);
            user.setPassword(password);
            user.setEmail(email);
            return userRepository.save(user);
        }
    }
    public User currentUser;
    public User authUser(String login, String password){
        currentUser = userRepository.findByLoginAndPassword(login, password).orElse(null);
        return userRepository.findByLoginAndPassword(login, password).orElse(null);

    }
}
