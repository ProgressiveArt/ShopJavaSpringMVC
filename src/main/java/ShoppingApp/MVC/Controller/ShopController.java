package ShoppingApp.MVC.Controller;

import ShoppingApp.MVC.Model.Bucket;
import ShoppingApp.MVC.Model.Product;
import ShoppingApp.Services.AdminPageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@RestController
public class ShopController extends AbstractControllerBase {

    @GetMapping(value = "/user/shopPage")
    public ModelAndView readAllProductsToShoppingList() {
        AdminPageService.connect();
        List products = adminPageService.readAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("shop/ShoppingListPage");
        modelAndView.addObject("productsList", products);
        return modelAndView;
    }

    @GetMapping(value = "/user/shopPage/add/{id}")
    public ModelAndView addProductToBucket(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/user/shopPage/");
        Product product = adminPageService.getById(id);
        bucketPageService.create(new Bucket(product.getName(), product.getDescription(), product.getCost(), "waiting"));
        return modelAndView;
    }
}
