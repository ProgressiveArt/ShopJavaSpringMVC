package ShoppingApp.Services.DAO;

import ShoppingApp.MVC.Model.Product;
import org.hibernate.Session;

import java.util.List;

public interface IDAO<T> {
    List<T> readAll(Session session);

    void create(T product, Session session);

    void delete(T product, Session session);

    void update(T product, Session session);
}
