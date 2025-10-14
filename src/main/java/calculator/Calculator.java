package calculator;

import java.util.Arrays;

public class Calculator {
    private final InputHandler inputHandler;

    // 생성자를 통한 의존성 주입
    public Calculator(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }

    public int calculate(String input) {
        if (input.isBlank()) { // 빈 문자 예외 처리
            return 0;
        }

        String seperatorsRegex = inputHandler.getSeparatorsRegex();
        return Arrays.stream(input.split(seperatorsRegex))
                .map(Integer::parseInt)
                .mapToInt(x -> x)
                .sum();
    }

}
