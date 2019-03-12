package models;

import javax.persistence.Entity;
import java.util.List;

@Entity
public class ReviewerEntity extends UserEntity {
    List<ArticleEntity> assignedArticles;

    public void wrtieReview(){

    }

    public void submitReview(){

    }
}
