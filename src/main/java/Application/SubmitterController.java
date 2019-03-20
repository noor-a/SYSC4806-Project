package Application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SubmitterController {

    @Autowired
    UserRepository repository;

    //creates a user object
    @PostMapping("/registerSubmitter")
    public String registerSubmitter(@RequestParam("username") String username,
                                 @RequestParam("password") String password,
                                 @RequestParam("firstName") String firstName,
                                 @RequestParam("lastName") String lastName,
                                 @RequestParam("email") String email) {
        Submitter s = new Submitter();
        s.setUsername(username);
        s.setPassword(password);
        s.setFirstName(firstName);
        s.setLastName(lastName);
        s.setEmail(email);
        repository.save(s);
        return "home";
    }

    @RequestMapping(value="/submitterRegisteration",method=RequestMethod.GET)
    public String createUsers(){
        return "registerSubmitter";
    }



}