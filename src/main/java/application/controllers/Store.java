package application.controllers;
/**
 * Created by santiago on 11/5/17.
 */

//import application.User;
import application.repositories.StoreRepository;
import application.repositories.UserRepository;
import application.entities.StoreEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("/store")
public class Store {

    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(path="/add", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity addStore (
            @RequestParam String name,
            @RequestParam String ruc,
            @RequestParam String city,
            @RequestParam boolean status,
            @RequestParam Long id) {
        StoreEntity store = new StoreEntity();
        store.setName(name);
        store.setRuc(ruc);
        store.setCity(city);
        store.setStatus(status);
        store.getUsers().add(userRepository.findOne(id));

        storeRepository.save(store);

        return new ResponseEntity<String>( HttpStatus.OK );

    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<StoreEntity> getAllStores() {
        return storeRepository.findAll();
    }

}
