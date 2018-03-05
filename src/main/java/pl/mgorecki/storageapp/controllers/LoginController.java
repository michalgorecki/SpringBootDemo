package pl.mgorecki.storageapp.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class LoginController {

    @GetMapping(value = "/login")
    public ModelAndView showLoginPage() {

        return new ModelAndView("login");
    }

    @PostMapping(value = "submitLogin")
    public RedirectView login() {
        return new RedirectView("/home");
    }
}
