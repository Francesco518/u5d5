package francescobuonocore.u5d5.repositories;

import francescobuonocore.u5d5.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<User, Long> {
}
