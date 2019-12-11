package ShoppingApp.Services.DAO;


import ShoppingApp.MVC.Model.User;
import ShoppingApp.MVC.Model.UserRoleEnum;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDAO extends AbstractBaseDAO {
    @Override
    public List readAll(Session session) {
        return session.createQuery("from User").list();
    }

    public User getById(long id, Session session) {
        return session.get(User.class, id);
    }

    public User getUserByLogin(String login, Session session) {
        Criteria criteria = session.createCriteria(User.class);
        return (User) criteria.add(Restrictions.eq("login", login)).uniqueResult();
    }
}
