package ShoppingApp.Services;

import ShoppingApp.MVC.Model.Product;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminPageService extends AbstractIDataBaseService<Product> {

    @Override
    public List<Product> readAll() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Product> list = productDAO.readAll(session);
        transaction.commit();
        session.close();
        return list;
    }

    @Override
    public void create(Product product) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        productDAO.create(product, session);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Product product) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        productDAO.delete(product, session);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Product product) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        productDAO.update(product, session);
        transaction.commit();
        session.close();
    }

    @Override
    public Product getById(long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Product product = productDAO.getById(id, session);
        transaction.commit();
        session.close();
        return product;
    }
}
