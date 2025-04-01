package handMeDowns.sysadminAPI.reports;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportService {
    @Autowired
    private final ReportRepository reportRepository;

    public ReportService(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    public List<Report> getAllReports() {
        return reportRepository.findAll();
    }

    public Optional<Report> getReportById(int id) {
        return reportRepository.findById(id);
    }

    public Report createReport(Report report) {
       
        report.setCreatedAt(new Date());
        report.setUpdatedAt(new Date());
        
        
        if (report.getSysAdmin() == null || report.getSysAdmin().getAdminID() == 0) {
            throw new IllegalArgumentException("Admin ID is required");
        }
        
        return reportRepository.save(report);
    }

    public Report updateReport(int id, Report reportDetails) {
        return reportRepository.findById(id).map(report -> {
            report.setContentDetails(reportDetails.getContentDetails());
            report.setAuthor(reportDetails.getAuthor());
            report.setStatus(reportDetails.getStatus());
            report.setReason(reportDetails.getReason());
            report.setUpdatedAt(new Date());
            return reportRepository.save(report);
        }).orElseThrow(() -> new RuntimeException("Report not found"));
    }

    public void deleteReport(int id) {
        reportRepository.deleteById(id);
    }

    public List<Report> getReportsByStatus(String status) {
        return reportRepository.findByStatus(status);
    }

    public List<Report> getReportsByAuthor(String author) {
        return reportRepository.findByAuthor(author);
    }

    public List<Report> getReportsCreatedAfter(Date date) {
        return reportRepository.findReportsCreatedAfter(date);
    }

    public List<Report> getReportsByContent(String contentDetails) {
        return reportRepository.findByContentDetails(contentDetails);
    }

    public List<Report> getReportsByStatusAndAuthor(String status, String author) {
        return reportRepository.findByStatusAndAuthor(status, author);
    }
}
