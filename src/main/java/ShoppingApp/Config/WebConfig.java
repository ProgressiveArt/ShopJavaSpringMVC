package ShoppingApp.Config;

import ShoppingApp.Services.AdminPageService;
import ShoppingApp.Services.BucketPageService;
import ShoppingApp.Services.DAO.BucketDAO;
import ShoppingApp.Services.DAO.ProductDAO;
import ShoppingApp.Services.DAO.UserDAO;
import ShoppingApp.Services.IDataBaseService;
import ShoppingApp.Services.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "ShoppingApp")

public class WebConfig {

    @Bean
    ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/pages/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Bean
    public UserDetailsService getUserDetailsService(){
        return new UserDetailsServiceImpl();
    }

    @Bean
    public AdminPageService getAdminPageService(){
        return new AdminPageService();
    }

    @Bean
    public BucketPageService getBucketPageService(){
        return new BucketPageService();
    }


    @Bean
    public ProductDAO getProductDAO(){
        return new ProductDAO();
    }

    @Bean
    public UserDAO getUserDAO(){
        return new UserDAO();
    }

    @Bean
    public BucketDAO getBucketDAO(){
        return new BucketDAO();
    }


    @Bean
    public PasswordEncoder getShaPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
