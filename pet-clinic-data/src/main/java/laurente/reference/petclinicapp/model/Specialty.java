package laurente.reference.petclinicapp.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "specialties")
public class Specialty extends BaseEntity {

    @Column(name = "description")
    private String description;

}
