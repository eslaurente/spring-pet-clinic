package laurente.reference.petclinicapp.bootstrap;

import laurente.reference.petclinicapp.model.*;
import laurente.reference.petclinicapp.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) {
        if (petTypeService.findAll().size() == 0) {
            loadData();
        }
    }

    private void loadData() {
        // Add pet type data
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatType = petTypeService.save(cat);

        System.out.printf("Successfully loaded pet types: %s, %s%n", savedDogType, savedDogType);

        // Add specialties
        Specialty radiologySpecialty = new Specialty();
        radiologySpecialty.setDescription("Radiology medical specialty");
        specialtyService.save(radiologySpecialty);

        Specialty surgerySpecialty = new Specialty();
        surgerySpecialty.setDescription("Surgery medical specialty");
        specialtyService.save(surgerySpecialty);

        Specialty dentistrySpecialty = new Specialty();
        dentistrySpecialty.setDescription("Dentistry medical specialty");
        specialtyService.save(dentistrySpecialty);

        System.out.printf("Successfully loaded specialties: %s, %s, %s%n", radiologySpecialty, surgerySpecialty, dentistrySpecialty);

        // Add owners data
        Owner mikeOwner = Owner.builder()
                .firstName("Michael")
                .lastName("Weston")
                .address("123 Brickerel")
                .city("Miami")
                .telephone("383-932-2233")
                .build();

        Pet mikesPet = new Pet();
        mikesPet.setName("Rosco");
        mikesPet.setPetType(savedDogType);
        mikesPet.setBirthDate(LocalDate.now());
        mikeOwner.getPets().add(mikesPet);
        mikesPet.setOwner(mikeOwner);

        ownerService.save(mikeOwner);

        Owner fionaOwner = Owner.builder()
                .firstName("Fiona")
                .lastName("Glenanne")
                .address("123 Brickerel")
                .city("Miami")
                .telephone("383-932-2234")
                .build();

        Pet fionasPet = new Pet();
        fionasPet.setName("Nibbler");
        fionasPet.setPetType(savedCatType);
        fionasPet.setBirthDate(LocalDate.now());
        fionaOwner.getPets().add(fionasPet);
        fionasPet.setOwner(fionaOwner);

        ownerService.save(fionaOwner);

        Visit catVisit = new Visit();
        catVisit.setPet(fionasPet);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Fat fuzzy cat");

        visitService.save(catVisit);

        System.out.printf("Successfully loaded owners: %s, %s%n", mikeOwner, fionaOwner);

        // Add vets data
        Vet samVet = new Vet();
        samVet.setFirstName("Sam");
        samVet.setLastName("Axe");
        samVet.getSpecialties().add(radiologySpecialty);

        vetService.save(samVet);

        Vet jessieVet = new Vet();
        jessieVet.setFirstName("Jessie");
        jessieVet.setLastName("Porter");
        jessieVet.getSpecialties().add(surgerySpecialty);

        vetService.save(jessieVet);

        System.out.printf("Successfully loaded vets: %s, %s%n", samVet, jessieVet);
    }
}
