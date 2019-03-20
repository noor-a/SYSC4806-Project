package Application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    UserRepository repository;

    @RequestMapping("/register")
    public String index(Model model) {
        return "register";
    }
    //creates a user object
    @RequestMapping(value="/createUser", method=RequestMethod.GET)
    public String createUser(@RequestParam("firstName") String firstName,
                                @RequestParam("lastName") String lastName,
                                @RequestParam("email") String email,
                                @RequestParam("username") String username,
                                @RequestParam("password") String password,
                                @RequestParam("type") String type){
        User u = new User();
        u.setFirstName(firstName);
        u.setLastName(lastName);
        u.setEmail(email);
        u.setUsername(username);
        u.setPassword(password);
        u.setType(type);
        repository.save(u);       
        return "home";
    }


}