package ShoppingApp.MVC.Controller;

import ShoppingApp.MVC.Model.User;
import ShoppingApp.Services.AbstractIDataBaseService;
import ShoppingApp.Services.AdminPageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class AuthController  extends  AbstractControllerBase {

    @GetMapping("/auth")
    public ModelAndView authPage() {
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        AbstractIDataBaseService.connect(); //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("auth/authorization");
        return modelAndView;
    }

    @GetMapping("/loginPage")
    public ModelAndView loginPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("auth/login");
        return modelAndView;
    }

//    @PostMapping("/login")
//    public ModelAndView login(@ModelAttribute("user") User user) {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("redirect:/auth/");
//        return modelAndView;
//    }
}
