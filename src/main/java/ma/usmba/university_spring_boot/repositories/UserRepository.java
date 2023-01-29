package ma.usmba.university_spring_boot.repositories;

import ma.usmba.university_spring_boot.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    User findByUsername(String username);
}
