package providerAPI.Provider;

import providerAPI.Provider.Provider;
import providerAPI.Provider.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/providers")
public class ProviderController {

    @Autowired
    private ProviderService providerService;

    @GetMapping("/all")
    public Object getAllProviders() {
        return new ResponseEntity<>(providerService.getAllProviders(), HttpStatus.OK);
    }

    @GetMapping("/{storeID}")
    public Object getStoreById(@PathVariable int storeID) {
        return new ResponseEntity<>(providerService.getProviderById(storeID), HttpStatus.OK);
    }

    @PostMapping("/register")
    public Object addNewProvider(@RequestBody Provider provider) {
        providerService.addNewProvider(provider);
        return new ResponseEntity<>("New Provider Successfully Created!", HttpStatus.CREATED);
    }


    @PutMapping("/update/{storeID}")
    public Object updateProvider(@PathVariable int storeID, @RequestBody Provider provider) {
        providerService.updateNewProvider(storeID, provider);
        return new ResponseEntity<>(providerService.getProviderById(storeID), HttpStatus.CREATED);
    }

    //check on this later
    @DeleteMapping("/delete/{storeID}")
    public Object deleteProviderById(@PathVariable int storeID){
        providerService.deleteProviderById(storeID);
        return new ResponseEntity<>(providerService.getAllProviders(), HttpStatus.OK);
    }


}




