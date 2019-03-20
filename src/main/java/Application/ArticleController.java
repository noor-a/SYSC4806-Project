package Application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ArticleController {
    public static String UPLOAD_DIR = System.getProperty("user.dir")+"/uploads";

    @Autowired
    ArticleRepository articleRepository;

    @RequestMapping(value = "/viewUploads/{id}", method = RequestMethod.GET)
    @ResponseBody
    public FileSystemResource getFile(@PathVariable("id") int id) {
        return new FileSystemResource(articleRepository.findOne(id).getFile());
    }

    @RequestMapping(value="/upload", method = RequestMethod.GET)
    public String uploadHandler(Model model){

        return "uploadForm";
    }

    @RequestMapping(value="/upload", method = RequestMethod.POST)
    public String submit(@RequestParam("file") MultipartFile file, Model model){
        model.addAttribute("file", file);

        //Creates a new article with the file and saves it to the repository
//        Article a = new Article();
//        a.setUploadFile(file);
//        a.setStatus(Status.SUMBITRED);
//        articleRepository.save(a);
//        return "uploadView";
        return null;
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
