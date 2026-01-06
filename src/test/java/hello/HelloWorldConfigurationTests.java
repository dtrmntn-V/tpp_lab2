package hello;

import org.junit.jupiter.api.Disabled; // <-- Важливо: імпортуйте @Disabled
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ApplicationTests {

    @Autowired
    private CalculatorService calculatorService;

    // --- Тест 1: Той, що проходить ---
    // (Як вимагається в завданні "1+1" повертає 2)
    @Test
    void testSuccessfulCalculation() {
        double result = calculatorService.evaluate("1+1");
        // Перевіряємо, що результат = 2.0
        assertEquals(2.0, result);
    }

    // --- Тест 2: Той, що завжди буде видавати помилку (ВИМКНЕНИЙ) ---
    // (Як вимагається в завданні "5-1" повертає 2)
    @Disabled// <-- Ця анотація вимикає тест
    @Test
    void testFailedCalculation() {
        double result = calculatorService.evaluate("5-1");
        // Ми знаємо, що 5-1 = 4.0, але ми навмисно перевіряємо, чи дорівнює воно 2.0
        // Цей тест впаде, тому що 4.0 != 2.0
        assertEquals(2.0, result, "Test failed as expected!");
    }

}