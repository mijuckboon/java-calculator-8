package calculator;

import java.util.Arrays;
import java.util.List;

public class Calculator {
    private static final List<String> DEFAULT_SEPARATORS = List.of(",", ":");

    private String customSeparator;

    public int calculate(String input) {
        if (input.isBlank()) { // 빈 문자 예외 처리
            return 0;
        }

        String seperatorsRegex = separatorsRegex();
        return Arrays.stream(input.split(seperatorsRegex))
                .map(Integer::parseInt)
                .mapToInt(x -> x)
                .sum();
    }

    private String separatorsRegex() {
        StringBuilder regexBuilder = new StringBuilder();
        for (String separator : DEFAULT_SEPARATORS) {
            regexBuilder.append(separator);
            regexBuilder.append("|"); // or
        }

        return regexBuilder.substring(0, regexBuilder.length() - 1);
    }
}
