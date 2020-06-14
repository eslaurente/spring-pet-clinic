package laurente.reference.petclinicapp.repositories;

import laurente.reference.petclinicapp.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findByLastName(String lastName);
}
