package handMeDownsAPI.example.handMeDownsAPI.userRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import handMeDownsAPI.example.handMeDownsAPI.userModel.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

}
