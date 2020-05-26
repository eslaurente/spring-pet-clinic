package laurente.reference.petclinicapp.services;

import laurente.reference.petclinicapp.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);
}
