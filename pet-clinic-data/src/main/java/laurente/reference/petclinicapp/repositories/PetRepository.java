package laurente.reference.petclinicapp.repositories;

import laurente.reference.petclinicapp.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
