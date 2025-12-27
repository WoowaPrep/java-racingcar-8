package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Cars {

    private static final int randomStartNumber = 0;
    private static final int randomEndNumber = 9;
    private final Map<String, Integer> carPosition = new TreeMap<>();

    public Map<String, Integer> randomMove(List<String> carNames) {
        initializeCarPositions(carNames);
        carNames.stream()
                .filter(car -> Randoms.pickNumberInRange(randomStartNumber, randomEndNumber) >= 4)
                .forEach(t -> carPosition.put(t, carPosition.get(t) + 1));

        return carPosition;
    }

    private void initializeCarPositions(List<String> carNames) {
        for (String carName : carNames) {
            carPosition.putIfAbsent(carName, 0);
        }
    }

    public Map<String, Integer> getCarPosition() {
        return carPosition;
    }
}
