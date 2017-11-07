package application.repositories;

/**
 * Created by santiago on 11/5/17.
 */
import org.springframework.data.repository.CrudRepository;
import application.entities.StoreEntity;

public interface StoreRepository extends CrudRepository<StoreEntity, Long>{

}
