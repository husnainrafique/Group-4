package handMeDowns.sysadminAPI.sysAdmin;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admins")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    /**
     * Get all admins.
     * http://localhost:8080/admins
     *
     * @return list of all admin objects.
     */
    @GetMapping
    public List<Admin> getAllAdmins() {
        return adminService.getAllAdmins();
    }

    /**
     * Get an admin by ID.
     * http://localhost:8080/admins/{id}
     *
     * @param id the ID of the admin to fetch
     * @return the admin object with the given ID.
     */
    @GetMapping("/{id}")
    public Optional<Admin> getAdminById(@PathVariable int id) {
        return adminService.getAdminById(id);
    }

    /**
     * Create a new admin.
     * http://localhost:8080/admins
     * Using POST, go to body then raw and send the below json date
     * 
     {
        "role": "ADMIN"
      }
     * 
     * @param admin the admin object to create
     * @return the newly created admin object.
     */
    @PostMapping
    public Admin createAdmin(@RequestBody Admin admin) {
        return adminService.createAdmin(admin);
    }

    /**
     * Update an existing admin.
     * http://localhost:8080/admins/{id}
     * 
     * @param id the ID of the admin to update
     * @param adminDetails the new details of the admin
     * @return the updated admin object.
     */
    @PutMapping("/{id}")
    public Admin updateAdmin(@PathVariable int id, @RequestBody Admin adminDetails) {
        return adminService.updateAdmin(id, adminDetails);
    }

    /**
     * Delete an admin by ID.
     * http://localhost:8080/admins/{id}
     * 
     * @param id the ID of the admin to delete
     */
    @DeleteMapping("/{id}")
    public void deleteAdmin(@PathVariable int id) {
        adminService.deleteAdmin(id);
    }
}
