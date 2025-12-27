package racingcar.domain;

import java.util.List;

public class Validator {

    public static void validateNameLength(List<String> carNemas) {
        if (carNemas.stream().anyMatch(t -> t.length() > 5)) {
            throw new IllegalArgumentException("자동자 이름이 5자 초과입니다.");
        }
    }
}
