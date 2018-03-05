package pl.mgorecki.storageapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import pl.mgorecki.storageapp.db.RoleRepository;
import pl.mgorecki.storageapp.db.UserRepository;
import pl.mgorecki.storageapp.domain.Role;
import pl.mgorecki.storageapp.domain.User;

import java.util.HashSet;
import java.util.Set;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping(value = "/")
    @ResponseBody
    public RedirectView emptyAddressRedirect() {
        return new RedirectView("/index");
    }

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public ModelAndView index(Model model){
        ModelAndView mav = new ModelAndView("index");
        model.addAttribute("user",new User());
        return mav;
    }

    @GetMapping(value = "/home")
    public ModelAndView home() {
        ModelAndView mav = new ModelAndView("homepage");
        mav.addObject("userList", userRepository.findAll());
        return mav;
    }

    @PostMapping(value = "/submit")
    public RedirectView submit(@ModelAttribute User user) {
        System.out.println("Storing user with id: " + user.getId());
        if (!userRepository.exists(user.getId())) {
            Set<Role> roles = new HashSet<>();
            roles.add(roleRepository.findByName("USER"));
            user.setRoles(roles);
            String password = user.getPassword();
            user.setPassword(bCryptPasswordEncoder.encode(password));
        }
        userRepository.save(user);
        return new RedirectView("/home");
    }

    @GetMapping(value = "/editUser/{id}")
    public ModelAndView editUser(@PathVariable("id") long id) {
        System.out.println("Attempting to edit user with id: " + id);
        ModelAndView mav = new ModelAndView("edituser");
        mav.addObject("editableUser", userRepository.findOne(id));
        return mav;
    }

    @GetMapping(value="/deleteUser/{id}")
    public RedirectView deleteUser(@PathVariable("id") long id){
        System.out.println("Removing user with id: "+id);
        userRepository.delete(id);
        return new RedirectView("/index");
    }


}
