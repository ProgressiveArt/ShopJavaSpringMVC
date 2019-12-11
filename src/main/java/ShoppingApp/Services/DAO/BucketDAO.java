package ShoppingApp.Services.DAO;

import ShoppingApp.MVC.Model.Bucket;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BucketDAO extends AbstractBaseDAO {

    @SuppressWarnings("unchecked")
    public List readAll(Session session) {
        return session.createQuery("from Bucket").list();
    }

    public Bucket getById(long id, Session session) {
        return session.get(Bucket.class, id);
    }

    public Bucket getProductByName(String name, Session session) {
        Criteria criteria = session.createCriteria(Bucket.class);
        return (Bucket) criteria.add(Restrictions.eq("name", name)).uniqueResult();
    }
}
