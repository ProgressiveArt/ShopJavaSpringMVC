package ShoppingApp.Services;

import ShoppingApp.MVC.Model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserDetailsServiceImpl extends AbstractIDataBaseService<User> implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

        User user = getByLogin(login);;
        Set<GrantedAuthority> roles = new HashSet();
        roles.add(new SimpleGrantedAuthority(user.getRole()));

        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), roles);
    }


    @Override
    public List<User> readAll() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<User> list = userDAO.readAll(session);
        transaction.commit();
        session.close();
        return list;
    }

    @Override
    public void create(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        userDAO.create(user, session);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        userDAO.delete(user, session);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        userDAO.update(user, session);
        transaction.commit();
        session.close();
    }


    @Override
    public User getById(long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        User user = userDAO.getById(id, session);
        transaction.commit();
        session.close();
        return user;
    }

    private User getByLogin(String login) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        User user = userDAO.getUserByLogin(login, session);
        transaction.commit();
        session.close();
        return user;
    }
}
