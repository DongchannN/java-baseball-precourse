package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        while(true){
            ArrayList randomNumber = generateRandomNum();
            compareNum(generateRandomNum());
            String exitNum = Console.readLine();
            if(exitNum == "2")break;
        }
        System.out.println("프로그램을 종료합니다.");
    }






    public static ArrayList generateRandomNum(){  //generating RandomNumber
        int firstRandomNum = Randoms.pickNumberInRange(1,9);    //세자리 랜덤변수 각각생성
        int secondRandomNum = Randoms.pickNumberInRange(1,9);
        int thirdRandomNum = Randoms.pickNumberInRange(1,9);
        ArrayList listRandomNum = new ArrayList<>();            //리스트로 합치기
        listRandomNum.add(firstRandomNum);
        listRandomNum.add(secondRandomNum);
        listRandomNum.add(thirdRandomNum);
        return listRandomNum;
    }




    public static ArrayList inputNum() {  //scanning the user's number.
        String input;
        while (true) {
            input = Console.readLine();
            if (input.length() != 3) {      //if input's length is not 3 Input again the number.
                System.out.println("숫자 세개를 입력하세요");
                continue;
            }
            break;
        }

        int inputNum = Integer.parseInt(input);  //string to int

        ArrayList listInputNum = new ArrayList<>(); //make list

        while (inputNum > 0) {  //put each Int element to list
            listInputNum.add(inputNum % 10);
            inputNum /= 10;
        }
        Collections.reverse(listInputNum);

        return listInputNum;
    }







    public static void compareNum(ArrayList randomNumber){

        while(true){
            int strike = 0;       //스트라이크, 볼 변수 선언
            int ball = 0;

            System.out.println("숫자를 입력하세요.");

            ArrayList inputNumber = inputNum();    //get the user's number

            ArrayList copiedRandomNumber = new ArrayList<>(); //다룰 수 있는 랜덤 변수값 생성

            copiedRandomNumber.clear();     //반복 시 랜덤 변수값 초기화

            copiedRandomNumber.addAll(randomNumber);  //copying the random number

            //스트라이크 갯수, 스트라이크는 0으로 전환
            for (int i=0; i<3; i++) {
                if (inputNumber.get(i) == randomNumber.get(i)) {
                    strike += 1;
                    inputNumber.set(i, 0);
                    copiedRandomNumber.set(i, 0);
                }
            }

            //중복값 없애기 위해 set 사용
            Set<String> inputSet = new HashSet<String>();
            Set<String> randomSet = new HashSet<String>();
            inputSet.addAll(inputNumber);
            randomSet.addAll(copiedRandomNumber);

            //스트라이크 + 볼 값 구하기
            inputSet.retainAll(randomSet);
            int amountStrikeBall = inputSet.size();

            ball = amountStrikeBall - strike;

            //스트라이크 2개면 볼 음수 -> 볼 0으로 만들기
            if (ball<0){
                ball = 0;
            }


            if (strike == 3) {
                break;
            } else if (strike == 0 && ball == 0) {
                System.out.println("낫싱");

            } else if (strike != 0 && ball == 0) {
                System.out.println(strike + "스트라이크");

            } else if (strike == 0 && ball != 0) {
                System.out.println(ball + "볼");

            } else {
                System.out.println(strike + "스트라이크 " + ball + "볼");
            }
            System.out.println(randomNumber);
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

}
