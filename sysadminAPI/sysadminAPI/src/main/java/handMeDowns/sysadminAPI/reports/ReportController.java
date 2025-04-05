package handMeDowns.sysadminAPI.reports;


import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reports")
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping
    public List<Report> getAllReports() {
        return reportService.getAllReports();
    }

    @GetMapping("/{id}")
    public Optional<Report> getReportById(@PathVariable int id) {
        return reportService.getReportById(id);
    }
    /* POST a report. Make sure an admin exists first.
        http://localhost:8080/reports
        {
        "sysAdmin": {
            "adminID": 1 
        },
        "contentDetails": "Test report content",
        "author": "testuser",
        "status": "OPEN",
        "reason": "Testing report creation"
    }
    */
    @PostMapping
    public Report createReport(@RequestBody Report report) {
        return reportService.createReport(report);
    }

    @PutMapping("/{id}")
    public Report updateReport(@PathVariable int id, @RequestBody Report reportDetails) {
        return reportService.updateReport(id, reportDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteReport(@PathVariable int id) {
        reportService.deleteReport(id);
    }

    @GetMapping("/byStatus/{status}")
    public List<Report> getReportsByStatus(@PathVariable String status) {
        return reportService.getReportsByStatus(status);
    }

    @GetMapping("/byAuthor/{author}")
    public List<Report> getReportsByAuthor(@PathVariable String author) {
        return reportService.getReportsByAuthor(author);
    }

    @GetMapping("/byCreated/{date}")
    public List<Report> getReportsCreatedAfter(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
        return reportService.getReportsCreatedAfter(date);
    }

    @GetMapping("/byContent/{content}")
    public List<Report> getReportsByContent(@PathVariable String content) {
        return reportService.getReportsByContent(content);
    }

    @GetMapping("/byStatusAndAuthor/{status}/{author}")
    public List<Report> getReportsByStatusAndAuthor(@PathVariable String status, @PathVariable String author) {
        return reportService.getReportsByStatusAndAuthor(status, author);
    }
}
