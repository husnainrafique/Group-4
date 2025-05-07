package handMeDownsAPI.example.handMeDownsAPI.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProviderRepository extends JpaRepository<Provider, Integer> {

    Provider findByEmail(String email);
}
