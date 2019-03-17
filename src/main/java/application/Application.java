package application;

import controllers.ArticleController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.io.File;


@SpringBootApplication
//@ComponentScan({"application", "controllers"})
public class Application {

    public static void main(String[] args) {
        new File(ArticleController.UploadDirectory).mkdir();
        SpringApplication.run(Application.class, args);
    }

}