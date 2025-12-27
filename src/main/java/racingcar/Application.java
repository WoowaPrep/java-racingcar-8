package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        try {
            new RacingGame().start();
        } finally {
            Console.close();
        }
    }
}
