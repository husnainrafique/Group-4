package handMeDownsAPI.example.handMeDownsAPI.statLogs;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/analytics")
public class StatLogsController {

    private final StatLogsRepository statLogsRepository;

    public StatLogsController(StatLogsRepository statLogsRepository) {
        this.statLogsRepository = statLogsRepository;
    }


    @GetMapping
    public String showAllAnalytics(Model model) {
        List<StatLogs> analyticsData = statLogsRepository.findAll();
        model.addAttribute("analytics", analyticsData);
        return "analytics"; // corresponds to analytics.ftlh
    }


    @GetMapping("/new")
    public String showAddForm() {
        return "redirect:/analytics";
    }



    @GetMapping("/delete")
    public String deleteEntry(@RequestParam int id) {
        statLogsRepository.deleteById(id);
        return "redirect:/analytics";
    }
}
    // @PostMapping("/login")
    // public ResponseEntity<StatLogs> logLogin(@RequestBody LoginRequest request) throws ParseException {
    //     Admin sysAdmin = sysAdminRepository.findById(request.getSysAdminId())
    //             .orElseThrow(() -> new IllegalArgumentException("SysAdmin not found"));
    
    //     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    //     Date loggedInTime = sdf.parse(request.getLoggedInTimestamp());
    
    //     StatLogs log = statLogsService.logLogin(sysAdmin, loggedInTime);
    //     return ResponseEntity.ok(log);
    // }
    
    // @PostMapping("/logout")
    // public ResponseEntity<StatLogs> logLogout(@RequestBody LogoutRequest request) throws ParseException {
    //     StatLogs statLogs = statLogsRepository.findById(request.getStatLogId())
    //             .orElseThrow(() -> new IllegalArgumentException("StatLog not found"));
    
    //     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    //     Date loggedOutTime = sdf.parse(request.getLoggedOutTimestamp());
    
    //     return ResponseEntity.ok(statLogsService.logLogout(statLogs, loggedOutTime));
    // }

