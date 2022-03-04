package baseball;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class Progress {
	PlayBall playBall = new PlayBall();

	public int run() {
		List<Integer> randomNums = playBall.generateRandomNum();
		getUserInput(randomNums);

		String exitNum = Console.readLine();
		int IntExitNum = Integer.parseInt(exitNum);
		return IntExitNum;
	}

	private void getUserInput(List<Integer> randomNums) {
		List<Integer> userNums = playBall.inputNum();

		if (playBall.compareNum(randomNums, userNums)) {
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
			System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
			return;
		}

		getUserInput(randomNums);
	}
}
