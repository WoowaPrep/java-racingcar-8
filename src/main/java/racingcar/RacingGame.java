package racingcar;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.IntStream;
import racingcar.domain.Cars;
import racingcar.domain.Parser;
import racingcar.domain.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {

    private InputView inputView;
    private OutputView outputView;
    private Cars cars;

    public RacingGame() {
        this(new InputView(), new OutputView(), new Cars());
    }

    public RacingGame(InputView inputView, OutputView outputView, Cars cars) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.cars = cars;
    }

    public void start() {
        String Cars = inputView.readCars();
        int tryCount = inputView.readTryCount();

        List<String> carNames = Parser.parse(Cars);
        Validator.validateNameLength(carNames);
        outputView.printResultHeader();
        List<String> winningCars = randomMove(carNames, tryCount);

        outputView.printWinningCars(winningCars);
    }

    private List<String> randomMove(List<String> carNames, int tryCount) {
        IntStream.range(0, tryCount)
                .forEach(i -> {
                    Map<String, Integer> moveCountByCar = cars.randomMove(carNames);
                    outputView.printRound(moveCountByCar);
                });

        return winningCars(cars.getCarPosition());
    }

    private static List<String> winningCars(Map<String, Integer> moveCountByCar) {
        int maxMove = moveCountByCar.values().stream()
                .max(Integer::compareTo)
                .orElse(0);

        return moveCountByCar.entrySet().stream()
                .filter(entry -> entry.getValue() == maxMove)
                .map(Entry::getKey)
                .collect(toList());
    }
}
