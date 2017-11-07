package application.controllers;
/**
 * Created by santiago on 11/5/17.
 */

//import application.User;
import application.repositories.StoreRepository;
import application.entities.StoreEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@RestController
@RequestMapping("/store")
public class Store {

    @Autowired
    private StoreRepository storeRepository;

    @GetMapping(path="/add")
    public @ResponseBody String addStore (
            @RequestParam String name,
            @RequestParam String ruc,
            @RequestParam String city,
            @RequestParam boolean status) {
        StoreEntity store = new StoreEntity();
        store.setName(name);
        store.setRuc(ruc);
        store.setCity(city);
        store.setStatus(status);

        storeRepository.save(store);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<StoreEntity> getAllStores() {
        return storeRepository.findAll();
    }

}
