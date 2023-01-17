package ru.kirillnsb.otk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kirillnsb.otk.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByLoginAndPassword(String login, String password);
    Optional<User> findByLogin(String login);
    Optional<User> findById(Long employee_id);


}
