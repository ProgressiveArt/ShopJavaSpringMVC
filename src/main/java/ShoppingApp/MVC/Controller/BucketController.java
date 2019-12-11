package ShoppingApp.MVC.Controller;

import ShoppingApp.MVC.Model.Bucket;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class BucketController extends AbstractControllerBase {

    @GetMapping(value = "/user/bucketPage")
    public ModelAndView readAllProductsInBucket() {
        List<Bucket> products = bucketPageService.readAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("shop/BucketListPage");
        modelAndView.addObject("productsList", products);
        return modelAndView;
    }

    @GetMapping(value = "/user/bucketPage/delete/{id}")
    public ModelAndView addProductToBucket(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/user/bucketPage/");
        Bucket product = bucketPageService.getById(id);
        bucketPageService.delete(product);
        return modelAndView;
    }

    @GetMapping(value = "/user/bucketPage/pay")
    public ModelAndView payProducts() {
        List<Bucket> products = bucketPageService.readAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/user/bucketPage/");
        for(Bucket product : products) {
            if(product.getStatus().equals("waiting")) {
                product.setStatus("paid");
                bucketPageService.update(product);
            }
        }
        return modelAndView;
    }

    @GetMapping(value = "/user/bucketPage/payOne/{id}")
    public ModelAndView payOne(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/user/bucketPage/");
        Bucket product = bucketPageService.getById(id);
        product.setStatus("paid");
        bucketPageService.update(product);
        return modelAndView;
    }

    @GetMapping(value = "/user/bucketPage/reset")
    public ModelAndView resetAll() {
        List<Bucket> products = bucketPageService.readAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/user/bucketPage/");
        for(Bucket product : products) {
                bucketPageService.delete(product);
        }
        return modelAndView;
    }
}
