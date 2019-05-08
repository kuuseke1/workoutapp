package hello.dao;

import java.util.Optional;

import hello.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * User repository for CRUD operations.
 */
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUsername(String username);
}
