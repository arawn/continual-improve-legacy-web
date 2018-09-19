package legacy.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class LegacyWebController {

    @RequestMapping("/")
    public RedirectView root() {
        return new RedirectView("/index.jsp");
    }

    @RequestMapping("/index.jsp")
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("/index");
        mav.addObject("currentNavItem", "index");
        return mav;
    }

    @RequestMapping("/order.jsp")
    public String order(Model model) {
        model.addAttribute("currentNavItem", "order");
        return "/order/order";
    }

    @RequestMapping("/support.jsp")
    public String support(Model model) {
        model.addAttribute("currentNavItem", "support");
        return "/support/support";
    }

}
