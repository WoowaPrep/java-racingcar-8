package racingcar.domain;

import static java.util.stream.Collectors.toList;

import java.util.Collections;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<String> carNames) {
        this.cars = carNames.stream()
                .map(Car::new)
                .collect(toList());
    }

    public void move(MoveCondition condition) {
        cars.forEach(car -> car.move(condition));
    }

    public List<String> findWinners() {
        int maxPosition = findMaxPosition();
        return cars.stream()
                .filter(car -> car.isAtPosition(maxPosition))
                .map(Car::getName)
                .collect(toList());
    }

    private int findMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
