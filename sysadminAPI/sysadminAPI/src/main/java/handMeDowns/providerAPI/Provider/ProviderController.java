package providerAPI.Provider;

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

    @GetMapping("/{storeId}")
    public Object getStoreById(@PathVariable int storeID) {
        return new ResponseEntity<>(providerService.getProviderById(storeID), HttpStatus.OK);
    }

    @PostMapping("/register")
    public Object addNewProvider(@RequestBody Provider provider) {
        providerService.addNewProvider(provider);
        return new ResponseEntity<>("New Provider Successfully Created!", HttpStatus.CREATED);
    }


    @PostMapping("/update/{providerId}")
    public Object updateProvider(@PathVariable int storeId, @RequestBody Provider provider) {
        providerService.addNewProvider(provider);
        return new ResponseEntity<>(providerService.getProviderById(storeId), HttpStatus.CREATED);
    }

    /* check on this later
    @DeleteMapping("/delete/{storeId}")
    public Object deleteProviderById(@PathVariable int providerId) {
        //Or use CASCADE to handle this.
        for (Project project : projectService.getProjectsByTeam(providerId))
            projectService.deleteProjectById(project.getProjectId());
        for (Student student : studentService.getStudentsByTeam(providerId)) {
            student.setTeam(null);
            studentService.updateStudent(student);
        }
        providerService.deleteProviderById(providerId);
        return new ResponseEntity<>(providerService.getAllProviders(), HttpStatus.OK);
    }

     */

}




