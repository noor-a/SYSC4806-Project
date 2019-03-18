package controllers;

import models.ArticleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import repositories.ArticleRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class ArticleController {
    public static String UPLOAD_DIR = System.getProperty("user.dir")+"/uploads";

    @Autowired
    ArticleRepository articleRepository;

    @RequestMapping("/upload")
    public String uploadPage(Model model){
        return "uploadView";
    }

    @RequestMapping("/upload")
    public String fileUpload(Model model, @RequestParam("file") MultipartFile file){
        StringBuilder fileNames = new StringBuilder();
        StringBuilder fileNamesFail = new StringBuilder();
        if(!file.isEmpty()) {
            Path fileNameAndPath = Paths.get(UPLOAD_DIR, file.getOriginalFilename());
            try {
                Files.write(fileNameAndPath, file.getBytes());

            } catch (IOException e) {
                e.printStackTrace();
                fileNamesFail.append(file.getOriginalFilename());
                model.addAttribute("msg", "Filed to upload file(s):  "+ fileNames.toString());
                return "uploadStatus";
            }
            fileNames.append(file.getOriginalFilename());
            model.addAttribute("msg", "Successfully Uploaded file: "+ fileNames.toString());
            model.addAttribute("article", new ArticleEntity(file));
            return "uploadStatus";
        }
        model.addAttribute("msg", "Failed upload empty file: "+ fileNames.toString());
        return "uploadStatus";
    }

    @RequestMapping("/success")
    public @ResponseBody String successUpload() {
        return "File successfully Uploaded";
    }

    /*@RequestMapping(method = RequestMethod.GET, path="/download")
    public ResponseEntity<Resource> downloadFile(String param){

    }*/
}
