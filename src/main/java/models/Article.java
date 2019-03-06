package models;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class Article {

    private Long id;
    private String title;
    private SubmitterEntity sumbitter;
    private ReviewerEntity reviewer;
    public Status status;
    public Date deadline;

    public Article(){
        this.status = status.SUMBITRED;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public SubmitterEntity getSumbitter() {
        return sumbitter;
    }

    public void setSumbitter(SubmitterEntity sumbitter) {
        this.sumbitter = sumbitter;
    }
}
