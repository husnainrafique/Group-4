package handMeDowns.sysadminAPI.reports;
import java.util.Date;
import java.util.List;

import handMeDowns.sysadminAPI.statLogs.StatLogs;
import handMeDowns.sysadminAPI.sysAdmin.Admin;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "reports")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reportID;

    // Many reports can be associated with one SysAdmin (Admin).
    @ManyToOne
    @JoinColumn(name = "sysadmin_id", nullable = false)
    private Admin sysAdmin;

    // One report can have many stat logs.
    @OneToMany(mappedBy = "report", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<StatLogs> statLogs;

    @Column(nullable = false, length = 255)
    private String contentDetails;

    @Column(nullable = false, length = 255)
    private String author;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, updatable = false)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date updatedAt;

    @Column(nullable = false, length = 10)
    private String status;

    @Column(nullable = false, length = 255)
    private String reason;

    // Getters and Setters
    public int getReportID() {
        return this.reportID;
    }

    public void setReportID(int reportID) {
        this.reportID = reportID;
    }

    public Admin getSysAdmin() {
        return sysAdmin;
    }

    public void setSysAdmin(Admin sysAdmin) {
        this.sysAdmin = sysAdmin;
    }

    public List<StatLogs> getStatLogs() {
        return statLogs;
    }

    public void setStatLogs(List<StatLogs> statLogs) {
        this.statLogs = statLogs;
    }

    public String getContentDetails() {
        return contentDetails;
    }

    public void setContentDetails(String contentDetails) {
        this.contentDetails = contentDetails;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReason() {
        return this.reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
