package racingcar.domain;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;

public class Parser {

    private static final String DELIMITER = ",";

    public static List<String> parse(String input) {
        return Arrays.stream(input.split(DELIMITER))
                .map(String::trim)
                .collect(toList());
    }
}
