package controllers;

import models.Article;
import models.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import repositories.ArticleRepository;

import java.util.List;

@Controller
public class ArticleController {
    public static String UPLOAD_DIR = System.getProperty("user.dir")+"/uploads";

    @Autowired
    ArticleRepository articleRepository;

    @RequestMapping(value="/upload", method = RequestMethod.GET)
    public String uploadHandler(Model model){

        return "uploadForm";
    }

    @RequestMapping(value="/upload", method = RequestMethod.POST)
    public String submit(@RequestParam("file") MultipartFile file, Model model){
        model.addAttribute("file", file);

        //Creates a new article with the file and saves it to the repository
        Article a = new Article();
        a.setUploadFile(file);
        a.setStatus(Status.SUMBITRED);
        articleRepository.save(a);
        return "uploadView";
    }

    @GetMapping("/uploadView")
    public String getUploadedFiles(){
        return "uploadView";
    }

    //Gets Returns all articles that have been uploaaded
    public List<Article> getAllArticles(){
        return articleRepository.findAll();
    }
}
