package handMeDownsAPI.example.handMeDownsAPI.userRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import handMeDownsAPI.example.handMeDownsAPI.userModel.BookRequest;

public interface BookRequestRepository extends JpaRepository<BookRequest, Long> {
}
