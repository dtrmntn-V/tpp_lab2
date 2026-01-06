package hello;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import org.springframework.stereotype.Service;

@Service // Позначаємо цей клас як сервіс Spring
public class CalculatorService {

    public double evaluate(String expression) {
        try {
            Expression e = new ExpressionBuilder(expression).build();
            return e.evaluate();
        } catch (Exception e) {
            // У тестах краще "провалюватися" з реальною помилкою
            throw new IllegalArgumentException("Invalid expression: " + e.getMessage());
        }
    }
}