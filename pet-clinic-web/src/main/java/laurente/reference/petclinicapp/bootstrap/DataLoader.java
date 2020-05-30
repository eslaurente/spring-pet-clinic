package laurente.reference.petclinicapp.bootstrap;

import laurente.reference.petclinicapp.model.Owner;
import laurente.reference.petclinicapp.model.Pet;
import laurente.reference.petclinicapp.model.PetType;
import laurente.reference.petclinicapp.model.Vet;
import laurente.reference.petclinicapp.services.OwnerService;
import laurente.reference.petclinicapp.services.PetTypeService;
import laurente.reference.petclinicapp.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) {
        // Add pet type data
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatType = petTypeService.save(cat);

        System.out.println("Saved dog type: " + dog);
        System.out.println("Saved cat type: " + cat);

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

        System.out.println("Successfully loaded owners ...");

        // Add vets data

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");

        vetService.save(vet2);

        System.out.println("Successfully loaded vets ...");
    }
}
