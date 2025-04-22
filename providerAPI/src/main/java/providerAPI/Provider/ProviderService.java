package providerAPI.Provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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
        providerRepository.save(provider);
    }

    public void updateNewProvider(int storeID, Provider provider) {
        Provider existing = getProviderById(storeID);
        existing.setStore_name(provider.getStore_name());
        existing.setInventory(provider.getInventory());
        existing.setReviews(provider.getReviews());
        existing.setUpdatedAt(new Date());
        providerRepository.save(existing);
    }

    public void deleteProviderById(int storeId) {
        providerRepository.deleteById(storeId);
    }


}



