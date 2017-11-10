package application.controllers;

/**
 * Created by santiago on 11/5/17.
 */

import application.Greeter;
import application.repositories.UserRepository;
import application.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("/user")
public class User {
    private final AtomicLong counter = new AtomicLong();


    @Autowired
    private UserRepository userRepository;


    @RequestMapping("/greeting")
    public Greeter greeting(@RequestParam(value="name", defaultValue="World") String name) {
        final String template = "Hello, %s!";
        return new Greeter(counter.incrementAndGet(),
                String.format(template, name));
    }

    @RequestMapping(path="/add", method = RequestMethod.POST) // Map ONLY GET Requests
    public @ResponseBody ResponseEntity addNewUser (
            @RequestParam String userName,
            @RequestParam String email,
            @RequestParam String city,
            @RequestParam String name,
            @RequestParam String password,
            @RequestParam boolean status) {
        UserEntity user = new UserEntity();
        user.setName(name);
        user.setEmail(email);
        user.setCity(city);
        user.setUsername(userName);
        user.setPassword(password);
        userRepository.save(user);
        return new ResponseEntity<String>( HttpStatus.OK );
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }
}
