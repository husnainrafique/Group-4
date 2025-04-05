package handMeDowns.sysadminAPI.statLogs;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import handMeDowns.sysadminAPI.sysAdmin.Admin;
import handMeDowns.sysadminAPI.sysAdmin.AdminRepository;
@RestController
@RequestMapping("/statlogs")
public class StatLogsController {

    private final StatLogsService statLogsService;
    private final AdminRepository sysAdminRepository;
    private final StatLogsRepository statLogsRepository;

    public static class LoginRequest {
        private int sysAdminId;
        private String loggedInTimestamp;
        
        // Getters and setters
        public int getSysAdminId() { return sysAdminId; }
        public void setSysAdminId(int sysAdminId) { this.sysAdminId = sysAdminId; }
        public String getLoggedInTimestamp() { return loggedInTimestamp; }
        public void setLoggedInTimestamp(String loggedInTimestamp) { 
            this.loggedInTimestamp = loggedInTimestamp; 
        }
    }

    @Autowired
    public StatLogsController(StatLogsService statLogsService, AdminRepository sysAdminRepository, StatLogsRepository statLogsRepository) {
        this.statLogsService = statLogsService;
        this.sysAdminRepository = sysAdminRepository;
        this.statLogsRepository = statLogsRepository;
    }

    @GetMapping
    public List<StatLogs> getAllStatLogs() {
        return statLogsRepository.findAll();
    }

    /* POST a log in time. Make sure an admin exists first
    http://localhost:8080/statlogs/login 
    {
    "sysAdminId": 1, # whatever the id of the admin is 
    "loggedInTimestamp": "2025-04-01 14:30:00"
    }
    */
    @PostMapping("/login")
    public ResponseEntity<?> logLogin(@RequestBody LoginRequest request) {
        try {
            Admin sysAdmin = sysAdminRepository.findById(request.getSysAdminId())
                    .orElseThrow(() -> new IllegalArgumentException("SysAdmin not found"));
            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date loggedInTime = sdf.parse(request.getLoggedInTimestamp());
            
            StatLogs log = statLogsService.logLogin(sysAdmin, loggedInTime);
            return ResponseEntity.ok(log);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(
                Map.of("error", e.getMessage(),
                    "timestamp", new Date())
            );
        }
}

  

    @PostMapping("/logout")
    public ResponseEntity<?> logLogout(@RequestBody LogoutRequest request) {
        try {
            StatLogs statLogs = statLogsRepository.findById(request.getStatLogId())
                    .orElseThrow(() -> new IllegalArgumentException("StatLog not found"));
            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date loggedOutTime = sdf.parse(request.getLoggedOutTimestamp());
            
            return ResponseEntity.ok(statLogsService.logLogout(statLogs, loggedOutTime));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(
                Map.of("error", e.getMessage(),
                    "timestamp", new Date())
            );
        }
    }

    @PostMapping("/delete")
    public StatLogs logAdminDeletion(@RequestParam int sysAdminId, @RequestParam String deleteTimestamp, @RequestParam int deletedSysAdminId) throws ParseException {
        Admin sysAdmin = sysAdminRepository.findById(sysAdminId).orElseThrow(() -> new IllegalArgumentException("SysAdmin not found"));
        Admin deletedSysAdmin = sysAdminRepository.findById(deletedSysAdminId).orElseThrow(() -> new IllegalArgumentException("Deleted SysAdmin not found"));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date deleteTime = sdf.parse(deleteTimestamp);
        return statLogsService.logAdminDeletion(sysAdmin, deleteTime, deletedSysAdmin);
    }

    public static class LogoutRequest {
        private int statLogId;
        private String loggedOutTimestamp;
    
        // Getters and setters
        public int getStatLogId() {
            return statLogId;
        }
    
        public void setStatLogId(int statLogId) {
            this.statLogId = statLogId;
        }
    
        public String getLoggedOutTimestamp() {
            return loggedOutTimestamp;
        }
    
        public void setLoggedOutTimestamp(String loggedOutTimestamp) {
            this.loggedOutTimestamp = loggedOutTimestamp;
        }
    }
}
