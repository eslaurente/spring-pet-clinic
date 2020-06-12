package laurente.reference.petclinicapp.bootstrap;

import laurente.reference.petclinicapp.model.*;
import laurente.reference.petclinicapp.services.OwnerService;
import laurente.reference.petclinicapp.services.PetTypeService;
import laurente.reference.petclinicapp.services.SpecialtyService;
import laurente.reference.petclinicapp.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
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
        Owner mikeOwner = new Owner();
        mikeOwner.setFirstName("Michael");
        mikeOwner.setLastName("Weston");
        mikeOwner.setAddress("123 Brickerel");
        mikeOwner.setCity("Miami");
        mikeOwner.setTelephone("383-932-2233");

        Pet mikesPet = new Pet();
        mikesPet.setName("Rosco");
        mikesPet.setPetType(savedDogType);
        mikesPet.setBirthDate(LocalDate.now());
        mikeOwner.getPets().add(mikesPet);
        mikesPet.setOwner(mikeOwner);

        ownerService.save(mikeOwner);

        Owner fionaOwner = new Owner();
        fionaOwner.setFirstName("Fiona");
        fionaOwner.setLastName("Glenanne");
        fionaOwner.setAddress("123 Brickerel");
        fionaOwner.setCity("Miami");
        fionaOwner.setTelephone("383-932-2234");

        Pet fionasPet = new Pet();
        fionasPet.setName("Nibbler");
        fionasPet.setPetType(savedCatType);
        fionasPet.setBirthDate(LocalDate.now());
        fionaOwner.getPets().add(fionasPet);
        fionasPet.setOwner(fionaOwner);

        ownerService.save(fionaOwner);

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
