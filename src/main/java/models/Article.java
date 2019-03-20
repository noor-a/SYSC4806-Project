package models;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Date;

@Entity
public class Article {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private MultipartFile uploadFile;

    private Status status;
    private Date deadline;
    private String author;

    public Article(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public MultipartFile getUploadFile() {
        return uploadFile;
    }

    public void setUploadFile(MultipartFile uploadFile) {
        this.uploadFile = uploadFile;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }
}
