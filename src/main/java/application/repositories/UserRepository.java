package application.repositories;

/**
 * Created by santiago on 11/5/17.
 */
import org.springframework.data.repository.CrudRepository;
import application.entities.UserEntity;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<UserEntity, Long> {

}
