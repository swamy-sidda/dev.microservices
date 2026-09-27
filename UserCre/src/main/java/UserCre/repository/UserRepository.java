package UserCre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import UserCre.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByPhoneNumber(String phoneNumber);
}