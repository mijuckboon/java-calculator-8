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

        int[] numbers = getNumbers(input);
        return Arrays.stream(numbers).sum();
    }

    private int[] getNumbers(String input) {
        String seperatorsRegex = inputHandler.getSeparatorsRegex();

        return Arrays.stream(input.split(seperatorsRegex))
                .mapToInt(x -> {
                    int number = Integer.parseInt(x);
                    validate(number);
                    return number;
                })
                .toArray();
    }

    private void validate(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("더하는 수는 양수여야 합니다.");
        }
    }

}
