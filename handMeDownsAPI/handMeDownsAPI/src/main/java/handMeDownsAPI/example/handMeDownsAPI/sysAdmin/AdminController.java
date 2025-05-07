package handMeDownsAPI.example.handMeDownsAPI.sysAdmin;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import handMeDownsAPI.example.handMeDownsAPI.Provider.Provider;
import handMeDownsAPI.example.handMeDownsAPI.Provider.ProviderService;
import handMeDownsAPI.example.handMeDownsAPI.userModel.User;
import handMeDownsAPI.example.handMeDownsAPI.userRepository.UserRepository;

@Controller
@RequestMapping("/admins")
public class AdminController {

    private AdminService adminService;
    private final ProviderService providerService;

    @Autowired
    private UserRepository userRepository;

    public AdminController(AdminService adminService, ProviderService providerService) {
        this.adminService = adminService;
        this.providerService = providerService;
    }

    @GetMapping("/manage")
    public String manageAdmins(Model model) {
        model.addAttribute("admins", adminService.getAllAdmins());
        return "manage-admins";
    }

    @GetMapping("/new")
    public String showAddForm(Model model) {
        Admin admin = new Admin();
        admin.setCreatedAt(new Date());
        admin.setUpdatedAt(new Date());
        model.addAttribute("admin", admin);
        return "addAdmin";
    }

    @PostMapping("/new")
    public String addAdmin(@ModelAttribute Admin admin) {
        admin.setCreatedAt(new Date());
        admin.setUpdatedAt(new Date());
        adminService.createAdmin(admin);
        return "redirect:/admins/manage";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        Admin admin = adminService.getAdminById(id)
                .orElseThrow(() -> new RuntimeException("Admin not found with id: " + id));
        model.addAttribute("admin", admin);
        return "editAdmin";
    }

    @PostMapping("/update/{id}")
    public String updateAdmin(@PathVariable int id, @ModelAttribute Admin admin) {
        admin.setUpdatedAt(new Date());
        adminService.updateAdmin(id, admin);
        return "redirect:/admins/manage";
    }

    @GetMapping("/delete/{id}")
    public String deleteAdmin(@PathVariable int id) {
        adminService.deleteAdmin(id);
        return "redirect:/admins/manage";
    }

    @GetMapping("/admin")
    public String adminDashboard() {
        return "admin";
    }

    @GetMapping("/analytics")
    public String showAdminAnalytics() {
        return "analytics";
    }

    @GetMapping("/manageProviders")
    public String manageProviders(Model model) {
        List<Provider> providerList = providerService.getAllProviders();
        model.addAttribute("providerList", providerList);
        model.addAttribute("providerCount", providerList != null ? providerList.size() : 0);
        return "manageProviders";
    }

    @GetMapping("/manageReviews")
    public String manageReviews(Model model) {
        List<Provider> providerList = providerService.getAllProviders();
        model.addAttribute("providerList", providerList);
        model.addAttribute("providerCount", providerList != null ? providerList.size() : 0);
        return "manageReviews";
    }

    

    @GetMapping("/manageUsersAdmin")
    public String manageUsers(Model model) {
        List<User> userList = userRepository.findAll();
        long newUsersCount = userList.stream()
                .filter(user -> user.getCreatedAt().isAfter(LocalDateTime.now().minusDays(7)))
                .count();

        model.addAttribute("userList", userList);
        model.addAttribute("newUsersCount", newUsersCount);
        return "manageUsersAdmin";
    }

}
