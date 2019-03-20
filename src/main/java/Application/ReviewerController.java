package Application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ReviewerController {

    @Autowired
    UserRepository repository;

    //creates a user object
    @RequestMapping(value = "/registerReviewer", method = RequestMethod.GET)
    public String registerEditor(@RequestParam("username") String username,
                                 @RequestParam("password") String password,
                                 @RequestParam("firstName") String firstName,
                                 @RequestParam("lastName") String lastName,
                                 @RequestParam("email") String email) {
        User e = new User();
        e.setUsername(username);
        e.setPassword(password);
        e.setFirstName(firstName);
        e.setLastName(lastName);
        e.setUsername(email);
        repository.save(e);
        System.out.println("R");
        return "home";
    }

    @RequestMapping(value="/reviewerRegisteration",method=RequestMethod.GET)
    public String createUsers(){
        return "registerReviewer";
    }



}