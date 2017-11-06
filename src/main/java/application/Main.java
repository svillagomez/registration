package application;

/**
 * Created by santiago on 11/5/17.
 */

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
@RequestMapping("/api")
public class Main {
    private final AtomicLong counter = new AtomicLong();


    @Autowired
    private UserRepository userRepository;


    @RequestMapping("/greeting")
    public Greeter greeting(@RequestParam(value="name", defaultValue="World") String name) {
        final String template = "Hello, %s!";
        return new Greeter(counter.incrementAndGet(),
                String.format(template, name));
    }

    @GetMapping(path="/add") // Map ONLY GET Requests
    public @ResponseBody String addNewUser (
            @RequestParam String userName,
            @RequestParam String email,
            @RequestParam String city) {
        User user = new User();
        user.setUsername(userName);
        user.setEmail(email);
        user.setCity(city);
        userRepository.save(user);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }
}
