package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String CAR_NAMES_INPUT_MESSAGE =
            "경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분)";
    private static final String TRY_COUNT_INPUT_MESSAGE =
            "시도할 횟수는 몇 회인가요?";
    private static final String TRY_COUNT_FORMAT_ERROR =
            "시도 횟수는 숫자여야 합니다.";

    public String readCars() {
        System.out.println(CAR_NAMES_INPUT_MESSAGE);
        return Console.readLine();
    }

    public int readTryCount() {
        System.out.println(TRY_COUNT_INPUT_MESSAGE);
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(TRY_COUNT_FORMAT_ERROR);
        }
    }
}
