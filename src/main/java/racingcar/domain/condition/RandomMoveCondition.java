package racingcar.domain.condition;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.MoveCondition;

public class RandomMoveCondition implements MoveCondition {

    private static final int RANDOM_START = 0;
    private static final int RANDOM_END = 9;
    private static final int MOVE_THRESHOLD = 4;

    @Override
    public boolean shouldMove() {
        int randomValue = Randoms.pickNumberInRange(RANDOM_START, RANDOM_END);
        return randomValue >= MOVE_THRESHOLD;
    }
}
