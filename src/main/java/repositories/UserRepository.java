package repositories;

import models.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository {
    List<UserEntity> findAll();
    UserEntity findByUsername(String username);
}
