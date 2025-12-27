package racingcar.view;

import java.util.List;
import java.util.Map;

public class OutputView {

    private static final String RESULT_HEADER = "실행 결과";
    private static final String WINNER_PREFIX = "최종 우승자 : ";
    private static final String POSITION_MARKER = "-";
    private static final String SEPARATOR = " : ";
    private static final String DELIMITER = ", ";

    public void printRaceStart() {
        System.out.println();
        System.out.println(RESULT_HEADER);
    }

    public void printRound(Map<String, Integer> positions) {
        positions.forEach((name, position) ->
                System.out.println(name + SEPARATOR + POSITION_MARKER.repeat(position))
        );
        System.out.println();
    }

    public void printWinners(List<String> winners) {
        System.out.println(WINNER_PREFIX + String.join(DELIMITER, winners));
    }
}
