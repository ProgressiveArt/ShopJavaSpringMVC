package ShoppingApp.Services;

import java.util.List;

public interface IDataBaseService<T> {
    List<T> readAll();

    void create(T product);

    void delete(T product);

    void update(T product);

    T getById(long id);
}
