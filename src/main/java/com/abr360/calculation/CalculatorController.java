package com.abr360.calculation;
// CalculatorController.java

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @GetMapping("/")
    public String showCalculatorForm() {
        return "calculator";
    }

    @PostMapping("/calculate")
    public String calculate(@RequestParam double num1, @RequestParam double num2, @RequestParam String operation, Model model) {
        double result;
        switch (operation) {
            case "add":
                result = num1 + num2;
                break;
            case "subtract":
                result = num1 - num2;
                break;
            case "multiply":
                result = num1 * num2;
                break;
            case "divide":
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    throw new ArithmeticException("Cannot divide by zero");
                }
                break;
            default:
                throw new IllegalArgumentException("Invalid operation");
        }

        model.addAttribute("result", result);
        return "calculator";
    }
}
