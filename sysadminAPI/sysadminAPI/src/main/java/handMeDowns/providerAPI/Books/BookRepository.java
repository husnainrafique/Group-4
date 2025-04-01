package handMeDowns.providerAPI.Books;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{

    @Query(value = "select * from students s where s.name like %?1% ", nativeQuery = true)
    List<Book> getBooksByName(String name);

}

