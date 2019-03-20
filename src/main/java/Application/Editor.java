package Application;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class Editor extends User {

    @OneToMany(targetEntity = Article.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Article>allArticles;



}
