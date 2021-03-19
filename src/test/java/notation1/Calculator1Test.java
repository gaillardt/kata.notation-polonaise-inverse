package notation1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Calculator1Test {

    private Calculator1 calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator1();
    }

    @Test
    public void shouldCreateCalculator() {
        assertThat(new Calculator1()).isNotNull();
    }

    @Test
    public void shouldHaveInitialValue9() {
        assertThat(calculator.calculate("9")).isEqualTo(9);
    }

    @Test
    public void shouldHaveInitialValue7() {
        assertThat(calculator.calculate("7")).isEqualTo(7);
    }

    @Test
    public void shouldReturn9WhenAdding7and2() {
        assertThat(calculator.calculate("7 2 +")).isEqualTo(9);
    }

    @Test
    public void shouldReturn7WhenAdding4and3() {
        assertThat(calculator.calculate("4 3 +")).isEqualTo(7);
    }

    @Test
    public void shouldReturn8WhenAdding4and3and1() {
        assertThat(calculator.calculate("4 3 + 1 +")).isEqualTo(8);
    }

    @Test
    public void shouldReturn6WhenMultiplying2By3() {
        assertThat(calculator.calculate("2 3 x")).isEqualTo(6);
    }

    @Test
    public void shouldReturn6WhenMultiplying4By2() {
        assertThat(calculator.calculate("4 2 x")).isEqualTo(8);
    }

    @Test
    public void acceptanceTest() {
        assertThat(calculator.calculate("1 2 + 4 x 3 +")).isEqualTo(15);
    }
}
