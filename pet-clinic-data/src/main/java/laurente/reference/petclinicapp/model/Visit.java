package laurente.reference.petclinicapp.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Visit extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    @Column(name = "description")
    private String description;

    @Column(name = "date")
    private LocalDate date;
}
