package controllers;

import models.ArticleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import repositories.ArticleRepository;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class ArticleController {
    private static String UPLOAD_FOLDER = "/uploadTemp/";

    @Autowired
    ArticleRepository articleRepository;


    @PostMapping("/uploadForm")
    public String fileUpload(@RequestParam("file")MultipartFile file, RedirectAttributes redirectAttributes, Model model){
        if(file.isEmpty()){
            redirectAttributes.addFlashAttribute("message", "Empty File. Cannot upload");
            return "redirect:/uploadStatus";
        }

        try{
            byte[]bytes = file.getBytes();
            Path path = Paths.get(UPLOAD_FOLDER + file.getOriginalFilename());

            //Converts MultiPartFile into File
            File f = new File(file.getOriginalFilename());
            f.createNewFile();
            FileOutputStream fos = new FileOutputStream(f);
            fos.write(file.getBytes());
            fos.close();

            Files.write(path, bytes);
            model.addAttribute("article", new ArticleEntity(f));
            articleRepository.save(new ArticleEntity(f));
            redirectAttributes.addFlashAttribute("message","Successfully uploaded '" + file.getOriginalFilename() + "'" );
        }catch (IOException e){
            e.printStackTrace();
        }
        return "redirect:/uploadStatus";
    }

    @GetMapping("/uploadStatus")
    public String uploadStatus(){
        return "uploadStatus";
    }
}
