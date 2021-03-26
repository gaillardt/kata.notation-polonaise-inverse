package notation2;

import java.util.Map;
import java.util.function.BiFunction;

public class Calculator2 {
    private static final Map<String, BiFunction<Integer, Integer, Integer>> operationByOperator = Map.of(
        "+", Integer::sum,
        "x", (a, b) -> a * b
    );

    public int calculate(String terms) {
        String[] values = terms.split(" ");

        int operatorsOffset = (values.length - 1) / 2;

        int result = toInt(values[0]);

        for (int index = 1; index <= operatorsOffset; index++) {
            int value = toInt(values[index]);
            String operator = values[index + operatorsOffset];

            result = operationByOperator.get(operator).apply(result, value);
        }

        return result;
    }

    private int toInt(String value) {
        return Integer.parseInt(value);
    }
}
