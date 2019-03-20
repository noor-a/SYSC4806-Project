package repositories;

import models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository<T extends User> extends JpaRepository<User, Long> {
    List<User> findByUsername(String username);
}
