package racingcar.view;

import static java.util.stream.Collectors.joining;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class OutputView {

    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String WINNING_MESSAGE = "최종 우승자 : ";
    private static final String CAR_MOVE_MARKER = "-";
    private static final String DELIMITER = ", ";
    private static final String IS = " : ";

    public void printRound(Map<String, Integer> moveCountByCar) {
        for (Entry<String, Integer> stringIntegerEntry : moveCountByCar.entrySet()) {
            System.out.println(stringIntegerEntry.getKey() + IS +
                    CAR_MOVE_MARKER.repeat(stringIntegerEntry.getValue()));
        }
        System.out.println();
    }

    public void printResultHeader() {
        System.out.println(RESULT_MESSAGE);
    }

    public void printWinningCars(List<String> cars) {
        System.out.print(WINNING_MESSAGE + cars.stream().collect(joining(DELIMITER)));
    }
}
