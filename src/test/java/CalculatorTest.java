import org.example.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.BinaryOperator;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    Calculator calc;

    @BeforeEach
    void setUp() {
        calc = new Calculator();
    }

    @Test
    @DisplayName("Проверка корректности сложения")
    void plus() {
        final int x = 5;
        final int y = 7;
        final int expected = 12;
        final int result = calc.plus.apply(x, y);
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Проверка корректности вычитания")
    void minus() {
        final int x = 10;
        final int y = 7;
        final int expected = 3;
        final int result = calc.minus.apply(x, y);
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Проверка корректности умножения")
    void multipy() {
        final int x = 5;
        final int y = 7;
        final int expected = 35;
        final int result = calc.multiply.apply(x, y);
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Проверка корректности деления")
    void devide() {
        final int x = 35;
        final int y = 7;
        final int expected = 5;
        final int result = calc.devide.apply(x, y);
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Проверка деления на 0")
    void devideByZero() {
        final int x = 35;
        final int y = 0;
        Assertions.assertThrows(
                ArithmeticException.class,
                () -> calc.devide.apply(x, y)
        );
    }


    @Test
    @DisplayName("Проверка текста исключения при делении на 0")
    void exceptionDevideByZero() {
        final int x = 35;
        final int y = 0;
        final  ArithmeticException exception = Assertions.assertThrows(
                ArithmeticException.class,
                () -> calc.devide.apply(x, y)
        );
        Assertions.assertEquals("Внимание!!! Деление на 0! На ноль делить нельзя", "Внимание!!! Деление на 0! На ноль делить нельзя");
    }

    @Test
    @DisplayName("Проверка вычисления квадрата из числа")
    void pow() {
        Calculator calc = new Calculator();
        final int x = 5;
        final int expected = 25;
        final int result = calc.pow.apply(x);
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Проверка корректности абсалюта")
    void abs() {
        Calculator calc = new Calculator();
        final int x = -5;
        final int expected = 5;
        final int result = calc.abs.apply(x);
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Проверка корректности проверки положительного числа")
    void isPositive() {
        Calculator calc = new Calculator();
        final int x = -5;
        final Boolean expected = false;
        final Boolean result = calc.isPositive.test(x);
        Assertions.assertEquals(expected, result);
    }
}


