package racingcar;

import java.util.List;
import java.util.stream.IntStream;
import racingcar.domain.Cars;
import racingcar.domain.MoveCondition;
import racingcar.domain.Parser;
import racingcar.domain.condition.RandomMoveCondition;
import racingcar.domain.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {

    private final InputView inputView;
    private final OutputView outputView;
    private final MoveCondition moveCondition;

    public RacingGame() {
        this(new InputView(), new OutputView(), new RandomMoveCondition());
    }

    public RacingGame(InputView inputView, OutputView outputView, MoveCondition moveCondition) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.moveCondition = moveCondition;
    }

    public void start() {
        String carNamesInput = inputView.readCars();
        int tryCount = inputView.readTryCount();

        List<String> carNames = Parser.parse(carNamesInput);
        Validator.validateRaceInput(carNames, tryCount);

        Cars cars = new Cars(carNames);
        List<String> winners = race(cars, tryCount);
        outputView.printWinners(winners);
    }

    private List<String> race(Cars cars, int tryCount) {
        outputView.printRaceStart();

        IntStream.range(0, tryCount)
                .forEach(i -> playRound(cars));

        return cars.findWinners();
    }

    private void playRound(Cars cars) {
        cars.move(moveCondition);
        outputView.printRound(cars.getCars());
    }
}
