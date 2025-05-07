package handMeDownsAPI.example.handMeDownsAPI.userRepository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import handMeDownsAPI.example.handMeDownsAPI.userModel.userBook;

public interface userBookRepository extends JpaRepository<userBook, Long> {
    List<userBook> findByCategory(String category);  //  custom query method to find books by category
}
