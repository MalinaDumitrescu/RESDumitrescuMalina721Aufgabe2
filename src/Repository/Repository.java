package Repository;
import Model.BaseEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class Repository<T> {
    private final List<T> entities = new ArrayList<>();

    public void add(T entity) {
        entities.add(entity);
    }

    public T get(int index) {
        if (index >= 0 && index < entities.size()) {
            return entities.get(index);
        }
        return null;
    }

    public void update(int index, T entity) {
        if (index >= 0 && index < entities.size()) {
            entities.set(index, entity);
        }
    }

    public void delete(int index) {
        if (index >= 0 && index < entities.size()) {
            entities.remove(index);
        }
    }

    public List<T> getAll() {
        return new ArrayList<>(entities);
    }
}
