package handMeDowns.sysadminAPI.reports;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/all")
    public Object getAllReports(Model model) {
        model.addAttribute("reportList", reportService.getAllReports());
        model.addAttribute("title", "All Reports");
        return "report-list";
    }

    @GetMapping("/{id}")
    public Object getReportById(@PathVariable int id, Model model) {
        model.addAttribute("report", reportService.getReportById(id).orElse(null));
        model.addAttribute("title", "Report #" + id);
        return "report-details";
    }

    @GetMapping("/createForm")
    public Object showCreateForm(Model model) {
        model.addAttribute("report", new Report());
        model.addAttribute("title", "Create New Report");
        return "report-create";
    }

    @PostMapping("/new")
    public Object createReport(Report report) {
        reportService.createReport(report);
        return "redirect:/reports/all";
    }

    @GetMapping("/update/{id}")
    public Object showUpdateForm(@PathVariable int id, Model model) {
        model.addAttribute("report", reportService.getReportById(id).orElse(null));
        model.addAttribute("title", "Update Report");
        return "report-update";
    }

    @PostMapping("/update/{id}")
    public Object updateReport(@PathVariable int id, Report reportDetails) {
        reportService.updateReport(id, reportDetails);
        return "redirect:/reports/" + id;
    }

    @GetMapping("/delete/{id}")
    public Object deleteReport(@PathVariable int id) {
        reportService.deleteReport(id);
        return "redirect:/reports/all";
    }

    @GetMapping("/byStatus/{status}")
    public Object getReportsByStatus(@PathVariable String status, Model model) {
        model.addAttribute("reportList", reportService.getReportsByStatus(status));
        model.addAttribute("title", "Reports with Status: " + status);
        return "report-list";
    }

    @GetMapping("/byAuthor/{author}")
    public Object getReportsByAuthor(@PathVariable String author, Model model) {
        model.addAttribute("reportList", reportService.getReportsByAuthor(author));
        model.addAttribute("title", "Reports by Author: " + author);
        return "report-list";
    }
}