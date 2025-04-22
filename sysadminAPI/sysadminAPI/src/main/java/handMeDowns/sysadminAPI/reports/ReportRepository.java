package handMeDowns.sysadminAPI.reports;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends JpaRepository<Report, Integer> {

    // Custom Queries
    @Query("SELECT r FROM Report r WHERE r.status = ?1")
    List<Report> findByStatus(String status);

    @Query("SELECT r FROM Report r WHERE r.author LIKE %?1%")
    List<Report> findByAuthor(String author);

    @Query("SELECT r FROM Report r WHERE r.createdAt > ?1")
    List<Report> findReportsCreatedAfter(Date date);

    @Query("SELECT r FROM Report r WHERE r.contentDetails LIKE %?1%")
    List<Report> findByContentDetails(String content_details);

    @Query("SELECT r FROM Report r WHERE r.status = ?1 AND r.author LIKE %?2%")
    List<Report> findByStatusAndAuthor(String status, String author);
}
