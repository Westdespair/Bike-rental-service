package no.ntnu.bikerental.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


/**
 * MVC controller for the main page(s). Returns HTML pages, not JSON!
 */
@Controller
public class HomeController {

    /**
     * Responds to HTTP get /
     *
     * @return Name of the template to render
     */
    @GetMapping("/")
    public String getHome(Model model) {

        return "index";
    }

}
