package baseball;


import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Progress {
	baseball.PlayBall playBall = new PlayBall();

	public int run() {
		List<Integer> randomNums = playBall.generateRandomNum();
		getUserInput(randomNums);

		String exitNum = Console.readLine();
		int IntExitNum = Integer.parseInt(exitNum);
		return IntExitNum;
	}

	private void getUserInput(List<Integer> randomNums) {
		List<Integer> userNums = playBall.inputNum();
		String ANSWER_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
		String AFTER_CORRECT_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
		if (playBall.compareNum(randomNums, userNums)) {
			System.out.println(ANSWER_MESSAGE);
			System.out.println(AFTER_CORRECT_MESSAGE);;
			return;
		}

		getUserInput(randomNums);
	}
}
