package calculator;

import java.util.Arrays;

/**
 * 계산 로직을 담당하는 클래스
 */
public class Calculator {
    private final InputHandler inputHandler;

    // 생성자를 통한 의존성 주입
    public Calculator(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }

    /**
     * 계산 결과를 반환하는 메서드
     * @param input 입력받은 문자열
     * @return 합 계산 결과
     */
    public int computeSum(String input) {
        if (input.isBlank()) { // 빈 문자 예외 처리
            return 0;
        }

        final int[] numbers = getNumbersToAdd(input);
        return Arrays.stream(numbers).sum();
    }

    private int[] getNumbersToAdd(String input) {
        final String separatorsRegex = inputHandler.getSeparatorsRegex();

        return Arrays.stream(input.split(separatorsRegex))
                .mapToInt(str -> {
                    final int number = Integer.parseInt(str);
                    validate(number);
                    return number;
                })
                .toArray();
    }

    private void validate(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("더하는 수는 양수여야 합니다. (잘못된 값: %d)".formatted(number));
        }
    }

}
