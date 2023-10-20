package baseball;

import baseball.domain.Computer;
import baseball.models.Models;
import baseball.utils.Utils;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Game {
    final int OUT = 3;
    Models models = new Models();

    public void run() {
        Computer Utils;
        List<Integer> computer = Computer.generateRandomNumber(3);
        boolean gameFinished = false;

        while (!gameFinished) {
            List<Integer> user = getUserNumber();
            playBall(computer, user, models);
            showResult(models);

            if (models.getStrikes() == OUT) {
                gameFinished = true;
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            }
        }
    }

    public List<Integer> getUserNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = readLine();
        Utils.validateStringThreeDifferentDigits(userInput);
        return Utils.stringToIntegerList(userInput);
    }

    public void playBall(List<Integer> computer, List<Integer> user, Models models) {
        int strikes = models.countStrike(computer, user);
        int balls = models.countBall(computer, user);
        models.setScore(strikes, balls);
    }

    public void showResult(Models models) {
        models.printGameResult(models.getStrikes(), models.getBalls());
    }
}

