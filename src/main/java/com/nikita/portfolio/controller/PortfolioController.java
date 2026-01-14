package com.nikita.portfolio.controller;

import com.nikita.portfolio.entity.Portfolio;
import com.nikita.portfolio.service.PortfolioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;

@Controller
public class PortfolioController {

    private final PortfolioService service;

    public PortfolioController(PortfolioService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String home(Model model, HttpSession session) {
        Boolean loggedIn = (Boolean) session.getAttribute("loggedIn");
        if (loggedIn == null || !loggedIn) {
            return "redirect:/login";
        }

        model.addAttribute("portfolio", new Portfolio());
        model.addAttribute("portfolios", service.getAllPortfolios());
        return "index";
    }


    @PostMapping("/save")
    public String savePortfolio(@ModelAttribute Portfolio portfolio) {
        service.savePortfolio(portfolio);
        return "redirect:/";
    }
}
