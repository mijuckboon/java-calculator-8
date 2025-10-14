package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        InputHandler inputHandler = new InputHandler(input);

        Calculator calculator = new Calculator(inputHandler);

        String trimmedInput = inputHandler.getTrimmedInput();
        int sum = calculator.calculate(trimmedInput);
        System.out.printf("결과 : %d", sum);
    }
}
