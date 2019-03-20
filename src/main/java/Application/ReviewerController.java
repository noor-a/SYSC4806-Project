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
    @PostMapping(value = "/registerReviewer")
    public String registerEditor(@RequestParam("username") String username,
                                 @RequestParam("password") String password,
                                 @RequestParam("firstName") String firstName,
                                 @RequestParam("lastName") String lastName,
                                 @RequestParam("email") String email) {
        Reviewer r = new Reviewer();
        r.setUsername(username);
        r.setPassword(password);
        r.setFirstName(firstName);
        r.setLastName(lastName);
        r.setEmail(email);
        repository.save(r);
        return "home";
    }

    @RequestMapping(value="/reviewerRegisteration",method=RequestMethod.GET)
    public String createUsers(){
        return "registerReviewer";
    }



}