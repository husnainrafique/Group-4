package handMeDowns.sysadminAPI.reports;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reports/manageReports")
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping
    public String manageReports(Model model) {
        model.addAttribute("reportList", reportService.getAllReports());
        model.addAttribute("newReport", new Report());
        model.addAttribute("totalReports", reportService.getTotalReports());
        return "manage-reports";
    }

    @PostMapping("/create")
    public String createReport(@ModelAttribute Report report) {
        reportService.createReport(report);
        return "redirect:/reports/manageReports";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        Optional<Report> report = reportService.getReportById(id);
        if (report.isPresent()) {
            model.addAttribute("report", report.get());
            return "edit-report";
        }
        return "redirect:/reports/manageReports";
    }

    @PostMapping("/update/{id}")
    public String updateReport(@PathVariable int id, @ModelAttribute Report report) {
        reportService.updateReport(id, report);
        return "redirect:/reports/manageReports";
    }

    @GetMapping("/delete/{id}")
    public String deleteReport(@PathVariable int id) {
        reportService.deleteReport(id);
        return "redirect:/reports/manageReports";
    }

}