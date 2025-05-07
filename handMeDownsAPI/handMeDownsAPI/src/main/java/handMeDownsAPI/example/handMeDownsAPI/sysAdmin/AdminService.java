package handMeDownsAPI.example.handMeDownsAPI.sysAdmin;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class AdminService {

    
    private final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    public Optional<Admin> getAdminById(int id) {
        return adminRepository.findById(id);
    }

    public Admin createAdmin(Admin admin) {
        admin.setCreatedAt(new Date());
        admin.setUpdatedAt(new Date());

        return adminRepository.save(admin);
    }

    public Admin updateAdmin(int id, Admin adminDetails) {
        Optional<Admin> optionalAdmin = adminRepository.findById(id);
        if (optionalAdmin.isPresent()) {
            Admin admin = optionalAdmin.get();
            admin.setRole(adminDetails.getRole());
            admin.setUpdatedAt(new Date());
            return adminRepository.save(admin);
        }
        return null; // Handle exception properly in a real app
    }

    public void deleteAdmin(int id) {
        adminRepository.deleteById(id);
    }

}
