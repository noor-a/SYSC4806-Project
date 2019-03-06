package Application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    UserRepository repository;

    @GetMapping("/register")
    public String index(Model model) {
        return "register";
    }

    @PostMapping("/register")
    public String addUser(@ModelAttribute User user, Model model) {

        model.addAttribute("newUser", new User());
        return "register";
    }

    //creates a user object
    @PostMapping(value="/createUser")
    public String createUser(@RequestParam("firstName") String firstName,
                                @RequestParam("lastName") String lastName,
                                @RequestParam("email") String email,
                                @RequestParam("username") String username,
                                @RequestParam("password") String password){
        User u = new User();
        u.setFirstName(firstName);
        u.setLastName(lastName);
        u.setEmail(email);
        u.setUsername(username);
        u.setPassword(password);
        repository.save(u);
        return "home";
    }


}