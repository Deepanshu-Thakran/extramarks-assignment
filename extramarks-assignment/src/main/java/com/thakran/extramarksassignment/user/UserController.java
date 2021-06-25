package com.thakran.extramarksassignment.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RestController
@CrossOrigin(origins = "*")
public class UserController {
    private final UserService userService;


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping(path = "users")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping(path = "/latest")
    public User getCurrentUser() {return userService.getCurrentUser();}

    @GetMapping(path = "{userId}")
    public User getLatestUser(@PathVariable("userId") Long userId ) {
        return userService.getUser(userId);
    }

//    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//    public void addNewUser(@RequestBody User user, @RequestParam("file") MultipartFile file) throws IOException {
//        userService.addUser(user, file);
//    }
    @PostMapping(value = "/")
    public void addNewUser(@ModelAttribute("user") User user){
        userService.addUser(user);
    }

}
