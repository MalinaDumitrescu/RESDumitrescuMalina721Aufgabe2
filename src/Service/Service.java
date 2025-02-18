package Service;
import Model.*;
import Repository.Repository;

import java.util.List;

public class Service<T> {
    private final Repository<T> repository;

    public Service(Repository<T> repository) {
        this.repository = repository;
    }

    public void add(T entity) { repository.add(entity); }
    public T get(int index) { return repository.get(index); }
    public void update(int index, T entity) { repository.update(index, entity); }
    public void delete(int index) { repository.delete(index); }
    public List<T> getAll() { return repository.getAll(); }
}
