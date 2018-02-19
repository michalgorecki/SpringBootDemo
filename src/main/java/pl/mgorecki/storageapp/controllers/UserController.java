package pl.mgorecki.storageapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import pl.mgorecki.storageapp.beans.User;
import pl.mgorecki.storageapp.repositories.UserRepository;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;


    @GetMapping(value = "/")
    @ResponseBody
    public RedirectView home(){
        System.out.println("enter: home()");
        return new RedirectView("/index");
    }

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public ModelAndView index(Model model){
        System.out.println("index()");
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("userList",userRepository.findAll());
        model.addAttribute("user",new User());
        return mav;
    }

    @GetMapping(value ="/editUser/{id}")
    public ModelAndView editUser(@PathVariable("id") long id){
        System.out.println("Attempting to edit user with id: "+id);
        ModelAndView mav = new ModelAndView("edituser");
        mav.addObject("user",userRepository.findOne(id));
        return mav;
    }
    @PostMapping(value = "/editUser/submit/{id}")
    public RedirectView submitEdit(@PathVariable("id") long id, @ModelAttribute User user){
        
        System.out.println("Submit edit: found user with id: "+ user.getId());

        return new RedirectView("/index");
    }


    @PostMapping(value = "/submit")
    public RedirectView submit(@ModelAttribute User user){
        System.out.println("Submitting user with id: "+user.getId());
        userRepository.save(user);
        return new RedirectView("/index");
    }

    @GetMapping(value="/deleteUser/{id}")
    public RedirectView deleteUser(@PathVariable("id") long id){
        System.out.println("Removing user with id: "+id);
        userRepository.delete(id);
        return new RedirectView("/index");
    }


}
