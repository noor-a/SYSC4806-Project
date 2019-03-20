package Application;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class Reviewer extends User {

    @OneToMany(targetEntity=Article.class, mappedBy="reviewer", fetch= FetchType.EAGER)
    private List<Article> articles;

    private String review;


    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public void addArticle(Article article){
        this.articles.add(article);
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public void addReview(String review, Article article){
        article.setReview(review);
    }

}
