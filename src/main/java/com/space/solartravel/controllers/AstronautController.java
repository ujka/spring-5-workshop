package com.space.solartravel.controllers;

import com.space.solartravel.domain.Astronaut;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AstronautController {

    @RequestMapping("/signup")
    public String signup(Model model){
        model.addAttribute("astronaut", new Astronaut());
        return "astronaut";
    }
}
