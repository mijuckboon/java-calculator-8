package calculator;

import camp.nextstep.edu.missionutils.Console;

/**
 * 계산기 프로그램의 진입점 클래스
 * 사용자로부터 입력을 받아 합계를 계산하고 출력
 */
public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        InputHandler inputHandler = new InputHandler(input);

        Calculator calculator = new Calculator(inputHandler);

        String trimmedInput = inputHandler.getTrimmedInput();
        int sum = calculator.computeSum(trimmedInput);
        System.out.printf("결과 : %d", sum);
    }
}
