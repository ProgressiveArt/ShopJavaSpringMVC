package ShoppingApp.Services;

import ShoppingApp.MVC.Model.Bucket;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BucketPageService extends AbstractIDataBaseService<Bucket> {

    @Override
    public List<Bucket> readAll() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Bucket> list = bucketDAO.readAll(session);
        transaction.commit();
        session.close();
        return list;
    }

    @Override
    public void create(Bucket product) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        bucketDAO.create(product, session);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Bucket product) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        bucketDAO.delete(product, session);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Bucket product) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        bucketDAO.update(product, session);
        transaction.commit();
        session.close();
    }

    @Override
    public Bucket getById(long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Bucket product = bucketDAO.getById(id, session);
        transaction.commit();
        session.close();
        return product;
    }
}
