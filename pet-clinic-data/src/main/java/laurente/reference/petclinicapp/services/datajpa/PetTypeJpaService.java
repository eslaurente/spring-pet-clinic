package laurente.reference.petclinicapp.services.datajpa;

import laurente.reference.petclinicapp.model.PetType;
import laurente.reference.petclinicapp.repositories.PetTypeRepository;
import laurente.reference.petclinicapp.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile("springdatajpa")
public class PetTypeJpaService implements PetTypeService {

    private final PetTypeRepository petTypeRepository;

    public PetTypeJpaService(PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Set<PetType> findAll() {
        return null;
    }

    @Override
    public PetType findById(Long id) {
        return null;
    }

    @Override
    public PetType save(PetType petType) {
        return null;
    }

    @Override
    public void delete(PetType petType) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
