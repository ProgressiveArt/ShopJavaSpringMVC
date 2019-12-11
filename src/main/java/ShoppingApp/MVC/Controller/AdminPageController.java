package ShoppingApp.MVC.Controller;

import ShoppingApp.MVC.Model.Product;
import ShoppingApp.MVC.Model.User;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class AdminPageController extends AbstractControllerBase {

    @GetMapping("/adminPage")
    public ModelAndView getAdminPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/adminPage");
        return modelAndView;
    }

    @GetMapping("/admin/shoppingList")
    public ModelAndView readAllProducts() {
        List products = adminPageService.readAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/adminShopListPage");
        modelAndView.addObject("productsList", products);
        return modelAndView;
    }

    @GetMapping("/admin/userList")
    public ModelAndView readAllUsers() {
        List users = userService.readAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/adminUserListPage");
        modelAndView.addObject("usersList", users);
        return modelAndView;
    }




    @GetMapping("/admin/addUserPage")
    public ModelAndView createUserAdminPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/createUserAdminPage");
        return modelAndView;
    }

    @PostMapping("/admin/addUser")
    public ModelAndView createUserAdmin(@ModelAttribute("user") User user) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/admin/userList/");
        userService.create(user);
        return modelAndView;
    }

    @GetMapping("/admin/editUserPage/userID={id}")
    public ModelAndView updateUserAdminPage(@PathVariable int id) {
        User user = userService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/updateUserInUserListPage");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @PostMapping("/admin/editUser")
    public ModelAndView updateUserAdmin(@ModelAttribute("user") User user) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/admin/userList/");
        userService.update(user);
        return modelAndView;
    }

    @GetMapping("/admin/deleteUser/{id}")
    public ModelAndView deleteUserAdmin(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/admin/userList/");
        User user = userService.getById(id);
        userService.delete(user);
        return modelAndView;
    }




    @GetMapping("/admin/addPage")
    public ModelAndView createProductAdminPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/createProductToShoppingListPage");
        return modelAndView;
    }

    @PostMapping("/admin/add")
    public ModelAndView createProductAdmin(@ModelAttribute("product") Product product) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/admin/shoppingList/");
        adminPageService.create(product);
        return modelAndView;
    }

    @GetMapping(value = "/admin/editPage/productID={id}")
    public ModelAndView updateProductAdminPage(@PathVariable int id) {
        Product product = adminPageService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/updateProductInShoppingListPage");
        modelAndView.addObject("product", product);
        return modelAndView;
    }

    @PostMapping("/admin/edit")
    public ModelAndView updateProductAdmin(@ModelAttribute("product") Product product) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/admin/shoppingList/");
        adminPageService.update(product);
        return modelAndView;
    }

    @GetMapping("/admin/deleteProduct/{id}")
    public ModelAndView deleteProductAdmin(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/admin/shoppingList/");
        Product product = adminPageService.getById(id);
        adminPageService.delete(product);
        return modelAndView;
    }
}
