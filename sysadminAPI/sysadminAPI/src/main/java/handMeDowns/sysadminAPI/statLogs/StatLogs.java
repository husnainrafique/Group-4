package handMeDowns.sysadminAPI.statLogs;

import java.util.Date;

import handMeDowns.sysadminAPI.reports.Report;
import handMeDowns.sysadminAPI.sysAdmin.Admin;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "stat_logs")
public class StatLogs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = true)
    private Date loggedInTimestamp;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = true)
    private Date loggedOutTimestamp;

    @Column(nullable = true)
    private long totalTimeLoggedIn; // In milliseconds

    @Temporal(TemporalType.TIMESTAMP)
    private Date adminDeleteTimestamp; 

    @ManyToOne
    @JoinColumn(name = "sysadmin_id", nullable = false)
    private Admin sysAdmin; 

    @ManyToOne
    @JoinColumn(name = "report_id")
    private Report report; 

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getLoggedInTimestamp() {
        return loggedInTimestamp;
    }

    public void setLoggedInTimestamp(Date loggedInTimestamp) {
        this.loggedInTimestamp = loggedInTimestamp;
    }

    public Date getLoggedOutTimestamp() {
        return loggedOutTimestamp;
    }

    public void setLoggedOutTimestamp(Date loggedOutTimestamp) {
        this.loggedOutTimestamp = new Date(0);
    }

    public long getTotalTimeLoggedIn() {
        return totalTimeLoggedIn = 0;
    }

    public void setTotalTimeLoggedIn(long totalTimeLoggedIn) {
        this.totalTimeLoggedIn = totalTimeLoggedIn;
    }

    public Date getAdminDeleteTimestamp() {
        return adminDeleteTimestamp;
    }

    public void setAdminDeleteTimestamp(Date adminDeleteTimestamp) {
        this.adminDeleteTimestamp = adminDeleteTimestamp;
    }

    public Admin getSysAdmin() {
        return sysAdmin;
    }

    public void setSysAdmin(Admin sysAdmin) {
        this.sysAdmin = sysAdmin;
    }

    public Report getReport() {
        return report;
    }

    public void setReport(Report report) {
        this.report = report;
    }
}
