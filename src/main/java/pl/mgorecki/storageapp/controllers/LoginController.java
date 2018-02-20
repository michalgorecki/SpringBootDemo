package pl.mgorecki.storageapp.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @GetMapping(value = "/login")
    public ModelAndView showLoginPage() {
        return new ModelAndView("login");
    }

    @PostMapping(value = "submitLogin")
    public String login() {
        return null;
    }
}
