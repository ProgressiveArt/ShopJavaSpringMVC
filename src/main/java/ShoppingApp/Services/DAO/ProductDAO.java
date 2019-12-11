package ShoppingApp.Services.DAO;

import ShoppingApp.MVC.Model.Product;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDAO extends AbstractBaseDAO<Product> {

    @SuppressWarnings("unchecked")
    public List<Product> readAll(Session session) {
        return session.createQuery("from Product").list();
    }

    public Product getById(long id, Session session) {
        return session.get(Product.class, id);
    }
}
