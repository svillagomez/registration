package application;

/**
 * Created by santiago on 11/5/17.
 */

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Main {
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeter greeting(@RequestParam(value="name", defaultValue="World") String name) {
        final String template = "Hello, %s!";
        return new Greeter(counter.incrementAndGet(),
                String.format(template, name));
    }
}
