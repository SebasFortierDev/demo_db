package com.fortier.sebastien.demo_db.accesingdatamysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

@Controller
@RequestMapping(path = "/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping(path = "")
    @ResponseStatus(code = HttpStatus.CREATED)
    public @ResponseBody User addNewUser (@RequestParam String name, @RequestParam String email) {


        if (userRepository.existsByEmail(email)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User with this email already exist");
        }

        User u = new User();
        u.setName(name);
        u.setEmail(email);
        userRepository.save(u);

        return u;
    }

    @GetMapping(path = "")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }
}
