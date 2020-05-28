package laurente.reference.petclinicapp.services.map;

import laurente.reference.petclinicapp.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {

    protected Map<ID, T> map = new HashMap<>();

    Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    T findById(ID id) {
        return map.get(id);
    }

    @SuppressWarnings("unchecked")
    T save(T object) throws RuntimeException {
        if (object == null) {
            throw new RuntimeException("Object to be saved cannot be null");
        }

        if (object.getId() == null) {
            object.setId(getNextId());
            map.put((ID) object.getId(), object);
        }

        return object;
    }

    void deleteById(ID id) {
        map.remove(id);
    }

    void delete(T object) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    private Long getNextId() {
        if (map.isEmpty()) {
            return 1L;
        }
        return Collections.<Long>max(map.keySet()) + 1L;
    }
}
