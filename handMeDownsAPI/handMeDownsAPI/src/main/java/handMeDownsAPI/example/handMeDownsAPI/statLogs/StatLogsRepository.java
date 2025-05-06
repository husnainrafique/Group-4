package handMeDownsAPI.example.handMeDownsAPI.statLogs;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatLogsRepository extends JpaRepository<StatLogs, Integer> {
    List<StatLogs> findBySysAdmin_AdminID(int adminId); // Changed from sysAdminId to adminID
}