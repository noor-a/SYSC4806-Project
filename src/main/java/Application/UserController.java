package Application;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @GetMapping("/register")
    public String index(Model model) {
        return "register";
    }

    @PostMapping("/register")
    public String addUser(@ModelAttribute User user, Model model) {

        model.addAttribute("newUser", new User());
        return "register";
    }

}