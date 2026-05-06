package mk.ukim.finki.emt_lab1.repository;

import mk.ukim.finki.emt_lab1.model.User;  // ← твојот модел
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}