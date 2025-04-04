package handMeDowns.sysadminAPI.statLogs;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import handMeDowns.sysadminAPI.sysAdmin.Admin;
import handMeDowns.sysadminAPI.sysAdmin.AdminRepository;

@Service
public class StatLogsService {
    
    private final AdminRepository AdminRepository;
    
    private final StatLogsRepository statLogsRepository;

    @Autowired
    public StatLogsService(StatLogsRepository statLogsRepository, AdminRepository AdminRepository) {
        this.statLogsRepository = statLogsRepository;
        this.AdminRepository = AdminRepository;
    }

    public StatLogs logLogin(Admin sysAdmin, Date loggedInTimestamp) {
        StatLogs statLogs = new StatLogs();
        statLogs.setLoggedInTimestamp(loggedInTimestamp);
        statLogs.setSysAdmin(sysAdmin);
        statLogs.setLoggedOutTimestamp(new Date(0)); // Initialize with epoch time
        statLogs.setTotalTimeLoggedIn(0);
        return statLogsRepository.save(statLogs);
    }

    public StatLogs logLogout(StatLogs statLogs, Date loggedOutTimestamp) {
        statLogs.setLoggedOutTimestamp(loggedOutTimestamp);
        long totalTime = loggedOutTimestamp.getTime() - statLogs.getLoggedInTimestamp().getTime();
        statLogs.setTotalTimeLoggedIn(totalTime);
        return statLogsRepository.save(statLogs);
    }

    public StatLogs logAdminDeletion(Admin sysAdmin, Date deleteTimestamp, Admin deletedSysAdmin) {
        StatLogs statLogs = new StatLogs();
        statLogs.setSysAdmin(sysAdmin);
        statLogs.setAdminDeleteTimestamp(deleteTimestamp);
        // Set other fields as needed
        return statLogsRepository.save(statLogs);
    }
}

