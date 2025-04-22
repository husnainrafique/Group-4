package providerAPI.Books;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{

    @Query(value = "select * from students s where s.name like %?1% ", nativeQuery = true)
    List<Book> getBooksByName(String name);

}

