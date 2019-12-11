package ShoppingApp.MVC.Controller;

import ShoppingApp.Services.AdminPageService;
import ShoppingApp.Services.BucketPageService;
import ShoppingApp.Services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractControllerBase {

    @Autowired
    protected AdminPageService adminPageService;

    @Autowired
    protected UserDetailsServiceImpl userService;

    @Autowired
    protected BucketPageService bucketPageService;
}
