package org.launchcode.spaday.controllers;

import org.launchcode.spaday.data.UserData;
import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping("add")
    public String displayAddUserForm() {
        return "user/add";
    }

    @PostMapping()
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify) {
        //validate password match
        if(verify.equals(user.getPassword())) {
            //is true
            //view template with a message that welcomes the user by username
            UserData.addUser(user);
            model.addAttribute("user", user);
            model.addAttribute("users", UserData.getAll());
            return "user/index";
        } else {
            // is false
            model.addAttribute("error", "Your passwords do not match.");
            model.addAttribute("username", user.getUsername());
            model.addAttribute("email", user.getEmail());
            return "user/add";
        }
    }

    @GetMapping("details/{userId}")
    public String displayUser(Model model, @PathVariable int userId) {
        User user = UserData.getById(userId);
        model.addAttribute("username", user.getUsername());
        model.addAttribute("email", user.getEmail());
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = dateFormat.format(user.getJoinedDate());
        model.addAttribute("joined", strDate);
        return "user/details";
    }

}
