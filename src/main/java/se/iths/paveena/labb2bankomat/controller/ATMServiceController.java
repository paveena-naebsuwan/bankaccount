package se.iths.paveena.labb2bankomat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import se.iths.paveena.labb2bankomat.service.ATMService;

@Controller
@RequestMapping("/balance")
public class ATMServiceController {

    private ATMService atmService;

    public ATMServiceController(ATMService atmService) {
        this.atmService = atmService;
    }

    @GetMapping
    public String showBalance(Model model) {

        int balance = atmService.getBalance();

        model.addAttribute("balance", balance);

        return "balance";
    }
}
