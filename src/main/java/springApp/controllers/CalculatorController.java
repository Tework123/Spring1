package springApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Objects;

@Controller
@RequestMapping("/first")
public class CalculatorController {
    @GetMapping("/calculator")

    public String calculator(@RequestParam(value = "a", required = true) int a,
                             @RequestParam(value = "b", required = true) int b,
                             @RequestParam(value = "action", required = true) String action,
                             Model model) {
        int result = 0;
        if (action.equals("mult")) {
            result = a * b;
        } else if (action.equals("add")) {
            result = a + b;
        } else if (action.equals("subtr")) {
            result = a - b;
        } else if (action.equals("division")) {
            result = a / b;
        }
        model.addAttribute("result", result);
        return "calculator/calculator";
    }
}







