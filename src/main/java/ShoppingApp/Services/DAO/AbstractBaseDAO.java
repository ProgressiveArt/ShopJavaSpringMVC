package ShoppingApp.Services.DAO;

import org.hibernate.Session;

import java.util.List;

public abstract class AbstractBaseDAO<T> implements IDAO<T> {


    public abstract List<T> readAll(Session session);

    public void create(T object, Session session) {
        session.persist(object);
    }

    public void delete(T object, Session session) {
        session.delete(object);
    }

    public void update(T object, Session session) {
        session.update(object);
    }
}
