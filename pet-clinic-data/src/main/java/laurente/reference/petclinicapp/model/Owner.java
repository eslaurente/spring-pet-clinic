package laurente.reference.petclinicapp.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true, exclude = "pets")
@ToString(callSuper = true, exclude = "pets")
@NoArgsConstructor
@Entity
@Table(name = "owners")
public class Owner extends Person {

    @Builder
    public Owner(String firstName, String lastName, String address, String city, String telephone) {
        super(firstName, lastName);
        this.address = address;
        this.city = city;
        this.telephone = telephone;
    }

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "telephone")
    private String telephone;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Set<Pet> pets = new HashSet<>();

}
