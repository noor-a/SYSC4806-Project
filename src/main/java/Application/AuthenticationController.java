package Application;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthenticationController {

    // This class will be used to handle login and authentication checks for a user

    private UserRepository repository;
    private int nextSession = 0;

    @Autowired
    public void setRepository(UserRepository repository){
        this.repository = repository;
    }

    // Our new landing page will be a page that makes calls to this to login,
    // which then returns the appropriate homepage based on the type of User
    @RequestMapping(value="/login",method=RequestMethod.GET)
    public String createProf(@RequestParam("username") String username,
                             @RequestParam("password") String password,
                             Model model,
                             HttpServletResponse response){
        List<User> users = repository.findByUsername(username);
        if(users.isEmpty()){
            // TODO: Return nice message about username/password invalid
            model.addAttribute("message", "User not found");
            return "error";
        }
        User u = users.get(0);
        if(u.getPassword().equals(password)){
            // TODO: Return a view that is specific to the type of User
            // TODO: Generate a cookie to return with a session Id
            repository.save(u);

            return "hello";
        } else {
            // TODO: Return nice message about username/password invalid
            model.addAttribute("message", "Password incorrect");
            return "error";
        }
    }

    @RequestMapping(value="/logout",method=RequestMethod.GET)
    public String logout(Model model,
                         HttpServletResponse response){

        // TODO: Make this do more than give a null value
        response.addCookie(new Cookie("sessionId",null));

        return "login";
    }

    @RequestMapping(value="/logins",method=RequestMethod.GET)
    public String logins(){
        return "login";
    }




}
