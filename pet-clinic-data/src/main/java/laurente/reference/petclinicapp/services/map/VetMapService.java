package laurente.reference.petclinicapp.services.map;

import laurente.reference.petclinicapp.model.Vet;
import laurente.reference.petclinicapp.services.SpecialtyService;
import laurente.reference.petclinicapp.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialtyService specialtyService;

    public VetMapService(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Vet save(Vet object) {
        object.getSpecialties().forEach(specialty -> {
            Long id = specialty.getId();
            if (id == null) {
                specialty.setId(specialtyService.save(specialty).getId());
            }
        });

        return super.save(object);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }
}
