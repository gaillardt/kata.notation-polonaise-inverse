package notation1;

import java.util.Map;
import java.util.function.BiFunction;

public class Calculator1 {

    private static final Map<String, BiFunction<Integer, Integer, Integer>> operationByOperator;

    static {
        operationByOperator = Map.of(
                "+", Integer::sum,
                "x", (a, b) -> a * b
        );
    }

    public int calculate(String terms) {
        String[] values = terms.split(" ");

        int result = toInt(values[0]);

        for (int index = 1; index < values.length; index = index + 2) {
            String operator = values[index + 1];
            Integer value = toInt(values[index]);

            result = operationByOperator.get(operator).apply(result, value);
        }

        return result;
    }

    public Integer toInt(String value) {
        return Integer.parseInt(value);
    }
}
