package laurente.reference.petclinicapp.model;

import java.io.Serializable;

public class BaseEntity implements Serializable {
    private String name;
    private Long id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
