package no.ntnu.ivansh.ToDoApplication.login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;


@Controller
@SessionAttributes("name")
public class welcomeController {

    //private Logger logger = LoggerFactory.getLogger(getClass());
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showWelcomePage(ModelMap model){//@RequestParam String name, ModelMap modelMap){
       // logger.info("Request param is {}",name);
        model.put("name",getLoggedinUser());
        return "welcome";
    }
    private String getLoggedinUser(){
        Authentication authentication =SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}
