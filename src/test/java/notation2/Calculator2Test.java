package notation2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Calculator2Test {
    private Calculator2 calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator2();
    }

    @Test
    public void shouldCreateCalculator() {
        assertThat(new notation2.Calculator2()).isNotNull();
    }

    @Test
    public void shouldHaveInitialValue4() {
        assertThat(calculator.calculate("4")).isEqualTo(4);
    }

    @Test
    public void shouldHaveInitialValue5() {
        assertThat(calculator.calculate("5")).isEqualTo(5);
    }

    @Test
    public void shouldReturn5WhenAdding2and3() {
        assertThat(calculator.calculate("2 3 +")).isEqualTo(5);
    }

    @Test
    public void shouldReturn7WhenAdding4and4() {
        assertThat(calculator.calculate("4 4 +")).isEqualTo(8);
    }

    @Test
    public void shouldReturn8WhenAdding2and5and1() {
        assertThat(calculator.calculate("2 5 1 + +")).isEqualTo(8);
    }

    @Test
    public void shouldReturn8WhenMultiplying2By4() {
        assertThat(calculator.calculate("2 4 x")).isEqualTo(8);
    }

    @Test
    public void acceptanceTest() {
        assertThat(calculator.calculate("1 2 4 3 + x +")).isEqualTo(15);
    }
}
