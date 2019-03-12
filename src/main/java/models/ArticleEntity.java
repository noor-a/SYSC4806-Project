package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.File;
import java.util.Date;

@Entity
public class ArticleEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private SubmitterEntity submitter;
    private ReviewerEntity reviewer;
    public Status status;
    public Date deadline;

    public ArticleEntity(File file){
        this.status = status.SUMBITRED;
    }

    public ArticleEntity(){
        this.status = status.SUMBITRED;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SubmitterEntity getSubmitter() {
        return submitter;
    }

    public void setSubmitter(SubmitterEntity submitter) {
        this.submitter = submitter;
    }

    public ReviewerEntity getReviewer() {
        return reviewer;
    }

    public void setReviewer(ReviewerEntity reviewer) {
        this.reviewer = reviewer;
    }
}
