package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class AtricleController {
    private static String UPLOAD_FOLDER = "/uploadTemp/";

    @GetMapping("/")
    public String index(){
        return "uploadForm";
    }

    @PostMapping("/uploadForm")
    public String fileUpload(@RequestParam("file")MultipartFile file, RedirectAttributes redirectAttributes){
        if(file.isEmpty()){
            redirectAttributes.addFlashAttribute("message", "Empty File. Cannot upload");
            return "redirect:/uploadStatus";
        }

        try{
            byte[]bytes = file.getBytes();
            Path path = Paths.get(UPLOAD_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);
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
