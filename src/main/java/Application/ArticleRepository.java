package Application;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends JpaRepository<Article,String> {
    List<Article> findByTitle(String title);
}
