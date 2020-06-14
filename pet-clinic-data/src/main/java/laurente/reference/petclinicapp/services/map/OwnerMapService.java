package laurente.reference.petclinicapp.services.map;

import laurente.reference.petclinicapp.model.Owner;
import laurente.reference.petclinicapp.model.PetType;
import laurente.reference.petclinicapp.services.OwnerService;
import laurente.reference.petclinicapp.services.PetService;
import laurente.reference.petclinicapp.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerMapService(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Owner save(Owner object) {
        if (object != null && object.getPets() != null) {
            object.getPets().forEach(pet -> {
                Long petId = pet.getId();
                if (petId == null) {
                    // Ensure new pet is stored
                    petService.save(pet);
                }

                PetType petType = pet.getPetType();
                if (petType == null) {
                    throw new RuntimeException("Pet type is required for " + pet);
                }
                if (petType.getId() == null) {
                    // Ensure new pet type is stored
                    pet.setPetType(petTypeService.save(petType));
                }
            });
        }
        return super.save(object);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
