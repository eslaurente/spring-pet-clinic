package laurente.reference.petclinicapp.services;

import laurente.reference.petclinicapp.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}
