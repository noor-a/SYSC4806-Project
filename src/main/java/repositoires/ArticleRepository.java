package repositoires;

import models.Article;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository {
    List<Article> findById();
    List<Article> findAll();
    Article save(Article article);
}
