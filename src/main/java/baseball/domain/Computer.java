package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    public static List<Integer> generateRandomNumber(int length) {
        List<Integer> computerRandomNumber = new ArrayList<>();
        while (computerRandomNumber.size() < length) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerRandomNumber.contains(randomNumber)) {
                computerRandomNumber.add(randomNumber);
            }
        }
        return computerRandomNumber;
    }


}
