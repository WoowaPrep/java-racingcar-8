package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

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

    public void printRound(List<Car> cars) {
        cars.forEach(car ->
                System.out.println(car.getName() + SEPARATOR +
                        POSITION_MARKER.repeat(car.getPosition()))
        );
        System.out.println();
    }

    public void printWinners(List<String> winners) {
        System.out.println(WINNER_PREFIX + String.join(DELIMITER, winners));
    }
}
