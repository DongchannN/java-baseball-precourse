package baseball;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class PlayBall {

	public List<Integer> generateRandomNum() {  //generating RandomNumber
		List<Integer> listRandomNum = new ArrayList<>();

		//make randomNumber
		for (int i = 0; i < 3; i++) {
			int RandomNum = Randoms.pickNumberInRange(1, 9);
			if (listRandomNum.indexOf(RandomNum) == -1) {  //no randomNum in listRandomNum -> push
				listRandomNum.add(RandomNum);
				continue;
			}

			i--;
		}
		return listRandomNum;
	}

	public List<Integer> inputNum() {  //scanning the user's number.
		System.out.println("숫자를 입력하세요.");

		String input;
		input = Console.readLine();
		if (input.length() != 3) {      //if input's length is not 3 Input again the number.
			throw new IllegalArgumentException("3자리 수를 입력하세요.");
		}

		//"321" -> (int) 321
		int inputNum = Integer.parseInt(input);  //string to int
		List<Integer> listInputNum = intToList(inputNum);

		return listInputNum;
	}

	private List<Integer> intToList(int inputNum) {
		List<Integer> listInputNum = new ArrayList<>(); //make list

		while (inputNum > 0) {  //put each Int element to list
			listInputNum.add(inputNum % 10);
			inputNum /= 10;
		}
		Collections.reverse(listInputNum);
		return listInputNum;
	}

	public boolean compareNum(List<Integer> randomNumber, List<Integer> userNums) {
		int strike = 0;       //스트라이크, 볼 변수 선언
		int ball = 0;

		List<Integer> copiedRandomNumber = new ArrayList<>(); //다룰 수 있는 랜덤 변수값 생성

		copiedRandomNumber.clear();     //반복 시 랜덤 변수값 초기화

		copiedRandomNumber.addAll(randomNumber);  //copying the random number

		//스트라이크 갯수
		strike = countStrike(userNums, randomNumber);

		//중복값 없애기 위해 set 사용
		Set<Integer> inputSet = new HashSet<Integer>();
		Set<Integer> randomSet = new HashSet<Integer>();
		inputSet.addAll(userNums);
		randomSet.addAll(copiedRandomNumber);

		//스트라이크 + 볼 값 구하기
		inputSet.retainAll(randomSet);
		int amountStrikeBall = inputSet.size();

		ball = amountStrikeBall - strike;

		if (strike == 3) {
			return true;
		} else if (strike == 0 && ball == 0) {
			System.out.println("낫싱");

		} else if (strike != 0 && ball == 0) {
			System.out.println(strike + "스트라이크");

		} else if (strike == 0 && ball != 0) {
			System.out.println(ball + "볼");

		} else {
			System.out.println(strike + "스트라이크 " + ball + "볼");
		}

		return false;
	}

	public int countStrike(List<Integer> input, List<Integer> random) {
		int strike = 0;
		for (int i = 0; i < 3; i++) {
			if (input.get(i) == random.get(i)) {
				strike += 1;
			}
		}
		return strike;
	}
}
