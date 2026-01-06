package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
public class Application {

    // "Впроваджуємо" наш сервіс калькулятора
    private final CalculatorService calculatorService;

    public Application(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/hello")
    @ResponseBody
    public String home() {
        return "Hello Docker World!";
    }

    @PostMapping("/calculate")
    @ResponseBody
    public String calculate(@RequestParam("expression") String expression) {
        try {
            // Використовуємо сервіс для обчислень
            double result = calculatorService.evaluate(expression);
            return "Expression: " + expression + " = " + result;
        } catch (Exception e) {
            return "Error in expression: " + e.getMessage();
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}