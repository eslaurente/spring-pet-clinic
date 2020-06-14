package laurente.reference.petclinicapp.repositories;

import laurente.reference.petclinicapp.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
