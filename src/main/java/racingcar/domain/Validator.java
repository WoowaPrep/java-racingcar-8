package racingcar.domain;

import java.util.List;

public class Validator {

    private static final String CAR_NAMES_EMPTY_ERROR = "자동차 이름을 입력해주세요.";
    private static final String TRY_COUNT_INVALID_ERROR = "시도 횟수는 1 이상이어야 합니다.";

    private static final int MIN_TRY_COUNT = 1;

    public static void validateRaceInput(List<String> carNames, int tryCount) {
        validateCarNamesNotEmpty(carNames);
        validateTryCount(tryCount);
    }

    private static void validateCarNamesNotEmpty(List<String> carNames) {
        if (carNames == null || carNames.isEmpty()) {
            throw new IllegalArgumentException(CAR_NAMES_EMPTY_ERROR);
        }
    }

    public static void validateTryCount(int tryCount) {
        if (tryCount < MIN_TRY_COUNT) {
            throw new IllegalArgumentException(TRY_COUNT_INVALID_ERROR);
        }
    }
}


