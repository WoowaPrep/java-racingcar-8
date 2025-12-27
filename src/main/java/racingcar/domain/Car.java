package racingcar.domain;

public class Car {

    private static final int MAX_NAME_LENGTH = 5;
    private static final int INITIAL_POSITION = 0;

    private static final String NAME_EMPTY_ERROR = "자동차 이름은 비어있을 수 없습니다.";
    private static final String NAME_TOO_LONG_ERROR = "자동차 이름은 5자 이하여야 합니다.";

    private final String name;
    private int position;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.position = INITIAL_POSITION;
    }

    private void validateName(String name) {
        validateNotEmpty(name);
        validateLength(name);
    }

    private void validateNotEmpty(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(NAME_EMPTY_ERROR);
        }
    }

    private void validateLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(NAME_TOO_LONG_ERROR);
        }
    }

    public void move(MoveCondition condition) {
        if (condition.shouldMove()) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public boolean isAtPosition(int targetPosition) {
        return this.position == targetPosition;
    }
}
