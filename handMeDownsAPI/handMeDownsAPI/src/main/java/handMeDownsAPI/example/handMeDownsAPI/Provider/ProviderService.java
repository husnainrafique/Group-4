package handMeDownsAPI.example.handMeDownsAPI.Provider;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProviderService {

    @Autowired
    private ProviderRepository providerRepository;

    public List<Provider> getAllProviders() {
        return providerRepository.findAll();
    }

    public Provider getProviderById(int storeID) {
        return providerRepository.findById(storeID).orElse(null);
    }

    public void addNewProvider(Provider provider) {
        provider.setCreatedAt(new Date());
        provider.setUpdatedAt(new Date());
        providerRepository.save(provider);
    }

    public void updateNewProvider(int storeID, Provider provider) {
        Provider existing = getProviderById(storeID);
        existing.setStoreName(provider.getStoreName());
        existing.setContactFirstName(provider.getContactFirstName());
        existing.setContactLastName(provider.getContactLastName());
        existing.setEmail(provider.getEmail());
        existing.setCity(provider.getCity());
        existing.setState(provider.getState());
        existing.setUpdatedAt(new Date());

        existing.getInventory().clear();
        existing.getInventory().addAll(provider.getInventory());

        existing.getReviews().clear();
        existing.getReviews().addAll(provider.getReviews());

        providerRepository.save(existing);
    }

    public void deleteProviderById(int storeID) {
        providerRepository.deleteById(storeID);
    }

    public Provider findByEmail(String email) {
        return providerRepository.findByEmail(email);
    }

    public Provider authenticateProvider(String email, String password) {
        Provider provider = providerRepository.findByEmail(email); // assumes you have this method
        if (provider != null && provider.getPassword().equals(password)) {
            return provider;
        }
        return null;
    }

    public void incrementVisits(int storeID) {
        Provider provider = getProviderById(storeID);
        if (provider != null) {
            provider.setTotalVisits(provider.getTotalVisits() + 1);
            providerRepository.save(provider);
        }
    }

    public void incrementBooksViewed(int storeID) {
        Provider provider = getProviderById(storeID);
        if (provider != null) {
            provider.setBooksViewed(provider.getBooksViewed() + 1);
            providerRepository.save(provider);
        }
    }

    public void incrementReviewsLeft(int storeID) {
        Provider provider = getProviderById(storeID);
        if (provider != null) {
            provider.setReviewsLeft(provider.getReviewsLeft() + 1);
            providerRepository.save(provider);
        }
    }


}



