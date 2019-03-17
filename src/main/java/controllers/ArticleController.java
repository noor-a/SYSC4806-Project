package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import repositories.ArticleRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class ArticleController {
    public static String UploadDirectory = System.getProperty("user.dir")+"/uploads";

    @Autowired
    ArticleRepository articleRepository;

    @RequestMapping("/upload")
    public String uploadPage(Model model){
        return "uploadView";
    }

    @RequestMapping("/upload")
    public String fileUpload(Model model, @RequestParam("files") MultipartFile[] files){
        StringBuilder fileNames = new StringBuilder();
        for(MultipartFile file: files){
            Path fileNameAndPath = Paths.get(UploadDirectory, file.getOriginalFilename());
            fileNames.append(file.getOriginalFilename());
            try {
                Files.write(fileNameAndPath, file.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        model.addAttribute("msg", "Successfully Uploaded files "+ fileNames.toString());
        return "uploadStatus";
    }

    /*@GetMapping("/uploadStatus")
    public String uploadStatus(){
        return "uploadStatus";
    }*/
}
