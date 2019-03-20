package Application;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.File;
import java.util.Date;

@Entity
public class Article {

    @Id
    private String title;

    private String review;
    private Boolean inProgress;
    private Boolean accepted;
    private Date deadline;
    private File file;

    @ManyToOne
    private Reviewer reviewer;

    @ManyToOne
    private Submitter submitter;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Boolean getInProgress() {
        return inProgress;
    }

    public void setInProgress(Boolean inProgress) {
        this.inProgress = inProgress;
    }

    public Boolean getAccepted() {
        return accepted;
    }

    public void setAccepted(Boolean accepted) {
        this.accepted = accepted;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public Reviewer getReviewer() {
        return reviewer;
    }

    public void setReviewer(Reviewer reviewer) {
        this.reviewer = reviewer;
    }

    public Submitter getSubmitter() {
        return submitter;
    }

    public void setSubmitter(Submitter submitter) {
        this.submitter = submitter;
    }

}
