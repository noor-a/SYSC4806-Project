package Application;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthenticationController {

    private UserRepository repository;
    private int nextSession = 0;

    @Autowired
    public void setRepository(UserRepository repository){
        this.repository = repository;
    }

    @PostMapping(value="/login")
    public String verifyUser(@RequestParam("username") String username,
                             @RequestParam("password") String password,
                             Model model,
                             HttpServletResponse response){

        List<User> users = repository.findByUsername(username);
        if(users.isEmpty()){
            model.addAttribute("message", "User not found");
            return "loginFailed";
        }
        User u = users.get(0);
        if(u.getPassword().equals(password)){
            repository.save(u);
            return "home";
        } else {
            model.addAttribute("message", "Password incorrect");
            return "loginFailed";
        }
    }

    @RequestMapping(value="/logout",method=RequestMethod.GET)
    public String logout(Model model,
                         HttpServletResponse response){

        response.addCookie(new Cookie("sessionId",null));
        return "login";
    }

    @RequestMapping(value="/logins",method=RequestMethod.GET)
    public String logins(){
        return "login";
    }


}
