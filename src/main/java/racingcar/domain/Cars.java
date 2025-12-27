package racingcar.domain;

import static java.util.stream.Collectors.toList;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Cars {

    private static final int RANDOM_START_NUMBER = 0;
    private static final int RANDOM_END_NUMBER = 9;
    private static final int MOVE_THRESHOLD = 4;
    private final Map<String, Integer> carPositions = new LinkedHashMap<>();

    public Cars(List<String> carNames) {
        initializeCarPositions(carNames);
    }

    private void initializeCarPositions(List<String> carNames) {
        carNames.forEach(name -> carPositions.put(name, 0));
    }

    public void move() {
        carPositions.keySet().stream()
                .filter(car -> shouldMove())
                .forEach(name -> carPositions.put(name, carPositions.get(name) + 1));
    }

    private static boolean shouldMove() {
        return Randoms.pickNumberInRange(RANDOM_START_NUMBER, RANDOM_END_NUMBER) >= MOVE_THRESHOLD;
    }

    public List<String> findWinners() {
        int maxPosition = carPositions.values().stream()
                .max(Integer::compareTo)
                .orElse(0);

        return carPositions.entrySet().stream()
                .filter(entry -> entry.getValue() == maxPosition)
                .map(Entry::getKey)
                .collect(toList());
    }

    public Map<String, Integer> getCarPositions() {
        return Collections.unmodifiableMap(carPositions);
    }
}
