package Application;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class Submitter extends User {

    @OneToMany(targetEntity=Article.class, mappedBy="submitter", fetch= FetchType.EAGER)
    private List<Article> articles;

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public void addArticle(Article article){
        this.articles.add(article);
    }

}