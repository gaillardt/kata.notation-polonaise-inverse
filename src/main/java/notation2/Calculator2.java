package notation2;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class Calculator2 {
    private static final Map<String, BiFunction<Integer, Integer, Integer>> operationByOperator = Map.of(
        "+", Integer::sum,
        "x", (a, b) -> a * b
    );

    public int calculate(String terms) {
        List<String> termsSplitted = Arrays.asList(terms.split(" "));

        int splitIndex = ((termsSplitted.size() - 1) / 2) + 1;

        List<Integer> values = termsSplitted.subList(1, splitIndex).stream()
                .map(this::toInt)
                .collect(Collectors.toList());

        List<String> operators = termsSplitted.subList(splitIndex, termsSplitted.size());

        int result = toInt(termsSplitted.get(0));

        for (int index = 0; index < values.size(); index++) {
            String operator = operators.get(index);
            int value = values.get(index);

            result = operationByOperator.get(operator).apply(result, value);
        }

        return result;
    }

    private int toInt(String value) {
        return Integer.parseInt(value);
    }
}
