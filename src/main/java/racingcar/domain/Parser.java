package racingcar.domain;

import java.util.List;

public class Parser {

    private static final String DELIMITER = ",";

    public static List<String> parse(String input) {
        return List.of(input.split(DELIMITER));
    }
}
