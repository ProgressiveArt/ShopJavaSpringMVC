package ShoppingApp.Services;

import ShoppingApp.MVC.Model.Bucket;
import ShoppingApp.MVC.Model.Product;
import ShoppingApp.MVC.Model.User;
import ShoppingApp.Services.DAO.BucketDAO;
import ShoppingApp.Services.DAO.ProductDAO;
import ShoppingApp.Services.DAO.IDAO;
import ShoppingApp.Services.DAO.UserDAO;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.beans.factory.annotation.Autowired;


public abstract class AbstractIDataBaseService<T> implements IDataBaseService<T> {

    static SessionFactory sessionFactory = null;

    @Autowired
    ProductDAO productDAO;

    @Autowired
    UserDAO userDAO;

    @Autowired
    BucketDAO bucketDAO;


    public static void connect() {
        if (sessionFactory != null) return;
        Configuration configuration = getMySqlConfiguration();
        sessionFactory = createSessionFactory(configuration);
    }

    private static Configuration getMySqlConfiguration() {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(Product.class);
        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(Bucket.class);

        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL57Dialect");
        configuration.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC");
        configuration.setProperty("hibernate.connection.username", "uswer");
        configuration.setProperty("hibernate.connection.password", "marcipan12");
        configuration.setProperty("hibernate.show_sql", "true");
        configuration.setProperty("hibernate.hbm2ddl.auto", "update");
        return configuration;
    }

    private static SessionFactory createSessionFactory(Configuration configuration) {
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(configuration.getProperties());
        ServiceRegistry serviceRegistry = builder.build();
        return configuration.buildSessionFactory(serviceRegistry);
    }
}
