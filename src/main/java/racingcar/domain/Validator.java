package racingcar.domain;

import java.util.List;

public class Validator {

    private static final String CAR_NAMES_EMPTY_ERROR = "자동차 이름을 입력해주세요.";
    private static final String CAR_NAME_TOO_LONG_ERROR = "자동차 이름은 5자 이하여야 합니다.";
    private static final String TRY_COUNT_INVALID_ERROR = "시도 횟수는 1 이상이어야 합니다.";

    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_TRY_COUNT = 1;

    public static void validateRaceInput(List<String> carNames, int tryCount) {
        validateCarNames(carNames);
        validateTryCount(tryCount);
    }

    public static void validateCarNames(List<String> carNames) {
        validateNotEmpty(carNames);
        validateAllNameLength(carNames);
    }

    private static void validateNotEmpty(List<String> carNames) {
        if (carNames == null || carNames.isEmpty()) {
            throw new IllegalArgumentException(CAR_NAMES_EMPTY_ERROR);
        }
    }

    private static void validateAllNameLength(List<String> carNames) {
        if (carNames.stream().anyMatch(name -> name.length() > MAX_NAME_LENGTH)) {
            throw new IllegalArgumentException(CAR_NAME_TOO_LONG_ERROR);
        }
    }

    public static void validateTryCount(int tryCount) {
        if (tryCount < MIN_TRY_COUNT) {
            throw new IllegalArgumentException(TRY_COUNT_INVALID_ERROR);
        }
    }
}
